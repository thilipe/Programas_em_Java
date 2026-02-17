package com.azship.shipping.domain.repository;

import com.azship.shipping.domain.model.Freight;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;
import java.util.UUID;

public interface FreightRepository {

    Freight save(Freight freight);

    Optional<Freight> findById(UUID id);

    Page<Freight> search(String query, Pageable pageable);

    void deleteById(UUID id);
}
