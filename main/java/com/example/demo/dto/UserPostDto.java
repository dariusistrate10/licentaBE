package com.example.demo.dto;

import com.example.demo.model.Address;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class UserPostDto {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String password;
    private String defaultDeliveryAddress;
    private String defaultBillingAddress;
    private List<Address> addresses;
}
