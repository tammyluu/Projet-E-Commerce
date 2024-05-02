package com.example.ecommerce.service.impl;

import com.example.ecommerce.entity.Consumer;
import com.example.ecommerce.error.exception.ConsumerNotFoundException;
import com.example.ecommerce.repository.IConsumerRepository;
import com.example.ecommerce.service.IConsumerService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ConsumerServiceImpl implements IConsumerService {

    private final IConsumerRepository consumerRepository;

    @Override
    public Consumer createConsumer(Consumer consumer) {
        return consumerRepository.save(consumer);
    }

    @Override
    public Consumer logInConsumer(String email, String password) {
        Consumer consumerConnected = consumerRepository.findConsumerByEmailAndPassword(email,password);
        if (consumerConnected == null) {
            throw new ConsumerNotFoundException();
        } else {
            return consumerConnected;
        }
    }

    @Override
    public Consumer updateConsumer(Consumer consumerUpdated) {
        return consumerRepository.save(consumerUpdated);
    }
}
