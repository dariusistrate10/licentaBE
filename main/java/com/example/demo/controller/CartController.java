package com.example.demo.controller;

import com.example.demo.model.Cart;
import com.example.demo.model.Orders;
import com.example.demo.service.CartService;
import com.example.demo.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:4200/")
@RequestMapping("/cart")
public class CartController {
    private final CartService cartService;
    private final OrdersService ordersService;

    @Autowired
    public CartController(CartService cartService, OrdersService ordersService) {
        this.cartService = cartService;
        this.ordersService = ordersService;
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

    @GetMapping("/{cartId}/orders")
    public ResponseEntity<List<Orders>> getCartOrders(@PathVariable Long cartId) {
        List<Orders> orders = ordersService.getOrdersByCartId(cartId);
        return ResponseEntity.ok(orders);
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
