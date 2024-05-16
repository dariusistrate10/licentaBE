package com.example.demo.controller;

import com.example.demo.model.Orders;
import com.example.demo.model.Payment;
import com.example.demo.service.OrdersService;
import com.example.demo.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:4200/")
@RequestMapping("/orders")
public class OrdersController {
    private final OrdersService ordersService;
    private final PaymentService paymentService;

    @Autowired
    public OrdersController(OrdersService ordersService, PaymentService paymentService) {
        this.ordersService = ordersService;
        this.paymentService = paymentService;
    }

    @GetMapping
    public List<Orders> listAllOrders() {
        return ordersService.listAllOrders();
    }

    @GetMapping("/find/{id}")
    public Optional<Orders> findOrdersById(@PathVariable("id") Long id) {
        return ordersService.findOrdersById(id);
    }

    @PostMapping("/add/{userId}/{cartId}")
    public void addOrders(@RequestBody Payment payment, @PathVariable("userId") Long userId, @PathVariable("cartId") Long cartId) {
        if(payment.getCardNumber().length() == 16 && payment.getCardNumber().matches("[0-9]+") && payment.getCardHolderName().matches("[a-z A-Z]+") && payment.getExpiryMonth().length() == 2 && payment.getExpiryMonth().matches("[0-9]+") && payment.getExpiryYear().length() == 2 && payment.getExpiryYear().matches("[0-9]+") && payment.getCvv().matches("[0-9]+") && payment.getCvv().length() == 3) {
            paymentService.addPayment(payment);
            Long paymentId = payment.getId();
//            System.out.println(paymentId);
            ordersService.addOrders(userId, cartId, paymentId);
        } else
            System.out.println("Payment inputs do not match the rules.");
//        paymentService.addPayment(payment);
//        Long paymentId = payment.getId();
//        System.out.println(paymentId);
//        ordersService.addOrders(userId, cartId, paymentId);
    }

    @PutMapping("/update")
    public void updateOrders(@RequestBody Orders orders) {
        ordersService.updateOrders(orders);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteOrders(@PathVariable("id") Long id) {
        ordersService.deleteOrders(id);
    }
}
