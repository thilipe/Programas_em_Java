package com.felipe.orderflow.dto;

import com.felipe.orderflow.entities.Order;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;
import java.util.List;

@Getter
@Setter

public class OrderResponseDTO {

    private Long id;
    private Instant moment;
    private String status;
    private Long clientId;
    private Double total;

    private List<OrderItemResponseDTO> items;

    public OrderResponseDTO(Order order){
        this.id         = order.getId();
        this.moment     = order.getMoment();
        this.status     = order.getStatus().name();
        this.clientId   = order.getClient().getId();
        this.total      = order.getTotal();
        this.items      = order.getItems().stream().map(OrderItemResponseDTO::new).toList();
    }

}
