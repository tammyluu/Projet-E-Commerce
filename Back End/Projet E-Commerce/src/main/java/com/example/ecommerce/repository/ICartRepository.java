package com.example.ecommerce.repository;

import com.example.ecommerce.entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ICartRepository extends JpaRepository<Cart, Long> {

    List<Cart> findAllByOrder_Id(Long id);

}
