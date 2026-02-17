package com.azship.shipping.adapter.outbound.persistence.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "freight")
public class FreightEntity {

    @Id
    private UUID id;

    @Column(name = "client_id", nullable = false)
    private String clientId;

    private String description;

    @JdbcTypeCode(SqlTypes.JSON)
    @Column(columnDefinition = "jsonb")
    private String properties;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;

    // Construtor vazio obrigatório para JPA
    protected FreightEntity() {
    }

    public FreightEntity(UUID id,
                         String clientId,
                         String description,
                         String properties,
                         LocalDateTime createdAt,
                         LocalDateTime updatedAt) {

        this.id = id;
        this.clientId = clientId;
        this.description = description;
        this.properties = properties;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public UUID getId() {
        return id;
    }

    public String getClientId() {
        return clientId;
    }

    public String getDescription() {
        return description;
    }

    public String getProperties() {
        return properties;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }
}
