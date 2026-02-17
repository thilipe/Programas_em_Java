package com.azship.shipping.adapter.outbound.persistence;

import com.azship.shipping.adapter.outbound.persistence.entity.FreightEntity;
import com.azship.shipping.adapter.outbound.persistence.repository.FreightJpaRepository;
import com.azship.shipping.domain.model.Freight;
import com.azship.shipping.domain.repository.FreightRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.Map;
import java.util.Optional;
import java.util.UUID;

@Repository
public class FreightPersistenceAdapter implements FreightRepository {

    private final FreightJpaRepository jpaRepository;
    private final ObjectMapper objectMapper;

    public FreightPersistenceAdapter(FreightJpaRepository jpaRepository,
                                     ObjectMapper objectMapper) {
        this.jpaRepository = jpaRepository;
        this.objectMapper = objectMapper;
    }

    @Override
    public Freight save(Freight freight) {

        FreightEntity entity = toEntity(freight);

        FreightEntity saved = jpaRepository.save(entity);

        return toDomain(saved);
    }

    @Override
    public Optional<Freight> findById(UUID id) {
        return jpaRepository.findById(id)
                .map(this::toDomain);
    }

    @Override
    public Page<Freight> search(String query, Pageable pageable) {

        Page<FreightEntity> page = jpaRepository.search(query, pageable);

        return page.map(this::toDomain);
    }

    @Override
    public void deleteById(UUID id) {
        jpaRepository.deleteById(id);
    }

    private FreightEntity toEntity(Freight freight) {

        try {
            String json = objectMapper.writeValueAsString(freight.getProperties());

            return new FreightEntity(
                    freight.getId(),
                    freight.getClientId(),
                    freight.getDescription(),
                    json,
                    freight.getCreatedAt(),
                    freight.getUpdatedAt()
            );

        } catch (JsonProcessingException e) {
            throw new RuntimeException("Erro ao converter o properties para JSON", e);
        }
    }

    private Freight toDomain(FreightEntity entity) {

        try {
            Map<String, Object> properties =
                    objectMapper.readValue(entity.getProperties(), Map.class);

            return new Freight(
                    entity.getId(),
                    entity.getClientId(),
                    entity.getDescription(),
                    properties,
                    entity.getCreatedAt(),
                    entity.getUpdatedAt()
            );

        } catch (JsonProcessingException e) {
            throw new RuntimeException("Erro ao converter JSON para properties", e);
        }
    }
}
