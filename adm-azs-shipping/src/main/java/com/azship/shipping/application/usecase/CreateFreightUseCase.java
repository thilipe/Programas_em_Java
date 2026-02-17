package com.azship.shipping.application.usecase;

import com.azship.shipping.domain.model.Freight;
import com.azship.shipping.domain.repository.FreightRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.UUID;

@Service
public class CreateFreightUseCase {

    private final FreightRepository freightRepository;

    public CreateFreightUseCase(FreightRepository freightRepository) {
        this.freightRepository = freightRepository;
    }

    public Freight execute(String clientId,
                           String description,
                           Map<String, Object> properties) {

        Freight freight = new Freight(
                UUID.randomUUID(),
                clientId,
                description,
                properties,
                LocalDateTime.now(),
                LocalDateTime.now()
        );

        return freightRepository.save(freight);
    }
}
