package com.example.demo.controller;

import com.example.demo.model.CartEntry;
import com.example.demo.model.Product;
import com.example.demo.service.CartEntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@CrossOrigin(origins = "http://localhost:4200/", maxAge = 3600)
@RequestMapping("/cartentry")
public class CartEntryController {
    private final CartEntryService cartEntryService;

    @Autowired
    public CartEntryController(CartEntryService cartEntryService) {
        this.cartEntryService = cartEntryService;
    }

    @GetMapping
    public List<CartEntry> listAllCartEntries() {
        return cartEntryService.listAllCartEntries();
    }

    @GetMapping("/find/{id}")
    public Optional<CartEntry> findCartEntryById(@PathVariable("id") Long id) {
        return cartEntryService.findCartEntryById(id);
    }

    @GetMapping("/{cartId}")
    public List<CartEntry> findCartEntriesByCartId(@PathVariable("cartId") Long cartId) {
        List<CartEntry> cartEntries = cartEntryService.listAllCartEntriesByCartId(cartId);
        return cartEntries;
    }

    @PostMapping("/add/{productId}/{cartId}")
    public void addCartEntry(@PathVariable("productId") Long productId, @PathVariable("cartId") Long cartId) {
        // Obțineți id-ul coșului de cumpărături din sesiune sau din alte date relevante
//        Long cartId = 1L; // Obțineți id-ul coșului în funcție de necesități

        CartEntry addedEntry = cartEntryService.addCartEntry(cartId, productId);
    }

    @PostMapping("/add/variant/{productId}/{cartId}")
    public void addCartEntryVariant(@PathVariable("productId") Long productVariantId, @PathVariable("cartId") Long cartId) {
        // Obțineți id-ul coșului de cumpărături din sesiune sau din alte date relevante
//        Long cartId = 1L; // Obțineți id-ul coșului în funcție de necesități

        CartEntry addedEntry = cartEntryService.addCartEntryVariant(cartId, productVariantId);
    }

    @PutMapping("/update/{cartEntryId}/{newQuantity}")
    public void updateCartEntry(@PathVariable("cartEntryId") Long cartEntryId, @PathVariable("newQuantity") Long newQuantity) {
        cartEntryService.updateQuantity(cartEntryId, newQuantity);
    }

    @DeleteMapping("/delete/{productId}")
    public void deleteCartEntry(@PathVariable("productId") Long productId) {
        cartEntryService.deleteCartEntry(productId);
    }

    @DeleteMapping("/delete/all/{cartId}")
    public void deleteAllCartEntries(@PathVariable("cartId") Long cartId) {
        cartEntryService.deleteAllCartEntries(cartId);
    }
}
