package com.example.ecommerce.service;

import com.example.ecommerce.entity.Consumer;
import org.springframework.http.ResponseEntity;

public interface IConsumerService {

    Consumer createConsumer(Consumer consumer);
    Consumer logInConsumer(String email, String password);
    Consumer updateConsumer(Consumer consumerUpdated);

}
