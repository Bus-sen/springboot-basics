package com.busra.springbootbasics.service;

import com.busra.springbootbasics.dto.request.UserRequest;
import com.busra.springbootbasics.dto.response.UserResponse;
import com.busra.springbootbasics.model.User;
import java.util.List;

public interface UserService {
    UserResponse create(UserRequest userRequest);
    List<UserResponse> getAllUsers();
    UserResponse update(long id, User user);
    void delete(long id);
}
