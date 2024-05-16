package com.example.demo.controller;

import com.example.demo.model.Cart;
import com.example.demo.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:4200/")
@RequestMapping("/cart")
public class CartController {
    private final CartService cartService;

    @Autowired
    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @GetMapping
    public List<Cart> listAllCarts() {
        return cartService.listAllCarts();
    }

    @GetMapping("/{id}")
    public Optional<Cart> findCartById(@PathVariable("id") Long id) {
        return cartService.findCartById(id);
    }

    @GetMapping("/find/{userId}")
    public Cart findCartByUserId(@PathVariable("userId") Long userId) {
        return cartService.findCartByUserId(userId).get();
    }

    @PostMapping("/add/{userId}")
    public void addCart(@PathVariable("userId") Long userId) {
        cartService.addCart(userId);
    }

    @PutMapping("/update")
    public void updateCart(@RequestBody Cart cart) {
        cartService.updateCart(cart);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteCart(@PathVariable("id") Long id) {
        cartService.deleteCart(id);
    }
}
