package com.azship.shipping.domain.model;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.UUID;

public class Freight {

    private UUID id;
    private String clientId;
    private String description;
    private Map<String, Object> properties;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public Freight(UUID id,
                   String clientId,
                   String description,
                   Map<String, Object> properties,
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

    public Map<String, Object> getProperties() {
        return properties;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }
}
