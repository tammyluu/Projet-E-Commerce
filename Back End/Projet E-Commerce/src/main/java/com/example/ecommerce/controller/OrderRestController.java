package com.example.ecommerce.controller;

import com.example.ecommerce.dto.OrderDTO;
import com.example.ecommerce.entity.Order;
import com.example.ecommerce.service.IOrderService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/orders")
public class OrderRestController {

    private final IOrderService orderService;

    @PostMapping()// http://localhost:8090/api/orders
    public ResponseEntity<Order> addOrder(@RequestBody OrderDTO orderDTO) {
        return orderService.createOrder(orderDTO);
    }

    @PutMapping("/{orderId}")// http://localhost:8090/api/orders/*
    public ResponseEntity<Order> updateOrder(@PathVariable Long orderId, @RequestBody Order order) {
        Order orderToUpdate = orderService.getOrderById(orderId).getBody();
        if (orderToUpdate != null) {
            orderToUpdate.setStatusOrder(order.getStatusOrder());
            return orderService.updateOrder(orderToUpdate);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{orderId}")// http://localhost:8090/api/orders/$
    public ResponseEntity<?> deleteOrder(@PathVariable Long orderId) {
        return orderService.deleteOrder(orderId);
    }

    @GetMapping("/{orderId}")// http://localhost:8090/api/orders/$
    public ResponseEntity<Order> getOrderById(@PathVariable Long orderId) {
        return orderService.getOrderById(orderId);
    }

    @GetMapping("/consumer/{consumerId}")// http://localhost:8090/api/orders/consumer/$
    public ResponseEntity<List<Order>> getOrderByConsumerId(@PathVariable Long consumerId) {
        return orderService.getOrderByConsumerId(consumerId);
    }
}
