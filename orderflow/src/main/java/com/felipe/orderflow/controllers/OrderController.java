package com.felipe.orderflow.controllers;

import com.felipe.orderflow.dto.OrderDTO;
import com.felipe.orderflow.dto.OrderResponseDTO;
import com.felipe.orderflow.dto.OrderStatusDTO;
import com.felipe.orderflow.entities.Order;
import com.felipe.orderflow.enums.OrderStatus;
import com.felipe.orderflow.repositories.OrderRepository;
import com.felipe.orderflow.services.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;

import java.util.List;

@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService service;
    private final OrderRepository orderRepository;

    @PostMapping
    public ResponseEntity<Order> create(@RequestBody OrderDTO dto){
        Order order = service.createOrder(dto);
        return ResponseEntity.ok(order);
    }

    @GetMapping
    public ResponseEntity<List<OrderResponseDTO>> findAll(){
        List<Order> orders = service.findAll();
        List<OrderResponseDTO> dto = orders.stream()
                .map(OrderResponseDTO::new).toList();

        return ResponseEntity.ok(dto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderResponseDTO> findById(@PathVariable Long id){
        Order order = service.findById(id);
        return ResponseEntity.ok(new OrderResponseDTO(order));
    }

    @PatchMapping("/{id}/status")
    public ResponseEntity<OrderResponseDTO> updateStatus(@PathVariable Long id,@RequestBody OrderStatusDTO dto) {
        Order order = service.updateStatus(id, dto.getStatus());
        return ResponseEntity.ok(new OrderResponseDTO(order));
    }

    @GetMapping("/paged")
    public ResponseEntity<Page<OrderResponseDTO>> findAllPaged(Pageable pageable) {

        Page<Order> orders = service.findAllPaged(pageable);

        Page<OrderResponseDTO> dto = orders.map(OrderResponseDTO::new);

        return ResponseEntity.ok(dto);
    }

    @GetMapping("/status")
    public ResponseEntity<Page<OrderResponseDTO>> findByStatus(@RequestParam String status, Pageable pageable) {

        OrderStatus st = OrderStatus.valueOf(status.toUpperCase());

        Page<Order> result = orderRepository.findByStatus(st, pageable);

        return ResponseEntity.ok(result.map(OrderResponseDTO::new));
    }

    @GetMapping("/client")
    public ResponseEntity<Page<OrderResponseDTO>> findByClient(@RequestParam Long clientId, Pageable pageable){

        Page<Order> result = orderRepository.findByClientId(clientId, pageable);

        return ResponseEntity.ok(result.map(OrderResponseDTO::new));
    }

}
