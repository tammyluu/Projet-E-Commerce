package com.example.ecommerce.repository;

import com.example.ecommerce.entity.Order;
import com.example.ecommerce.entity.StatusOrder;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IOrderRepository extends JpaRepository<Order, Long> {

    List<Order> findAllByConsumer_Id(Long consumer_id);
    Order findOrderByConsumer_IdAndStatusOrder(Long consumer_id, StatusOrder statusOrder);
}
