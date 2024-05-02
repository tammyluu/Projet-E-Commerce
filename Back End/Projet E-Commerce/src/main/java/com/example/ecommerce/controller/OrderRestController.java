package com.example.ecommerce.controller;

import com.example.ecommerce.dto.OrderDTO;
import com.example.ecommerce.entity.Order;
import com.example.ecommerce.service.IOrderService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
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
        Order order = orderService.createOrder(orderDTO);
        if (order != null) {
            return ResponseEntity.status(HttpStatus.CREATED).body(order);
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PutMapping("/{orderId}")// http://localhost:8090/api/orders/*
    public ResponseEntity<Order> updateOrder(@PathVariable Long orderId, @RequestBody Order order) {
        Order existingOrder = orderService.getOrderById(orderId);
        if (existingOrder != null) {
            order.setId(orderId);
            Order updatedOrder = orderService.updateOrder(order);
            return ResponseEntity.status(HttpStatus.OK).body(updatedOrder);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @DeleteMapping("/{orderId}")// http://localhost:8090/api/orders/$
    public ResponseEntity<?> deleteOrder(@PathVariable Long orderId) {
        Order existingOrder = orderService.getOrderById(orderId);
        if (existingOrder != null) {
            orderService.deleteOrder(orderId);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @GetMapping("/{orderId}")// http://localhost:8090/api/orders/$
    public ResponseEntity<Order> getOrderById(@PathVariable Long orderId) {
        Order order = orderService.getOrderById(orderId);
        if (order != null) {
            return ResponseEntity.status(HttpStatus.OK).body(order);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @GetMapping("/consumer/{consumerId}")// http://localhost:8090/api/orders/consumer/$
    public ResponseEntity<List<Order>> getOrderByConsumerId(@PathVariable Long consumerId) {
        List<Order> orders = orderService.getOrderByConsumerId(consumerId);
        if (!orders.isEmpty()) {
            return ResponseEntity.status(HttpStatus.OK).body(orders);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
