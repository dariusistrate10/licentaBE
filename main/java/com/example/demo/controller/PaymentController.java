package com.example.demo.controller;

import com.example.demo.model.Payment;
import com.example.demo.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:4200/")
@RequestMapping("/payment")
public class PaymentController {
    private final PaymentService paymentService;

    @Autowired
    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @GetMapping
    public List<Payment> listAllPayments() {
        return paymentService.listAllPayments();
    }

    @GetMapping("/find/{id}")
    public Optional<Payment> findPaymentById(@PathVariable("id") Long id) {
        return paymentService.findPaymentById(id);
    }

    @PostMapping("/add")
    public void addPayment(@RequestBody Payment payment) {
        paymentService.addPayment(payment);
    }

    @PutMapping("/update")
    public void updatePayment(@RequestBody Payment payment) {
        paymentService.updatePayment(payment);
    }

    @DeleteMapping("/delete/{id}")
    public void deletePayment(@PathVariable("id") Long id) {
        paymentService.deletePayment(id);
    }
}
