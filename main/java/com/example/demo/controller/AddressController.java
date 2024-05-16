package com.example.demo.controller;

import com.example.demo.model.Address;
import com.example.demo.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:4200/")
@RequestMapping("/address")
public class AddressController {
    private final AddressService addressService;

    @Autowired
    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @GetMapping
    public List<Address> listAllAddresses() {
        return addressService.listAllAddresses();
    }

    @GetMapping("find/{id}")
    public Optional<Address> findAddressById(@PathVariable("id") Long id) {
        return addressService.findAddressById(id);
    }

    @PostMapping("/add")
    public void addAddress(@RequestBody Address address) {
        addressService.addAddress(address);
    }

    @PutMapping("/update")
    public void updateAddress(@RequestBody Address address) {
        addressService.updateAddress(address);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteAddress(@PathVariable("id") Long id) {
        addressService.deleteAddress(id);
    }
}
