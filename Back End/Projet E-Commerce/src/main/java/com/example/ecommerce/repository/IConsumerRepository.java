package com.example.ecommerce.repository;

import com.example.ecommerce.entity.Consumer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IConsumerRepository extends JpaRepository<Consumer, Integer> {

    Consumer findConsumerByEmailAndPassword(String email, String password);

}
