package com.example.ecommerce.error.exception;

public class StorageFileNotFound extends StorageException{
    private static final long serialVersionUID = 1L;
    public StorageFileNotFound(String message) {
        super(message);
    }
}
