CREATE TABLE freight (
    id UUID PRIMARY KEY,
    client_id VARCHAR(100) NOT NULL,
    description VARCHAR(255),
    properties JSONB,
    created_at TIMESTAMP NOT NULL,
    updated_at TIMESTAMP NOT NULL
);
