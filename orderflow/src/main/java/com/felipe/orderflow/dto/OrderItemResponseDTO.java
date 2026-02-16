package com.felipe.orderflow.dto;

import com.felipe.orderflow.entities.OrderItem;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderItemResponseDTO {

    private Long productId;
    private String productName;
    private Integer quantity;
    private Double price;
    private Double subTotal;

    public OrderItemResponseDTO(OrderItem item) {
        this.productId = item.getProduct().getId();
        this.productName = item.getProduct().getName();
        this.quantity = item.getQuantity();
        this.price = item.getPrice();
        this.subTotal = item.getSubTotal();
    }
}
