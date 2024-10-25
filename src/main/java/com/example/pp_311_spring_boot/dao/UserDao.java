package com.example.pp_311_spring_boot.dao;

import com.example.pp_311_spring_boot.model.User;

import java.util.List;

public interface UserDao {
    List<User> getUsers();

    void deleteUser(User user);

    User addUser(User user);

    void updateUser(User user);

    User getUserById(Long id);
}
