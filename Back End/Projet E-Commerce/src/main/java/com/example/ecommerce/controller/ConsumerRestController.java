package com.example.ecommerce.controller;

import com.example.ecommerce.dto.ConsumerDTO;
import com.example.ecommerce.entity.Consumer;
import com.example.ecommerce.service.IConsumerService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class ConsumerRestController {

    private final IConsumerService consumerService;

    @PostMapping("/consumer")// http://localhost:8090/api/consumer
    public ResponseEntity<Consumer> addConsumer(@RequestBody Consumer consumer) {
        return consumerService.createConsumer(consumer);
    }

    @GetMapping("/login")// http://localhost:8090/api/login
    public ResponseEntity<Consumer> login(@RequestBody ConsumerDTO consumerDTO) {
        return consumerService.logInConsumer(consumerDTO.getEmail(), consumerDTO.getPassword());
    }

    @PutMapping("/consumer")// http://localhost:8090/api/consumer
    public ResponseEntity<Consumer> updateConsumer(@RequestBody Consumer consumer) {
        return consumerService.updateConsumer(consumer);
    }
}
