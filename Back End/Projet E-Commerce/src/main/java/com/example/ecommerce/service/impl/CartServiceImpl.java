package com.example.ecommerce.service.impl;

import com.example.ecommerce.dto.CartDTO;
import com.example.ecommerce.entity.Cart;
import com.example.ecommerce.entity.Product;
import com.example.ecommerce.repository.ICartRepository;
import com.example.ecommerce.repository.IProductRepository;
import com.example.ecommerce.service.ICartService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CartServiceImpl implements ICartService {

    private IProductRepository productRepository;
    private ICartRepository cartRepository;


    @Override
    public Cart createCart(CartDTO cartDTO) {
        Product product = productRepository.findProductById(cartDTO.getProductId());
        Cart cart = Cart.builder()
                .product(product)
                .quantity(cartDTO.getQuantity())
                .currentPrice(product.getPrice())
                .build();
        return cartRepository.save(cart);
    }

    @Override
    public Cart updateCart(Cart cartUpdated) {
        Cart cartExist = cartRepository.findById(cartUpdated.getId()).orElse(null);
        if (cartExist != null) {
            cartExist.setQuantity(cartUpdated.getQuantity());
            return cartRepository.save(cartExist);
        }
        return null;
    }

    @Override
    public void deleteCart(Long cartId) {
        Cart cart = cartRepository.findById(cartId).orElse(null);
        if (cart != null) {
            cartRepository.deleteById(cart.getId());
        }
    }

    @Override
    public List<Cart> getAllCartsByOrderId(Long orderId) {
        return cartRepository.findAllByOrder_Id(orderId);
    }

}
