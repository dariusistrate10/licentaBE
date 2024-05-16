package com.example.demo.service;

import com.example.demo.model.Payment;
import com.example.demo.model.User;
import com.example.demo.repo.PaymentRepository;
import com.example.demo.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PaymentService {
    private final PaymentRepository paymentRepository;
    private final UserRepository userRepository;

    @Autowired
    public PaymentService(PaymentRepository paymentRepository, UserRepository userRepository) {
        this.paymentRepository = paymentRepository;
        this.userRepository = userRepository;
    }

    public List<Payment> listAllPayments() {
        return paymentRepository.findAll();
    }

    public Optional<Payment> findPaymentById(Long id) {
        return paymentRepository.findById(id);
    }

    public void addPayment(Payment payment) {
        paymentRepository.save(payment);
//        if(payment.getCardNumber().length() == 16 && payment.getCardNumber().matches("[0-9]+") && payment.getCardHolderName().matches("[a-z A-Z]+") && payment.getExpiryMonth().length() == 2 && payment.getExpiryMonth().matches("[0-9]+") && payment.getExpiryYear().length() == 2 && payment.getExpiryYear().matches("[0-9]+") && payment.getCvv().matches("[0-9]+") && payment.getCvv().length() == 3) {
//            paymentRepository.save(payment);
//        } else
//            System.out.println("Payment inputs do not match the rules.");
//        paymentRepository.save(payment);
//        if(payment.getCardNumber() == null || payment.getCardHolderName() == null || payment.getCvv() == null || payment.getExpiryYear() == null || payment.getExpiryMonth() == null) {
//            System.out.println("Payment inputs might be null");
//        } else if((payment.getCardNumber().length() == 16 && payment.getCardNumber().matches("[0-9]+")) && (payment.getCardHolderName().matches("[a-z A-Z]+") && (payment.getExpiryMonth().length() == 2 && payment.getExpiryMonth().matches("[0-9]+") && (payment.getExpiryYear().length() == 2 && payment.getExpiryYear().matches("[0-9]+") && (payment.getCvv().matches("[0-9]+") && payment.getCvv().length() == 3))))) {
//            paymentRepository.save(payment);
//        } else
//            System.out.println("Payment info does not match the standard input.");
    }

    public void updatePayment(Payment payment) {
        paymentRepository.save(payment);
    }

    public void deletePayment(Long id) {
        paymentRepository.deleteById(id);
    }
}
