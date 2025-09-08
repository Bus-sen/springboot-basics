package com.busra.springbootbasics.service;

import com.busra.springbootbasics.model.User;
import java.util.List;

public interface UserService {
    User create(User user);
    List<User> getAllUsers();
    User update(long id, User user);
    void delete(long id);
}
