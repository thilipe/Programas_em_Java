package com.azship.shipping.application.usecase;

import com.azship.shipping.domain.exception.ResourceNotFoundException;
import com.azship.shipping.domain.repository.FreightRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class DeleteFreightUseCase {

    private final FreightRepository freightRepository;

    public DeleteFreightUseCase(FreightRepository freightRepository) {
        this.freightRepository = freightRepository;
    }

    public void execute(UUID id) {

        if (freightRepository.findById(id).isEmpty()) {
            throw new ResourceNotFoundException("Frete não encontrado");
        }

        freightRepository.deleteById(id);
    }
}
