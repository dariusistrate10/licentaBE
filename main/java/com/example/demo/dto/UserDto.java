package com.example.demo.dto;

import com.example.demo.model.Address;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class UserDto {
    private String id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String phoneNumber;
    private String defaultDeliveryAddress;
    private String defaultBillingAddress;
    private List<Address> addresses;
}
