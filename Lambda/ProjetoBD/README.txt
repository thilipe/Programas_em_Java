README - Products API (Serverless Java AWS Lambda)

Products API – Serverless Java (AWS Lambda + API Gateway)

Este projeto implementa uma API REST completa, totalmente serverless,
usando:

-   AWS Lambda
-   API Gateway
-   Java 17
-   Arquitetura limpa (Handler → Controller → Service → DTO → Model)
-   Maven + Shade Plugin

A API permite criar, listar, buscar e remover produtos via HTTP, sem
necessidade de servidores. A infraestrutura é totalmente gerenciada pela
AWS.

API Pública:
https://6qkzwrfg7f.execute-api.us-east-2.amazonaws.com/prod/products

Arquitetura do Projeto: src/main/java/com/example/products │ ├── handler
│ ProductHandler.java → Entrada da Lambda │ ├── controller │
ProductController.java → Processa rotas │ ├── service │
ProductService.java → Lógica de negócio │ ├── model │ Product.java →
Entidade │ └── dto CreateProductRequest.java → Entrada
ProductResponse.java → Saída

Tecnologias Utilizadas: Java 17 AWS Lambda Amazon API Gateway Jackson
Databind AWS Lambda Java Core AWS Lambda Java Events Maven Maven Shade
Plugin

Empacotando o Projeto: mvn clean package

Arquivo gerado: target/ProjetoBD-1.0-SNAPSHOT-shaded.jar

Handler da Lambda:
com.example.products.handler.ProductHandler::handleRequest

Rotas da API: POST /products GET /products GET /products/{id} DELETE
/products/{id}

Exemplo POST: { “name”: “Geladeira”, “price”: 3500 }

Exemplo GET: [ { “id”: 1, “name”: “Geladeira”, “price”: 3500.0 }]

Fluxo da Requisição: Cliente → API Gateway → Lambda Handler → Controller
→ Service → DTO → Resposta HTTP

Benefícios da Arquitetura: - Código limpo - Baixa manutenção -
Escalável - Fácil integração com bancos e serviços AWS - Padrão
profissional usado em empresas

Autor: Felipe Alves – Desenvolvedor Java | AWS | Serverless
