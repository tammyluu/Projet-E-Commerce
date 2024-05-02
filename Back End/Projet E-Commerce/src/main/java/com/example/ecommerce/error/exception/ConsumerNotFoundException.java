package com.example.ecommerce.error.exception;

public class ConsumerNotFoundException extends RuntimeException {

    public ConsumerNotFoundException() {
        super("incorrect identifiers");
    }

}
