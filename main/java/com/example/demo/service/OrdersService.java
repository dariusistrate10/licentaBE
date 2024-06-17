package com.example.demo.service;

import com.example.demo.model.*;
import com.example.demo.repo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class OrdersService {
    private final OrdersRepository ordersRepository;
    private final UserRepository userRepository;
    private final PaymentRepository paymentRepository;
    private final CartRepository cartRepository;
    private final CartEntryRepository cartEntryRepository;
    private final CartEntryService cartEntryService;

    @Autowired
    public OrdersService(OrdersRepository ordersRepository, UserRepository userRepository, PaymentRepository paymentRepository, CartRepository cartRepository, CartEntryRepository cartEntryRepository, CartEntryService cartEntryService) {
        this.ordersRepository = ordersRepository;
        this.userRepository = userRepository;
        this.paymentRepository = paymentRepository;
        this.cartRepository = cartRepository;
        this.cartEntryRepository = cartEntryRepository;
        this.cartEntryService = cartEntryService;
    }

    public List<Orders> listAllOrders() {
        return ordersRepository.findAll();
    }

    public Optional<Orders> findOrdersById(Long id) {
        return ordersRepository.findById(id);
    }

    public List<Orders> getOrdersByCartId(Long cartId) {
        return ordersRepository.findByCartId(cartId);
    }

    public List<Orders> getOrdersByUserId(Long userId) {
        return ordersRepository.findByUserId(userId);
    }

    public void addOrders(Long userId, Long cartId, Long paymentId) {
        User user = userRepository.findById(userId).get();
        Payment payment = paymentRepository.findById(paymentId).get();
        Cart cart = cartRepository.findById(cartId).get();
        List<CartEntry> cartEntries = cartEntryRepository.findByCartId(cartId);
        System.out.println(cartId);
        LocalDate date;
        String deliveryAddress = user.getDefaultDeliveryAddress();
        String invoiceAddress = user.getDefaultBillingAddress();

        if(user != null && payment != null && cart != null){
            Orders orders = new Orders();
            orders.setCart(cart);
            orders.setUser(user);
            orders.setPayment(payment);
            orders.setDeliveryAddress(deliveryAddress);
            orders.setInvoiceAddress(invoiceAddress);
            orders.setOrderDate(date = LocalDate.now());
            orders.setPaymentType("Credit Card");
            System.out.println(cartEntries.size());
            cartEntries.forEach(cartEntry -> {
                cartEntry.getProductVariants().forEach(productVariant -> {
                    productVariant.setQuantity(productVariant.getQuantity() - cartEntry.getQuantity());
                    System.out.println(productVariant.getQuantity());
                });
            });

            ordersRepository.save(orders);
//            cartEntryService.deleteAllCartEntries(cartId);
        } else
            System.out.println("User, payment or cart might be null.");
    }

    public void updateOrders(Orders orders) {
        ordersRepository.save(orders);
    }

    public void deleteOrders(Long id) {
        ordersRepository.deleteById(id);
    }
}
