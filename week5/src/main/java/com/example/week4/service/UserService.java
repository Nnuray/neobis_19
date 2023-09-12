package com.example.week4.service;

import com.example.week4.dto.user.RequestUserDto;
import com.example.week4.dto.user.ResponseUserDto;
import com.example.week4.enums.Role;
import com.example.week4.entity.User;
import com.example.week4.enums.Status;
import com.example.week4.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.example.week4.dto.user.ResponseUserDto.toResponseUserDto;
import static com.example.week4.dto.user.ResponseUserDto.toResponseUserDtos;

@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public ResponseUserDto getUserById(int id) {
        return toResponseUserDto(userRepository.findById(id).get());
    }
    public String createUser(RequestUserDto userDto) {
        User user = User.builder()
                .firstName(userDto.getFirstName())
                .lastName(userDto.getLastName())
                .phoneNumber(userDto.getPhoneNumber())
                .status(Status.ACTIVE)
                .email(userDto.getEmail())
                .role(Role.USER)
                .build();
        userRepository.save(user);
        return "Пользователь создан";
    }

    public ResponseUserDto updateUser(int id, ResponseUserDto userDto) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Пользователь с таким айди не найден"));

        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setPhoneNumber(userDto.getPhoneNumber());
        user.setEmail(userDto.getEmail());

        userRepository.save(user);
        return toResponseUserDto(user);
    }

    public void deleteUser(int userId) {
        userRepository.deleteById(userId);
    }

    public List<ResponseUserDto> getAllUsers() {
        return toResponseUserDtos(userRepository.findAll());
    }


}