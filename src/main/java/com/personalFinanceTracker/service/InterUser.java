package com.personalFinanceTracker.service;

import com.personalFinanceTracker.model.Type;
import com.personalFinanceTracker.model.User;

import java.util.List;
import java.util.Optional;

public interface InterUser {
    User createUser(User user);

    List<User> getAllUsers();

    Optional<User> getUserById(Long id);

    void deleteUser(User user);

    User updateUser(User user);
}
