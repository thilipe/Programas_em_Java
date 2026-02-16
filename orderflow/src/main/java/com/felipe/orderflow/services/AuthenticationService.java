package com.felipe.orderflow.services;

import com.felipe.orderflow.dto.LoginDTO;
import com.felipe.orderflow.dto.RegisterDTO;
import com.felipe.orderflow.entities.Role;
import com.felipe.orderflow.entities.User;
import com.felipe.orderflow.repositories.RoleRepository;
import com.felipe.orderflow.repositories.UserRepository;
import com.felipe.orderflow.security.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final UserRepository userRepo;
    private final RoleRepository roleRepo;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    public String register(RegisterDTO dto) {

        if (userRepo.findByUsername(dto.getUsername()).isPresent()) {
            throw new RuntimeException("Usuário já existe");
        }

        Role role = roleRepo.findByAuthority("ROLE_USER")
                .orElseThrow(() -> new RuntimeException("Role não encontrada"));

        User user = User.builder()
                .username(dto.getUsername())
                .password(passwordEncoder.encode(dto.getPassword()))
                .build();

        user.getRoles().add(role);

        userRepo.save(user);

        return jwtService.generateToken(user);
    }

    public String login(LoginDTO dto) {
        User user = userRepo.findByUsername(dto.getUsername())
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        if (!passwordEncoder.matches(dto.getPassword(), user.getPassword())) {
            throw new RuntimeException("Senha inválida");
        }

        return jwtService.generateToken(user);
    }

}
