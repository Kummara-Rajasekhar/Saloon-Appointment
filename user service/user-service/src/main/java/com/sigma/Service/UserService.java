package com.sigma.Service;

import com.sigma.Exception.UserException;
import com.sigma.Model.User;

import java.util.List;

public interface UserService {
    User createUser(User user);
    User getUserById(Long id) throws UserException;
    List<User> getAllUsers();
    void deleteUser(Long id) throws Exception;
    User updateUser(Long id, User user) throws UserException;
}
