package com.example.ecommerce.service.impl;

import com.example.ecommerce.dto.OrderDTO;
import com.example.ecommerce.entity.Order;
import com.example.ecommerce.entity.StatusOrder;
import com.example.ecommerce.repository.IConsumerRepository;
import com.example.ecommerce.repository.IOrderRepository;
import com.example.ecommerce.service.IOrderService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class OrderServiceImpl implements IOrderService {

    private final IOrderRepository orderRepository;
    private final IConsumerRepository consumerRepository;

    @Override
    public Order createOrder(OrderDTO orderDTO) {

        Order newOrder = Order.builder()
                .dateOrder(orderDTO.getDateOrder())
                .consumer(consumerRepository.findById(orderDTO.getConsumerId()).get())
                .statusOrder(StatusOrder.PENDING)
                .build();
        return orderRepository.save(newOrder);
    }

    @Override
    public Order updateOrder(Order orderUpdated) {
        return orderRepository.save(orderUpdated);
    }

    @Override
    public void deleteOrder(Long orderId) {
        orderRepository.deleteById(orderId);
    }

    @Override
    public Order getOrderById(Long orderId) {
        return orderRepository.findById(orderId).orElse(null);
    }

    @Override
    public List<Order> getOrderByConsumerId(Long consumerID) {
        return orderRepository.findAllByConsumer_Id(consumerID);
    }
}
