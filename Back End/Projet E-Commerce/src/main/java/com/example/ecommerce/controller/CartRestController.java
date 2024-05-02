package com.example.ecommerce.controller;

import com.example.ecommerce.dto.CartDTO;
import com.example.ecommerce.entity.Cart;
import com.example.ecommerce.service.ICartService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/carts")
@AllArgsConstructor
public class CartRestController {

    private final ICartService cartService;

    @PostMapping()// http://localhost:8090/api/carts
    public ResponseEntity<Cart> addCart(@RequestBody CartDTO cartDTO) {
        Cart newCart = cartService.createCart(cartDTO);
        return ResponseEntity.ok(newCart);
    }

    @GetMapping(("/order/{orderId}"))// http://localhost:8090/api/carts/order/$
    public ResponseEntity<List<Cart>> getAllCartsByOrderId(@PathVariable Long orderId) {
        List<Cart> carts = cartService.getAllCartsByOrderId(orderId);
        return ResponseEntity.ok(carts);
    }

    @PutMapping("/{cartId}")// http://localhost:8090/api/carts/$
    public ResponseEntity<Cart> updateCart(@PathVariable Long cartId, @RequestBody Cart cart) {
        cart.setId(cartId);
        Cart cartUpdated = cartService.updateCart(cart);
        if (cartUpdated != null) {
            return ResponseEntity.ok(cartUpdated);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("{cartId}")// http://localhost:8090/api/carts/$
    public ResponseEntity<Cart> deleteCart(@PathVariable Long cartId) {
        cartService.deleteCart(cartId);
        return ResponseEntity.noContent().build();
    }

}
