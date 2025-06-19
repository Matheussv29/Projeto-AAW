package com.example.usuario.service;

import com.example.usuario.model.User;
import com.example.usuario.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public List<User> findAllUsers() {
        return repository.findAll();
    }

    public User createUser(User user) {
        return repository.save(user);
    }
}
