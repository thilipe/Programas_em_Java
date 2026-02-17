# ADM AZS Shipping

Sistema de gestão de fretes desenvolvido como solução para o desafio backend da AZShip.

A aplicação permite realizar o CRUD de fretes com propriedades dinâmicas por cliente, utilizando PostgreSQL com JSONB e arquitetura Port & Adapter (Hexagonal).

---

## Tecnologias utilizadas

- Java 17
- Spring Boot 3
- PostgreSQL
- Flyway
- Docker e Docker Compose
- Arquitetura Hexagonal (Port & Adapter)

---

## Como executar o projeto

### 1. Gerar o build da aplicação

Execute no terminal:

mvn clean package

---

### 2. Subir aplicação + banco via Docker

Execute:

docker-compose up --build

---

A aplicação ficará disponível em:

http://localhost:8080

---

## Endpoints

### Criar Frete
POST /freights

Exemplo de JSON:

{
"clientId": "client-123",
"description": "Frete São Paulo",
"properties": {
"weight": 1200,
"origin": "Santos"
}
}

---

### Buscar Fretes (com filtro e paginação)
GET /freights?query=Santos&page=0&size=10

---

### Buscar por ID
GET /freights/{id}

---

### Atualizar Frete
PUT /freights/{id}

---

### Remover Frete
DELETE /freights/{id}

---

## Arquitetura

O projeto foi estruturado seguindo o padrão Port & Adapter (Arquitetura Hexagonal), separando:

- Domínio (regra de negócio)
- Casos de uso (Application)
- Adapters de entrada (REST)
- Adapters de saída (Persistência JPA)
- Infraestrutura (PostgreSQL + Docker)

---
