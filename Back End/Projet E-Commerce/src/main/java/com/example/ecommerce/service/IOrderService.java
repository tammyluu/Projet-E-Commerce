package com.example.ecommerce.service;

import com.example.ecommerce.dto.OrderDTO;
import com.example.ecommerce.entity.Order;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IOrderService {

    Order createOrder(OrderDTO orderDTO);
    Order updateOrder(Order order);
    void deleteOrder(Long orderId);
    Order getOrderById(Long orderId);
    List<Order> getOrderByConsumerId(Long consumerID);
}
