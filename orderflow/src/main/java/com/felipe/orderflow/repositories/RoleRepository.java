package com.felipe.orderflow.repositories;

import com.felipe.orderflow.entities.Role;
import com.felipe.orderflow.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByAuthority(String authority);
}

