package com.felipe.orderflow.entities;

import com.felipe.orderflow.entities.pk.OrderItemPK;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "PedidoItem")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderItem {

    @EmbeddedId
    private OrderItemPK id = new OrderItemPK();

    private Integer quantity;
    private Double price;

    public Double getSubTotal() {
        return price * quantity;
    }

    // Getter shortcut
    public Order getOrder() {
        return id.getOrder();
    }

    public void setOrder(Order order) {
        id.setOrder(order);
    }

    public Product getProduct() {
        return id.getProduct();
    }

    public void setProduct(Product product) {
        id.setProduct(product);
    }
}
