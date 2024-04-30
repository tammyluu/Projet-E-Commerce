package com.example.ecommerce.service;

import com.example.ecommerce.dto.OrderDTO;
import com.example.ecommerce.entity.Order;
import com.example.ecommerce.entity.StatusOrder;
import com.example.ecommerce.repository.IConsumerRepository;
import com.example.ecommerce.repository.IOrderRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class OrderServiceImpl implements IOrderService {

    private final IOrderRepository orderRepository;
    private final IConsumerRepository consumerRepository;

    @Override
    public ResponseEntity<Order> createOrder(OrderDTO orderDTO) {

        Order newOrder = Order.builder()
                .dateOrder(orderDTO.getDateOrder())
                .consumer(consumerRepository.findById(orderDTO.getConsumerId()).get())
                .statusOrder(StatusOrder.PENDING)
                .build();
        try {
            Order savedOrder = orderRepository.save(newOrder);
            return ResponseEntity.status(HttpStatus.CREATED).body(savedOrder);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @Override
    public ResponseEntity<Order> updateOrder(Order orderUpdated) {
        try {
            Order order = Order.builder()
                    .id(orderUpdated.getId())
                    .dateOrder(orderUpdated.getDateOrder())
                    .consumer(orderUpdated.getConsumer())
                    .statusOrder(orderUpdated.getStatusOrder())
                    .build();

           orderRepository.save(orderUpdated);
            return ResponseEntity.status(HttpStatus.CREATED).body(order);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @Override
    public ResponseEntity deleteOrder(Long orderId) {
        try {
            Optional<Order> order = orderRepository.findById(orderId);
            if (!order.isPresent()) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            }
            orderRepository.deleteById(orderId);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @Override
    public ResponseEntity<Order> getOrderById(Long orderId) {
        try {
            Optional<Order> order = orderRepository.findById(orderId);
            if (!order.isPresent()) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            }
            return ResponseEntity.status(HttpStatus.OK).body(order.get());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @Override
    public ResponseEntity<List<Order>> getOrderByConsumerId(Long consumerID) {
        try {
            List<Order> orders = orderRepository.findAllByConsumer_Id(consumerID);
            if (orders.isEmpty()) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            }
            return ResponseEntity.status(HttpStatus.OK).body(orders);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
