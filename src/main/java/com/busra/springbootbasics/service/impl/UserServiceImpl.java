package com.busra.springbootbasics.service.impl;

import com.busra.springbootbasics.dto.request.UserRequest;
import com.busra.springbootbasics.dto.response.UserResponse;
import com.busra.springbootbasics.model.User;
import com.busra.springbootbasics.repository.UserRepository;
import com.busra.springbootbasics.service.UserService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    @Override
    @Transactional
    public UserResponse create(UserRequest userRequest) {
        User user = modelMapper.map(userRequest, User.class);   //request -> entity dönüşümü
        userRepository.save(user);
        return new UserResponse("Kullanıcı oluşturuldu");
        /*
        UserResponse userResponse = modelMapper.map(user, UserResponse.class);  //entity -> response dönüşümü
        return userResponse;
         */


        /*
        User user = new User();
        user.setUsername(userRequest.getUsername());
        user.setPassword(userRequest.getPassword());
        userRepository.save(user);

        UserResponse userResponse = new UserResponse();
        userResponse.setMessage("Kullanıcı oluşturuldu");
        return userResponse;
         */
/*
        if (true){
            throw new RuntimeException("Rollback test");
        }
        return user;
        */
    }

    @Override
    public List<UserResponse> getAllUsers() {
        List<User> users = userRepository.findAll();
        List<UserResponse> userResponseList = new ArrayList<>();
        for (User user : users) {
            UserResponse userResponse = new UserResponse();
            userResponse.setMessage("Kullanıcı Bilgileri: " + user.getUsername() + " | " + user.getEmail());
            userResponseList.add(userResponse);
        }
        return userResponseList;
    }

    @Override
    public UserResponse getUserById(Long id) {
        User getUser =  userRepository.findById(id).get();
        UserResponse userResponse = modelMapper.map(getUser, UserResponse.class);
        userResponse.setMessage("Kullanıcı adı: " +getUser.getUsername()
                + " | Mail adresi: " + getUser.getEmail() + " | Telefon no: " + getUser.getPhone());
        return userResponse;
    }


    @Override
    @Transactional
    public UserResponse update(long id, User user) {
        User updatedUser = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User with id " + id + " does not exist"));

        modelMapper.map(user, updatedUser); //user -> updatedUser dönüşümü
        updatedUser.setId(id);
        userRepository.save(updatedUser);
        return new UserResponse("Kullanıcı güncellendi");

        /*
        if (userRepository.findById(id).isPresent()) {
            User updatedUser = userRepository.findById(id).get();
            updatedUser.setUsername(user.getUsername());
            updatedUser.setPassword(user.getPassword());
            updatedUser.setEmail(user.getEmail());
            updatedUser.setPhone(user.getPhone());
            userRepository.save(updatedUser);
        } else {
            throw new RuntimeException("User with id " + id + " does not exist");
        }
        UserResponse userResponse = new UserResponse();
        userResponse.setMessage("Kullanıcı güncellendi");
        return userResponse;
         */
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