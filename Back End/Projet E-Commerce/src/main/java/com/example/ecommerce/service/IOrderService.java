package com.example.ecommerce.service;

import com.example.ecommerce.dto.OrderDTO;
import com.example.ecommerce.entity.Order;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IOrderService {

    ResponseEntity<Order> createOrder(OrderDTO orderDTO);
    ResponseEntity<Order> updateOrder(Order order);
    ResponseEntity deleteOrder(Long orderId);
    ResponseEntity<Order> getOrderById(Long orderId);
    ResponseEntity<List<Order>> getOrderByConsumerId(Long consumerID);
}
