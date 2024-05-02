package com.example.ecommerce.controller;

import com.example.ecommerce.dto.ConsumerDTO;
import com.example.ecommerce.entity.Consumer;
import com.example.ecommerce.error.exception.ConsumerNotFoundException;
import com.example.ecommerce.service.IConsumerService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/api")
public class ConsumerRestController {

    private final IConsumerService consumerService;

    @PostMapping("/consumer")// http://localhost:8090/api/consumer
    public ResponseEntity<Consumer> addConsumer(@RequestBody Consumer consumer) {
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(
                    consumerService.createConsumer(consumer)
            );
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/login")// http://localhost:8090/api/login
    public ResponseEntity<Consumer> login(@RequestBody ConsumerDTO consumerDTO) {
        try {
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(
                    consumerService.logInConsumer(consumerDTO.getEmail(), consumerDTO.getPassword())
            );
        } catch (ConsumerNotFoundException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }

    @PutMapping("/consumer")// http://localhost:8090/api/consumer
    public ResponseEntity<Consumer> updateConsumer(@RequestBody Consumer consumer) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(
                consumerService.updateConsumer(consumer)
            );
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
