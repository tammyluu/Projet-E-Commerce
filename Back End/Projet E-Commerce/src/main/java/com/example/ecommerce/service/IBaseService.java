package com.example.ecommerce.service;

import java.util.List;

public interface IBaseService <T>{
     T create(T e);
     List<T> getAll();
     T getById(Long id);
     T update(T e);
     void deleteById(Long id);

}
