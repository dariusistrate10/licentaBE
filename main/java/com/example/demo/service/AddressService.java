package com.example.demo.service;

import com.example.demo.model.Address;
import com.example.demo.repo.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AddressService {
    private final AddressRepository addressRepository;

    @Autowired
    public AddressService(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    public List<Address> listAllAddresses() {
        return addressRepository.findAll();
    }

    public Optional<Address> findAddressById(Long id) {
        return addressRepository.findById(id);
    }

    public void addAddress(Address address) {
        if(address.getStreetLine() != null && address.getPostalCode() != null && address.getCity() != null && address.getCountry() != null) {
            if(address.getPostalCode().matches("[0-9]+") && address.getStreetLine().matches("[a-z A-Z 0-9 .,]+") && address.getCity().matches("[a-z A-Z]+") && address.getCountry().matches("[a-z A-Z]+")) {
                addressRepository.save(address);
            } else System.out.println("Address inputs do not match the rules.");
        } else System.out.println("Address inputs might be null.");
    }

    public Address updateAddress(Address address) {
        return addressRepository.save(address);
    }

    public void deleteAddress(Long id) {
        addressRepository.deleteById(id);
    }
}
