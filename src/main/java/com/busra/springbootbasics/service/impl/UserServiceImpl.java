package com.busra.springbootbasics.service.impl;

import com.busra.springbootbasics.model.User;
import com.busra.springbootbasics.repository.UserRepository;
import com.busra.springbootbasics.service.UserService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Override
    @Transactional
    public User create(User user) {
        return userRepository.save(user);
/*
        if (true){
            throw new RuntimeException("Rollback test");
        }
        return user;
        */
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    @Transactional
    public User update(long id, User user) {
        if (userRepository.findById(id).isPresent()) {
            User updatedUser = userRepository.findById(id).get();
            updatedUser.setUsername(user.getUsername());
            updatedUser.setPassword(user.getPassword());
            updatedUser.setEmail(user.getEmail());
            updatedUser.setPhone(user.getPhone());
            return userRepository.save(updatedUser);
        } else {
            throw new RuntimeException("User with id " + id + " does not exist");
        }
    }

    @Override
    public void delete(long id) {
        if (userRepository.findById(id).isPresent()) {
            userRepository.deleteById(id);
        } else {
            throw new RuntimeException("User with id " + id + " does not exist");
        }
    }


}