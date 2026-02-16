package com.felipe.orderflow.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class OrderDTO {

    private Long clientId;
    private List<OrderItemDTO> items;
}
