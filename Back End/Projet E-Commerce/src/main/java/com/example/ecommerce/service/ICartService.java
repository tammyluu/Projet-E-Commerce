package com.example.ecommerce.service;

import com.example.ecommerce.dto.CartDTO;
import com.example.ecommerce.entity.Cart;

import java.util.List;

public interface ICartService {

    Cart createCart(CartDTO cartDTO);
    Cart updateCart(Cart cart);
    void deleteCart(Long cartId);
    List<Cart> getAllCartsByOrderId(Long orderId);

}
