package com.azship.shipping.application.usecase;

import com.azship.shipping.domain.exception.ResourceNotFoundException;
import com.azship.shipping.domain.model.Freight;
import com.azship.shipping.domain.repository.FreightRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class GetFreightByIdUseCase {

    private final FreightRepository freightRepository;

    public GetFreightByIdUseCase(FreightRepository freightRepository) {
        this.freightRepository = freightRepository;
    }

    public Freight execute(UUID id) {
        return freightRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Frete não encontrado"));
    }
}
