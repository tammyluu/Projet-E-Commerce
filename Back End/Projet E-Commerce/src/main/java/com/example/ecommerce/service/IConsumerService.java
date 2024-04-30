package com.example.ecommerce.service;

import com.example.ecommerce.entity.Consumer;
import org.springframework.http.ResponseEntity;

public interface IConsumerService {

    ResponseEntity<Consumer> createConsumer(Consumer consumer);
    ResponseEntity<Consumer> logInConsumer(String email, String password);
    ResponseEntity<Consumer> updateConsumer(Consumer consumerUpdated);

}
