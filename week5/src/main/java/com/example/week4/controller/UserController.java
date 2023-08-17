package com.example.week4.controller;

import com.example.week4.dto.RequestUserDto;
import com.example.week4.dto.ResponseUserDto;
import com.example.week4.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService){
        this.userService=userService;
    }

    @GetMapping("/hello")
    public String hello(){
        return "<h2> hey, user</h2>";
    }

    @GetMapping("/user/{id}")   //endpoint1
    public ResponseEntity<ResponseUserDto> getUser(@PathVariable int id){
        ResponseUserDto user = userService.getUserById(id);
        if(user == null){
            return ResponseEntity.notFound().build();
        }
        ResponseUserDto responseUserDto = new
                ResponseUserDto(user.getId(), user.getFirst_name(),
                user.getLast_name(), user.getPhone(), user.getEmail(),user.getStatus(),
                user.getRole());
        return ResponseEntity.ok(responseUserDto);
    }

    @PostMapping("/user")    //endpoint2
    public void createUser(@RequestBody RequestUserDto userDto) {
        userService.createUser(userDto);
    }

    @PutMapping("/user/{id}")   //endpoints3
    public void updateUser(@PathVariable Integer id, @RequestBody ResponseUserDto responseUserDto) {
            userService.updateUser(id, responseUserDto);
        }

    @DeleteMapping("/user/{id}")  //endpoint4
    public void deleteUser(@PathVariable Integer id) {
        userService.deleteUser(id);
    }

    @GetMapping("/users")
    public List<ResponseUserDto> getAllUsers() {
        return userService.getAllUsers();
    }



}

