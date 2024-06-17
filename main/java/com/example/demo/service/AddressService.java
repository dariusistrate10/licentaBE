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

    public Address addAddress(Address address) {
        if(address.getStreetLine() != null && address.getPostalCode() != null && address.getCity() != null && address.getCountry() != null) {
            if(address.getPostalCode().matches("[0-9]+") && address.getStreetLine().matches("[a-z A-Z 0-9 .,]+") && address.getCity().matches("[a-z A-Z]+") && address.getCountry().matches("[a-z A-Z]+")) {
                addressRepository.save(address);
            } else System.out.println("Address inputs do not match the rules.");
        } else System.out.println("Address inputs might be null.");
        return address;
    }

    public Address updateAddress(Long id, Address address) {
        Address foundAddress = addressRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Address not found with id" + id));

        foundAddress.setCity(address.getCity());
        foundAddress.setStreetLine(address.getStreetLine());
        foundAddress.setCountry(address.getCountry());
        foundAddress.setCity(address.getCity());

        return addressRepository.save(address);
    }

    public void deleteAddress(Long id) {
        addressRepository.deleteById(id);
    }
}
