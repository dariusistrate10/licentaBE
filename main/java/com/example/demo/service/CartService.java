package com.example.demo.service;

import com.example.demo.model.Cart;
import com.example.demo.model.User;
import com.example.demo.repo.CartRepository;
import com.example.demo.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CartService {
    private final CartRepository cartRepository;
    private final UserRepository userRepository;

    @Autowired
    public CartService(CartRepository cartRepository, UserRepository userRepository) {
        this.cartRepository = cartRepository;
        this.userRepository = userRepository;
    }

    public List<Cart> listAllCarts() {
        return cartRepository.findAll();
    }

    public Optional<Cart> findCartById(Long id) {
        return cartRepository.findById(id);
    }

    public Optional<Cart> findCartByUserId(Long userId) {
        return Optional.ofNullable(cartRepository.findByUserId(userId));
    }

    public void addCart(Long userId) {
        User user = userRepository.findById(userId).get();

        if(user != null){
            Cart cart = new Cart();
            cart.setUser(user);
            cartRepository.save(cart);
        } else
            System.out.println("User might be null.");


//        cart.setUser(user);
//        cartRepository.save(cart);
    }

    public void updateCart(Cart cart) {
        cartRepository.save(cart);
    }

    public void deleteCart(Long id) {
        cartRepository.deleteById(id);
    }
}
