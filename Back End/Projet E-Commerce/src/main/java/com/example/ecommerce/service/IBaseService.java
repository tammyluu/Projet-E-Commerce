package com.example.ecommerce.service;

import java.util.List;

public interface IBaseService <T>{
    public  T create(T e);
    public List<T> getAll();
    public T getById(Long id);
    public T update(T e);
    public void deleteById(Long id);

}
