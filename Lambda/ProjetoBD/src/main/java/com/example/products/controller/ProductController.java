package com.example.products.controller;

import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyRequestEvent;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyResponseEvent;
import com.example.products.service.ProductService;

public class ProductController {

    private final ProductService service = new ProductService();

    public APIGatewayProxyResponseEvent handle(APIGatewayProxyRequestEvent event) {

        String method = event.getHttpMethod();
        String path = event.getPath();

        switch (method) {
            case "POST":
                return service.create(event);

            case "GET":
                if (path.matches("/products/\\d+")) {
                    return service.getById(event);
                }
                return service.getAll();

            case "DELETE":
                return service.delete(event);

            case "PUT":
                return service.update(event);


            default:
                return new APIGatewayProxyResponseEvent()
                        .withStatusCode(400)
                        .withBody("{\"error\":\"Método não suportado\"}");
        }
    }
}
