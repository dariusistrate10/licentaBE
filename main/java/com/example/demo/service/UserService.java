package com.example.demo.service;

import com.example.demo.dto.UserPostDto;
import com.example.demo.model.Address;
import com.example.demo.repo.AddressRepository;
import com.example.demo.repo.CartRepository;
import com.example.demo.repo.UserRepository;
import com.example.demo.model.User;
import com.example.demo.security.PasswordEncryptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final AddressService addressService;
    private final CartRepository cartRepository;
    private final AddressRepository addressRepository;
    private final PasswordEncryptionService passwordEncryptionService;


    @Autowired
    public UserService(UserRepository userRepository, AddressRepository addressRepository, AddressService addressService, CartRepository cartRepository, PasswordEncryptionService passwordEncryptionService) {
        this.userRepository = userRepository;
        this.addressService = addressService;
        this.cartRepository = cartRepository;
        this.addressRepository = addressRepository;
        this.passwordEncryptionService = passwordEncryptionService;
    }

    public List<User> listAllUsers() {
        return userRepository.findAll();
    }

    public User addUser(UserPostDto userPostDTO) {
        User user = new User();
        user.setFirstName(userPostDTO.getFirstName());
        user.setLastName(userPostDTO.getLastName());
        user.setEmail(userPostDTO.getEmail());
        user.setPhoneNumber(userPostDTO.getPhoneNumber());
        user.setPassword(passwordEncryptionService.encryptPassword(userPostDTO.getPassword()));
        user.setDefaultDeliveryAddress(userPostDTO.getDefaultDeliveryAddress());
        user.setDefaultBillingAddress(userPostDTO.getDefaultBillingAddress());

        List<Address> addresses = userPostDTO.getAddresses().stream().map(addressDTO -> {
            Address address = new Address();
            address.setStreetLine(addressDTO.getStreetLine());
            address.setPostalCode(addressDTO.getPostalCode());
            address.setCity(addressDTO.getCity());
            address.setCountry(addressDTO.getCountry());
            return address;
        }).collect(Collectors.toList());

        user.setAddresses(addresses);

        for (Address address : addresses) {
            addressRepository.save(address);
        }

        return userRepository.save(user);
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    public User createUser(UserPostDto userDTO) {
        User user = new User();
        user.setFirstName(userDTO.getFirstName());
        user.setLastName(userDTO.getLastName());
        user.setEmail(userDTO.getEmail());
        user.setPhoneNumber(userDTO.getPhoneNumber());
        user.setPassword(userDTO.getPassword());
        user.setDefaultDeliveryAddress(userDTO.getDefaultDeliveryAddress());
        user.setDefaultBillingAddress(userDTO.getDefaultBillingAddress());

        List<Address> addresses = userDTO.getAddresses();
        if (addresses != null) {
            List<Address> savedAddresses = new ArrayList<>();
            for (Address address : addresses) {
                Address savedAddress = addressRepository.save(address);
                savedAddresses.add(savedAddress);
            }
            user.setAddresses(savedAddresses);
        }

        return userRepository.save(user);
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
