package com.busra.springbootbasics.controller;

import com.busra.springbootbasics.dto.request.UserRequest;
import com.busra.springbootbasics.dto.response.UserResponse;
import com.busra.springbootbasics.model.User;
import com.busra.springbootbasics.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    @PostMapping("/create")
    public UserResponse create(@Valid @RequestBody UserRequest userRequest) {
        return userService.create(userRequest);
    }

    @GetMapping
    public List<UserResponse> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public UserResponse getUserById(@PathVariable long id) {
        return userService.getUserById(id);
    }

    @PutMapping("/update/{id}")
    public UserResponse update(@Valid @PathVariable long id, @RequestBody User user) {
        return userService.update(id, user);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteUser(@PathVariable long id) {
        userService.delete(id);
    }
}
