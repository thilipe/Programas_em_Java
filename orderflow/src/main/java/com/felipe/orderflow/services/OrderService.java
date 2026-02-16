package com.felipe.orderflow.services;

import com.felipe.orderflow.dto.OrderDTO;
import com.felipe.orderflow.dto.OrderItemDTO;
import com.felipe.orderflow.entities.Client;
import com.felipe.orderflow.entities.Order;
import com.felipe.orderflow.entities.OrderItem;
import com.felipe.orderflow.entities.Product;
import com.felipe.orderflow.enums.OrderStatus;
import com.felipe.orderflow.repositories.ClientRepository;
import com.felipe.orderflow.repositories.OrderRepository;
import com.felipe.orderflow.repositories.ProductRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;

import java.time.Instant;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final ClientRepository clientRepository;
    private final ProductRepository productRepository;
    private List<OrderItemDTO> items;

    @Transactional
    public Order createOrder(OrderDTO dto) {

        /* 1 - BUSCAR O CLIENTE*/
        Client client = clientRepository.findById(dto.getClientId())
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));

        /* 2 - CRIAR O PEDIDO */
        Order order = Order.builder().moment(Instant.now()).status(OrderStatus.CREATED).client(client).build();

        /* 3 - SALVAR PEDIDO (gera o id)*/
        order = orderRepository.save(order);

        /* 4 - CRIAR ITENS DO PEDIDO */
        for (OrderItemDTO itemDTO : items) {

            Product product = productRepository.findById(itemDTO.getProductId())
                    .orElseThrow(() -> new RuntimeException("Produto não encontrado"));

            OrderItem item = new OrderItem();
            item.setOrder(order);       //FAZ PARTE DA PK
            item.setProduct(product);   //TAMBÉM PARTE DA PK

            item.setQuantity(itemDTO.getQuantity());
            item.setPrice(product.getPrice());

            /* ADICIONA A COLEÇÃO DO PEDIDO */
            order.getItems().add(item);
        }

        /* 5 - SALVAR ITENS (gora que order_id existe) */
        order = orderRepository.save(order);

        return order;

    }

    @Transactional
    public List<Order> findAll(){
        return orderRepository.findAll();
    }

    @Transactional
    public Order findById(Long id){
        return orderRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Pedido não encontrado"));
    }

    @Transactional
    public Order updateStatus(Long id, String statusStr){
        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pedido não encontrado"));

        OrderStatus status = OrderStatus.valueOf(statusStr.toUpperCase());

        /* REGRA DE NEGÓCIO OPCIONAIS: */
        /* EXEMPLO: IMPEDIR CANCELAR APÓS ENVIADO */
        if (order.getStatus() == OrderStatus.SHIPPED && status == OrderStatus.CANCELED){
            throw new RuntimeException("Não é possível cancelar um pedido já enviado.");
        }

        order.setStatus(status);

        return orderRepository.save(order);
    }

    @Transactional
    public Page<Order> findAllPaged(Pageable pageable) {
        return orderRepository.findAll(pageable);
    }

}
