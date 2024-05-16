package com.example.demo.service;

import com.example.demo.model.Cart;
import com.example.demo.model.CartEntry;
import com.example.demo.model.Product;
import com.example.demo.model.ProductVariant;
import com.example.demo.repo.CartEntryRepository;
import com.example.demo.repo.CartRepository;
import com.example.demo.repo.ProductRepository;
import com.example.demo.repo.ProductVariantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CartEntryService {
    private final CartEntryRepository cartEntryRepository;
    private final ProductService productService;
    private final CartRepository cartRepository;
    private final ProductRepository productRepository;
    private final ProductVariantRepository productVariantRepository;

    @Autowired
    public CartEntryService(CartEntryRepository cartEntryRepository, ProductService productService, ProductService productService1, CartRepository cartRepository, ProductRepository productRepository, ProductVariantRepository productVariantRepository) {
        this.cartEntryRepository = cartEntryRepository;
        this.productService = productService1;
        this.cartRepository = cartRepository;
        this.productRepository = productRepository;
        this.productVariantRepository = productVariantRepository;
    }

    public List<CartEntry> listAllCartEntries() {
        return cartEntryRepository.findAll();
    }

    public List<CartEntry> listAllCartEntriesByCartId(Long cartId) {
        return cartEntryRepository.findByCartId(cartId);
    }

    public Optional<CartEntry> findCartEntryById(Long id) {
        return cartEntryRepository.findById(id);
    }

    public CartEntry addCartEntry(Long cartId, Long productId) {
        // Verifică existența coșului în baza de date
        Cart cart = cartRepository.findById(cartId).get();

        // Verifică existența produsului în baza de date
        Product product = productRepository.findById(productId).get();

        Optional<CartEntry> existingCartEntry = cart.getCartEntries().stream()
                .filter(entry -> entry.getProducts().contains(product))
                .findFirst();

        // Crează o nouă înregistrare CartEntry și setează valorile corespunzătoare
        if(existingCartEntry.isPresent()) {
            CartEntry cartEntry = existingCartEntry.get();
            cartEntry.setQuantity((cartEntry.getQuantity() + 1));
            cartEntryRepository.save(cartEntry);
            return cartEntry;
        } else {
            CartEntry cartEntry = new CartEntry();
            cartEntry.setCart(cart);
//            cartEntry.getProducts().add(product);
        cartEntry.setProducts(List.of(product));
            cartEntry.setQuantity(1L);

            // Salvează înregistrarea în baza de date
            cartEntryRepository.save(cartEntry);
            return cartEntry;
        }
    }

    public CartEntry addCartEntryVariant(Long cartId, Long productVariantId) {
        // Verifică existența coșului în baza de date
        Cart cart = cartRepository.findById(cartId).get();

        // Verifică existența produsului în baza de date
        ProductVariant productVariant = productVariantRepository.findById(productVariantId).get();

        Optional<CartEntry> existingCartEntry = cart.getCartEntries().stream()
                .filter(entry -> entry.getProductVariants().contains(productVariant))
                .findFirst();

        // Crează o nouă înregistrare CartEntry și setează valorile corespunzătoare
        if(existingCartEntry.isPresent()) {
            CartEntry cartEntry = existingCartEntry.get();
            cartEntry.setQuantity((cartEntry.getQuantity() + 1));
            cartEntryRepository.save(cartEntry);
            return cartEntry;
        } else {
            CartEntry cartEntry = new CartEntry();
            cartEntry.setCart(cart);
//            cartEntry.getProducts().add(product);
//            cartEntry.setProducts(List.of(productVariant));
            cartEntry.setProductVariants(List.of(productVariant));
            cartEntry.setQuantity(1L);

            // Salvează înregistrarea în baza de date
            cartEntryRepository.save(cartEntry);
            return cartEntry;
        }
    }

    public CartEntry updateQuantity(Long cartEntryId, Long newQuantity) {
        CartEntry cartEntry = cartEntryRepository.findById(cartEntryId).get();
        cartEntry.setQuantity(newQuantity);

        return cartEntryRepository.save(cartEntry);
    }

    public void updateCartEntry(CartEntry cartEntry) {
        cartEntryRepository.save(cartEntry);
    }

    public void deleteCartEntry(Long productId) {
        cartEntryRepository.deleteById(productId);
    }

    public void deleteAllCartEntries(Long cartId) {
        Cart cart = cartRepository.findById(cartId).get();
        cartEntryRepository.deleteAll();
    }
}
