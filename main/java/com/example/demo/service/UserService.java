package com.example.demo.service;

import com.example.demo.model.Address;
import com.example.demo.repo.AddressRepository;
import com.example.demo.repo.CartRepository;
import com.example.demo.repo.UserRepository;
import com.example.demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final AddressService addressService;
    private final CartRepository cartRepository;

    @Autowired
    public UserService(UserRepository userRepository, AddressRepository addressRepository, AddressService addressService, CartRepository cartRepository) {
        this.userRepository = userRepository;
        this.addressService = addressService;
        this.cartRepository = cartRepository;
    }

    public List<User> listAllUsers() {
        return userRepository.findAll();
    }

    public void addUser(User user) {
        if (user.getFirstName() != null && user.getLastName() != null && user.getEmail() != null && user.getPassword() != null && user.getPhoneNumber() != null && user.getDefaultDeliveryAddress() != null && user.getDefaultBillingAddress() != null) {
            if (user.getEmail().matches("[a-z A-Z 0-9 @.]+") && user.getPhoneNumber().matches("[0-9]+") && user.getPassword().matches("[0-9 a-z A-Z !@#$%^&*]+") && user.getPassword().length() >= 8) {
                List<Address> addresses = user.getAddresses();
                if (addresses != null) {
                    for (Address address : addresses) {
                        addressService.addAddress(address);
                    }
                }
                userRepository.save(user);
            } else System.out.println("User information not matching the rules.");
        } else System.out.println("User inputs might be null.");
//        List<Address> addresses = user.getAddresses();
//        if(addresses != null) {
//            for(Address address : addresses) {
//                addressService.addAddress(address);
//            }
//        }
//        return userRepository.save(user);
    }

//    public User addUserWithCart(User user, Long cartId) {
//        Cart cart = cartRepository.findById(cartId).get();
//        user.setCart(cart);
//    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    public User updateUser(Long id, User user) {
        User foundUser = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found with id " + id));

        foundUser.setLastName(user.getLastName());
        foundUser.setFirstName(user.getFirstName());
        foundUser.setEmail(user.getEmail());;
        foundUser.setPhoneNumber(user.getPhoneNumber());
        foundUser.setPassword(user.getPassword());
        foundUser.setDefaultBillingAddress(user.getDefaultBillingAddress());
        foundUser.setDefaultDeliveryAddress(user.getDefaultDeliveryAddress());

        return userRepository.save(foundUser);
    }

    public Optional<User> findUserById(Long id) {
        return userRepository.findById(id);
    }

    public User findUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }
}
