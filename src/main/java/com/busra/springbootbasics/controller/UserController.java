package com.busra.springbootbasics.controller;

import com.busra.springbootbasics.dto.request.UserRequest;
import com.busra.springbootbasics.dto.response.UserResponse;
import com.busra.springbootbasics.model.User;
import com.busra.springbootbasics.service.UserService;
import com.busra.springbootbasics.service.impl.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {
    private final UserServiceImpl userServiceImpl;

    @PostMapping("/create")
    public UserResponse create(@RequestBody UserRequest userRequest) {
        return userServiceImpl.create(userRequest);
    }

    @GetMapping
    public List<UserResponse> getAllUsers() {
        return userServiceImpl.getAllUsers();
    }

    @PutMapping("/update/{id}")
    public UserResponse update(@PathVariable long id, @RequestBody User user) {
        return userServiceImpl.update(id, user);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteUser(@PathVariable long id) {
        userServiceImpl.delete(id);
    }
}
