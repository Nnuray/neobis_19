package com.example.week4.service;

import com.example.week4.api.model.User;
import com.example.week4.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository){
        this.userRepository = userRepository; //эти данные должны лежать в бд
    }
    public Optional<User> getUser(Integer id) {
        return userRepository.findById(id);
    }

    public User createUser(User user) {
        userRepository.save(user);
        return user;
    }

    public User updateUser(User user, User updatedUser) {
        updatedUser.setId(user.getId());
        userRepository.save(updatedUser);
        return updatedUser;
    }

    public void deleteUser(User user) {
        userRepository.delete(user);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}
