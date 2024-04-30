package com.example.demo.service.abstracts.cart;

import com.example.demo.service.dtos.CartDTO;

public interface CartService {
    CartDTO getCartById(Long id);
    CartDTO createCart(CartDTO cartDTO);
    void updateCart(Long id, CartDTO cartDTO);
    void deleteCart(Long id);
}
