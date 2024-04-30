package com.example.ecommerce.service;

import com.example.ecommerce.entity.Consumer;
import com.example.ecommerce.repository.IConsumerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ConsumerServiceImpl implements IConsumerService{

    private final IConsumerRepository consumerRepository;

    @Override
    public Consumer createConsumer(Consumer consumer) {
        return consumerRepository.save(consumer);
    }

    @Override
    public Consumer logInConsumer(String email, String password) {
        return consumerRepository.findConsumerByEmailAndPassword(email, password);
    }

    @Override
    public Consumer updateConsumer(Consumer consumerUpdated) {
        return consumerRepository.save(consumerUpdated);
    }
}
