package com.example.ecommerce.service.impl;

import com.example.ecommerce.dto.CartDTO;
import com.example.ecommerce.dto.OrderDTO;
import com.example.ecommerce.entity.Cart;
import com.example.ecommerce.entity.Order;
import com.example.ecommerce.entity.Product;
import com.example.ecommerce.repository.ICartRepository;
import com.example.ecommerce.repository.IConsumerRepository;
import com.example.ecommerce.repository.IProductRepository;
import com.example.ecommerce.service.ICartService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@AllArgsConstructor
public class CartServiceImpl implements ICartService {

    private IProductRepository productRepository;
    private ICartRepository cartRepository;
    private OrderServiceImpl orderService;


    @Override
    public Cart createCart(CartDTO cartDTO) {

        Order order = orderService.getOrderByConsumerIdAndStatusOrderPending(cartDTO.getConsumerId());
        Cart cart = new Cart();

        if (order == null) {
            OrderDTO newOrder = OrderDTO.builder()
                    .consumerId(cartDTO.getConsumerId())
                    .dateOrder(LocalDateTime.now())
                    .build();

            order = orderService.createOrder(newOrder);

            Product product = productRepository.findProductById(cartDTO.getProductId());
            cart = Cart.builder()
                    .id(order.getId())
                    .product(product)
                    .quantity(cartDTO.getQuantity())
                    .currentPrice(product.getPrice())
                    .build();

        } else {

            Product product = productRepository.findProductById(cartDTO.getProductId());
            cart = Cart.builder()
                    .id(order.getId())
                    .product(product)
                    .quantity(cartDTO.getQuantity())
                    .currentPrice(product.getPrice())
                    .build();

        }
        order.getCart().add(cart);
        orderService.updateOrder(order);
        cartRepository.save(cart);
        return cart;
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
