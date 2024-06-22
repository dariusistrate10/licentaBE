package com.example.demo.controller;

import com.example.demo.dto.MapStructMapper;
import com.example.demo.dto.UserDto;
import com.example.demo.dto.UserPostDto;
import com.example.demo.security.PasswordEncryptionService;
import com.example.demo.service.AddressService;
import com.example.demo.service.OrdersService;
import com.example.demo.service.UserService;
import com.example.demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "http://localhost:4200/")
@RequestMapping("/users")
public class UserController {
    private final UserService userService;
    private final MapStructMapper mapStructMapper;
    private final PasswordEncryptionService passwordEncryptionService;

    @Autowired
    public UserController(UserService userService, OrdersService ordersService, AddressService addressService, MapStructMapper mapStructMapper, PasswordEncryptionService passwordEncryptionService) {
        this.userService = userService;
        this.mapStructMapper = mapStructMapper;
        this.passwordEncryptionService = passwordEncryptionService;
    }

    @GetMapping
    public List<UserDto> listAllUsers() {
        List<User> users = userService.listAllUsers();
        List<UserDto> usersDto = users
                .stream()
                .map(mapStructMapper::userToUserDto)
                .collect(Collectors.toList());
        return usersDto;
    }

    @GetMapping("find/{id}")
    public UserDto findUserById(@PathVariable("id") Long id) {
        return mapStructMapper.userToUserDto(userService.findUserById(id).get());
    }

    @PostMapping("/add")
    public ResponseEntity<User> addUser(@RequestBody UserPostDto userPostDTO) {
        User createdUser = userService.addUser(userPostDTO);
        return ResponseEntity.ok(createdUser);
    }

    @PostMapping("/add-user")
    public User createUser(@RequestBody UserPostDto userDTO) {
        return userService.createUser(userDTO);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteUser(@PathVariable("id") Long id) {
        userService.deleteUser(id);
    }

    @PutMapping("/update/{id}")
    public void updateUser(@PathVariable("id") Long id, @RequestBody User user) {
        userService.updateUser(id, user);
    }

    @GetMapping("/search")
    public User findUserByEmail(@RequestParam String email, @RequestParam String password) {
        User user = userService.findUserByEmail(email);
        boolean isPasswordMatch = passwordEncryptionService.matches(password, user.getPassword());
        if (isPasswordMatch) {
            return user;
        } else return null;
    }
}
