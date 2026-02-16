package com.felipe.orderflow.services;

import com.felipe.orderflow.dto.ClientDTO;
import com.felipe.orderflow.dto.ViaCepDTO;
import com.felipe.orderflow.entities.Client;
import com.felipe.orderflow.integrations.ViaCepClient;
import com.felipe.orderflow.repositories.ClientRepository;
import com.felipe.orderflow.exceptions.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClientService {

    private final ClientRepository repository;
    private final ViaCepClient viaCepClient;


    @Transactional(readOnly = true)
    public List<ClientDTO> findAll() {
        return repository.findAll().stream().map(ClientDTO::new).toList();
    }

    @Transactional(readOnly = true)
    public ClientDTO findById(Long id) {
        Client entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Cliente não encontrado"));
        return new ClientDTO(entity);
    }

    @Transactional
    public ClientDTO insert(ClientDTO dto) {

        Client entity = new Client();

        copyDtoToEntity(dto, entity);

        ViaCepDTO address = viaCepClient.searchCep(entity.getZipCode());
        entity.setStreet(address.getLogradouro());
        entity.setCity(address.getLocalidade());
        entity.setState(address.getUf());
        entity.setNumber("S/N"); // pode vir do DTO ou deixar manual

        entity = repository.save(entity);
        return new ClientDTO(entity);
    }

    @Transactional
    public ClientDTO update(Long id, ClientDTO dto) {
        Client entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Cliente não encontrado"));
        copyDtoToEntity(dto, entity);
        entity = repository.save(entity);
        return new ClientDTO(entity);
    }

    public void delete(Long id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Cliente não encontrado");
        }
        repository.deleteById(id);
    }

    private void copyDtoToEntity(ClientDTO dto, Client entity) {
        entity.setName(dto.getName());
        entity.setEmail(dto.getEmail());

        // --- CORREÇÃO AQUI ---
        // O comando replaceAll("\\D", "") troca tudo que NÃO for Dígito (\D) por vazio.
        // Transformando "123.456.789-00" em "12345678900" (11 dígitos).
        if (dto.getCpf() != null) {
            entity.setCpf(dto.getCpf().replaceAll("\\D", ""));
        }

        entity.setPhone(dto.getPhone());
        entity.setStreet(dto.getStreet());
        entity.setNumber(dto.getNumber());
        entity.setCity(dto.getCity());
        entity.setState(dto.getState());
        entity.setZipCode(dto.getZipCode());
    }
}
