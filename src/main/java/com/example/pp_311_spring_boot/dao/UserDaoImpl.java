package com.example.pp_311_spring_boot.dao;

import com.example.pp_311_spring_boot.model.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<User> getUsers() {
        TypedQuery<User> query = em.createQuery("select u from User u", User.class);
        return query.getResultList();
    }

    @Transactional
    @Override
    public void deleteUser(User user) {
        if (user.getId() != null) {
            User existingUser = em.find(User.class, user.getId());
            if (existingUser != null) {
                em.remove(existingUser);
            }
        }
    }

    @Transactional
    @Override
    public User addUser(User user) {
        em.persist(user);
        return user;
    }

    @Transactional
    @Override
    public void updateUser(User user) {
        if (user.getId() != null) {
            User existingUser = em.find(User.class, user.getId());
            if (existingUser != null) {
                existingUser.setFirstName(user.getFirstName());
                existingUser.setLastName(user.getLastName());
                existingUser.setEmail(user.getEmail());
                existingUser.setAge(user.getAge());
                em.merge(existingUser);
            }
        }
    }


    @Override
    public User getUserById(Long id) {
        return em.find(User.class, id);
    }
}
