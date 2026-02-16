package com.felipe.orderflow.repositories;

import com.felipe.orderflow.entities.Order;
import com.felipe.orderflow.enums.OrderStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;



public interface OrderRepository extends JpaRepository<Order, Long>  {


    Page<Order> findByStatus(OrderStatus status, Pageable pageable);

    Page<Order> findByClientId(Long clientId, Pageable pageable);

}
