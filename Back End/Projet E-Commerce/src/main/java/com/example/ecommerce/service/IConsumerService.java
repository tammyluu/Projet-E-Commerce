package com.example.ecommerce.service;

import com.example.ecommerce.entity.Consumer;

public interface IConsumerService {

    Consumer createConsumer(Consumer consumer);
    Consumer logInConsumer(String email, String password);
    Consumer updateConsumer(Consumer consumerUpdated);

}
