package com.felipe.orderflow.repositories;

import com.felipe.orderflow.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
}
