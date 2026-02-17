package com.azship.shipping.application.usecase;

import com.azship.shipping.domain.model.Freight;
import com.azship.shipping.domain.repository.FreightRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class SearchFreightUseCase {

    private final FreightRepository freightRepository;

    public SearchFreightUseCase(FreightRepository freightRepository) {
        this.freightRepository = freightRepository;
    }

    public Page<Freight> execute(String query, Pageable pageable) {
        return freightRepository.search(query, pageable);
    }
}
