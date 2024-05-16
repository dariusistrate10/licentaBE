package com.example.demo.controller;

import com.example.demo.dto.MapStructMapper;
import com.example.demo.dto.UserDto;
import com.example.demo.dto.UserPostDto;
import com.example.demo.service.AddressService;
import com.example.demo.service.UserService;
import com.example.demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "http://localhost:4200/")
@RequestMapping("/users")
public class UserController {
    private final UserService userService;
    private final MapStructMapper mapStructMapper;

    @Autowired
    public UserController(UserService userService, AddressService addressService, MapStructMapper mapStructMapper) {
        this.userService = userService;
        this.mapStructMapper = mapStructMapper;
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
    public void addUser(@RequestBody UserPostDto userPostDto) {
        userService.addUser(mapStructMapper.userPostDtoToUser(userPostDto));
    }

    @DeleteMapping("/delete/{id}")
    public void deleteUser(@PathVariable("id") Long id) {
        userService.deleteUser(id);
    }

    @PutMapping("/update")
    public void updateUser(@RequestBody User user) {
        userService.updateUser(user);
    }

    @GetMapping("/search")
    public User findUserByEmail(@RequestParam String email) {
        User user = userService.findUserByEmail(email);
        return user;
    }
}
