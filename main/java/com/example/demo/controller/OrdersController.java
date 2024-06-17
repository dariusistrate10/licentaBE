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
        paymentService.addPayment(payment);
        Long paymentId = payment.getId();
//            System.out.println(paymentId);
        ordersService.addOrders(userId, cartId, paymentId);

//        paymentService.addPayment(payment);
//        Long paymentId = payment.getId();
//        System.out.println(paymentId);
//        ordersService.addOrders(userId, cartId, paymentId);
    }

    @GetMapping("/user/{userId}")
    public List<Orders> getOrdersByUserId(@PathVariable Long userId) {
        return ordersService.getOrdersByUserId(userId);
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
