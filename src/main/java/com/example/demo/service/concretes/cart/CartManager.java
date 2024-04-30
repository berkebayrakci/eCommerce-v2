package com.example.demo.service.concretes.cart;

import com.example.demo.entity.concretes.Cart;
import com.example.demo.repository.CartRepository;
import com.example.demo.service.abstracts.cart.CartService;
import com.example.demo.service.dtos.CartDTO;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
public class CartManager implements CartService {
    private final CartRepository cartRepository;
    private final ModelMapper modelMapper;

    public CartManager(CartRepository cartRepository, ModelMapper modelMapper) {
        this.cartRepository = cartRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public CartDTO getCartById(Long id) {
        Optional<Cart> cartOptional = cartRepository.findById(id);
        if (cartOptional.isPresent()) {
            return modelMapper.map(cartOptional.get(), CartDTO.class);
        } else {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Cart not found with " + id + " id"
            );
        }
    }

    @Override
    public CartDTO createCart(CartDTO cartDTO) {
        Cart cart = modelMapper.map(cartDTO, Cart.class);
        Cart savedCart = cartRepository.save(cart);
        return modelMapper.map(savedCart, CartDTO.class);
    }

    @Override
    public void updateCart(Long id, CartDTO cartDTO) {
        Optional<Cart> cartOptional = cartRepository.findById(id);
        if (cartOptional.isPresent()) {
            Cart cart = cartOptional.get();
            // Update cart properties here if needed
            cartRepository.save(cart);
        } else {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Cart not found with " + id + " id"
            );
        }
    }

    @Override
    public void deleteCart(Long id) {
        if (cartRepository.existsById(id)) {
            cartRepository.deleteById(id);
        } else {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Cart not found with " + id + " id"
            );
        }
    }

}
