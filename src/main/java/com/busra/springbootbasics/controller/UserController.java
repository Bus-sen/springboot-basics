package com.busra.springbootbasics.controller;

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
    public User create(@RequestBody User user) {
        return userServiceImpl.create(user);
    }

    @GetMapping
    public List<User> getAllUsers() {
        return userServiceImpl.getAllUsers();
    }

    @PutMapping("/update/{id}")
    public User update(@PathVariable long id, @RequestBody User user) {
        return userServiceImpl.update(id, user);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteUser(@PathVariable long id) {
        userServiceImpl.delete(id);
    }
}
