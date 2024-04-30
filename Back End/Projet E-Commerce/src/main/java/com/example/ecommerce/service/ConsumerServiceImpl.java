package com.example.ecommerce.service;

import com.example.ecommerce.entity.Consumer;
import com.example.ecommerce.repository.IConsumerRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ConsumerServiceImpl implements IConsumerService{

    private final IConsumerRepository consumerRepository;

    @Override
    public ResponseEntity<Consumer> createConsumer(Consumer consumer) {
        try {
            Consumer newConsumer = consumerRepository.save(consumer);
            return ResponseEntity.status(HttpStatus.CREATED).body(newConsumer);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @Override
    public ResponseEntity<Consumer> logInConsumer(String email, String password) {
        try {
            Consumer consumerConnected = consumerRepository.findConsumerByEmailAndPassword(email, password);
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(consumerConnected);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @Override
    public ResponseEntity<Consumer> updateConsumer(Consumer consumerUpdated) {
        try {
            Consumer consumer = consumerRepository.save(consumerUpdated);
            return ResponseEntity.status(HttpStatus.CREATED).body(consumer);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
