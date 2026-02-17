package com.azship.shipping.adapter.outbound.persistence.repository;

import com.azship.shipping.adapter.outbound.persistence.entity.FreightEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.domain.Pageable;

import java.util.UUID;

public interface FreightJpaRepository extends JpaRepository<FreightEntity, UUID> {

    /*CODIGO SQL :)*/
    @Query("""
        SELECT f FROM FreightEntity f
        WHERE LOWER(f.description) LIKE LOWER(CONCAT('%', :query, '%'))
           OR CAST(f.properties AS string) LIKE CONCAT('%', :query, '%')
    """)
    Page<FreightEntity> search(String query, Pageable pageable);

}
