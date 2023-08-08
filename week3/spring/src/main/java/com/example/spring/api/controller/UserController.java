package com.example.spring.api.controller;

import com.example.spring.api.model.User;
import com.example.spring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class UserController {
    private UserService userService;
    @Autowired
    public UserController(UserService userService){
        this.userService=userService;
    }
    @GetMapping("/user")   //endpoint1
    public User getUser(@RequestParam Integer id){
        Optional <User> user = userService.getUser(id);
        if(user.isPresent()){
            return (User) user.get();
        }
        return null;
    }

    @PostMapping("/user")    //endpoint2
    public User createUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    @PutMapping("/user/{id}")   //endpoints3
    public User updateUser(@PathVariable Integer id, @RequestBody User updatedUser) {
        Optional<User> user = userService.getUser(id);
        if(user.isPresent()){
            return userService.updateUser(user.get(), updatedUser);
        }
        return null;
    }
    @DeleteMapping("/user/{id}")  //endpoint4
    public void deleteUser(@PathVariable Integer id) {
        Optional<User> user = userService.getUser(id);
        if(user.isPresent()){
            userService.deleteUser(user.get());
        }
    }

    @GetMapping("/users")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }



}
