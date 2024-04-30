package com.example.ecommerce.controller;

import com.example.ecommerce.dto.ConsumerDTO;
import com.example.ecommerce.entity.Consumer;
import com.example.ecommerce.service.IConsumerService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("api/ecommerce")
public class ConsumerRestController {


    private final IConsumerService consumerService;

    @PostMapping("/consumer")
    public Consumer addConsumer(@RequestBody Consumer consumer) {
        return consumerService.createConsumer(consumer);
    }

    @GetMapping("/login")
    public Consumer login(@RequestBody ConsumerDTO consumerDTO) {
        return consumerService.logInConsumer(consumerDTO.getEmail(), consumerDTO.getPassword());
    }

    @PutMapping("/consumer")
    public Consumer updateConsumer(@RequestBody Consumer consumer) {
        return consumerService.updateConsumer(consumer);
    }
}
