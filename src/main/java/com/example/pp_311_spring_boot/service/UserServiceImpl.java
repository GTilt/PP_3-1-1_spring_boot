package com.example.pp_311_spring_boot.service;

import com.example.pp_311_spring_boot.dao.UserDao;
import com.example.pp_311_spring_boot.model.User;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserDao userDAO;

    public UserServiceImpl(UserDao userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    public List<User> getUsers() {
        return userDAO.getUsers();
    }


    @Override
    @Transactional
    public void deleteUser(User user) {
        userDAO.deleteUser(user);
    }


    @Override
    @Transactional
    public User addUser(User user) {
        return userDAO.addUser(user);
    }


    @Override
    @Transactional
    public void updateUser(User user) {
        userDAO.updateUser(user);
    }

    @Override
    public User getUserById(Long id) {
        return userDAO.getUserById(id);
    }
}
