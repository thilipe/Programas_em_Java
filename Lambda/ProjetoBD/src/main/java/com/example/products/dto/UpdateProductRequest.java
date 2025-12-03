package com.example.products.dto;

public class UpdateProductRequest {

    private String name;
    private double price;

    public UpdateProductRequest() {}

    public UpdateProductRequest(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() { return name; }
    public double getPrice() { return price; }

    public void setName(String name) { this.name = name; }
    public void setPrice(double price) { this.price = price; }
}
