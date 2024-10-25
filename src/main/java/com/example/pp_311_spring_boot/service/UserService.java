package com.example.pp_311_spring_boot.service;


import com.example.pp_311_spring_boot.model.User;

import java.util.List;

public interface UserService  {
    public List<User> getUsers();
    public void deleteUser(User user);
    public User addUser(User user);
    public void updateUser(User user);
    public User getUserById(Long id);
}
