package com.azship.shipping.application.usecase;

import com.azship.shipping.domain.exception.ResourceNotFoundException;
import com.azship.shipping.domain.model.Freight;
import com.azship.shipping.domain.repository.FreightRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.UUID;

@Service
public class UpdateFreightUseCase {

    private final FreightRepository freightRepository;

    public UpdateFreightUseCase(FreightRepository freightRepository) {
        this.freightRepository = freightRepository;
    }

    public Freight execute(UUID id,
                           String description,
                           Map<String, Object> properties) {

        Freight existing = freightRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Frete não encontrado"));

        Freight updated = new Freight(
                existing.getId(),
                existing.getClientId(), // clientId não muda
                description,
                properties,
                existing.getCreatedAt(),
                LocalDateTime.now()
        );

        return freightRepository.save(updated);
    }
}
