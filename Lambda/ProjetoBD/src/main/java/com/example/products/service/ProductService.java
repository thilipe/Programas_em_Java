package com.example.products.service;

import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyRequestEvent;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyResponseEvent;
import com.example.products.dto.CreateProductRequest;
import com.example.products.dto.ProductResponse;
import com.example.products.dto.UpdateProductRequest;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.HashMap;
import java.util.Map;

public class ProductService {

    private final ObjectMapper mapper = new ObjectMapper();

    // SIMULA UM BANCO DE DADOS IN-MEMORY
    private static final Map<Integer, ProductResponse> database = new HashMap<>();
    private static int idCounter = 1;

    public APIGatewayProxyResponseEvent create(APIGatewayProxyRequestEvent event) {
        try {
            // converte JSON para DTO
            CreateProductRequest dto = mapper.readValue(event.getBody(), CreateProductRequest.class);

            ProductResponse product = new ProductResponse(idCounter++, dto.getName(), dto.getPrice());

            database.put(product.getId(), product);

            return new APIGatewayProxyResponseEvent()
                    .withStatusCode(201)
                    .withBody(mapper.writeValueAsString(product));

        } catch (Exception e) {
            return error(e.getMessage());
        }
    }

    public APIGatewayProxyResponseEvent getById(APIGatewayProxyRequestEvent event) {
        try {
            int id = Integer.parseInt(event.getPathParameters().get("id"));

            ProductResponse product = database.get(id);

            if (product == null) {
                return new APIGatewayProxyResponseEvent()
                        .withStatusCode(404)
                        .withBody("{\"error\":\"Product not found\"}");
            }

            return new APIGatewayProxyResponseEvent()
                    .withStatusCode(200)
                    .withBody(mapper.writeValueAsString(product));

        } catch (Exception e) {
            return error(e.getMessage());
        }
    }

    public APIGatewayProxyResponseEvent getAll() {
        try {
            Collection<ProductResponse> products = database.values();

            return new APIGatewayProxyResponseEvent()
                    .withStatusCode(200)
                    .withBody(mapper.writeValueAsString(products));

        } catch (Exception e) {
            return error(e.getMessage());
        }
    }

    public APIGatewayProxyResponseEvent delete(APIGatewayProxyRequestEvent event) {
        try {
            int id = Integer.parseInt(event.getPathParameters().get("id"));

            database.remove(id);

            return new APIGatewayProxyResponseEvent()
                    .withStatusCode(204);

        } catch (Exception e) {
            return error(e.getMessage());
        }
    }

    private APIGatewayProxyResponseEvent error(String message) {
        return new APIGatewayProxyResponseEvent()
                .withStatusCode(500)
                .withBody("{\"error\":\"" + message + "\"}");
    }

    public APIGatewayProxyResponseEvent update(APIGatewayProxyRequestEvent event) {
        try {
            int id = Integer.parseInt(event.getPathParameters().get("id"));

            ProductResponse product = database.get(id);

            if (product == null) {
                return new APIGatewayProxyResponseEvent()
                        .withStatusCode(404)
                        .withBody("{\"error\":\"Product not found\"}");
            }

            // Converter JSON para DTO
            UpdateProductRequest dto = mapper.readValue(event.getBody(), UpdateProductRequest.class);

            // Atualizar valores
            product.setName(dto.getName());
            product.setPrice(dto.getPrice());

            // Salvar de volta
            database.put(id, product);

            return new APIGatewayProxyResponseEvent()
                    .withStatusCode(200)
                    .withBody(mapper.writeValueAsString(product));

        } catch (Exception e) {
            return error(e.getMessage());
        }
    }

}
