package com.example.week4.controller;

import com.example.week4.dto.user.RequestUserDto;
import com.example.week4.dto.user.ResponseUserDto;
import com.example.week4.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
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

    @GetMapping("/{id}")   //endpoint1
    public ResponseEntity<ResponseUserDto> getUserById(@PathVariable int id){
        ResponseUserDto user = userService.getUserById(id);
        if(user == null){
            return ResponseEntity.notFound().build();
        }
        ResponseUserDto responseUserDto = new
                ResponseUserDto(user.getId(), user.getFirstName(),
                user.getLastName(), user.getPhoneNumber(), user.getEmail(),user.getStatus(),
                user.getRole());
        return ResponseEntity.ok(responseUserDto);
    }

    @PostMapping()    //endpoint2
    public void createUser(@RequestBody RequestUserDto userDto) {
        userService.createUser(userDto);
    }

    @PutMapping("/{id}")   //endpoints3
    public void updateUser(@PathVariable Integer id, @RequestBody ResponseUserDto responseUserDto) {
            userService.updateUser(id, responseUserDto);
        }

    @DeleteMapping("/{id}")  //endpoint4
    public void deleteUser(@PathVariable Integer id) {
        userService.deleteUser(id);
    }

    @GetMapping()
    public List<ResponseUserDto> getAllUsers() {
        return userService.getAllUsers();
    }



}

