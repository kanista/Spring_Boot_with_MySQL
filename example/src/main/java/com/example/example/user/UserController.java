package com.example.example.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import com.example.example.location.Location;

@RestController
public class UserController {
    @Autowired
    private UserService userservice;
    @RequestMapping(value ="/users")
    public List<User> getAllUsers(){
        return userservice.getAllUsers();
    }

    @RequestMapping(value = "/users/{id}")
    public Optional<User> getUser(@PathVariable Long id){
        return userservice.getUser(id);
    }
    @RequestMapping(value = "/users",method = RequestMethod.POST)
    public void addUser(@RequestBody User user){
        userservice.addUser(user);
    }
    @RequestMapping(value = "/users/{id}",method = RequestMethod.PUT)
    public void updateUser(@PathVariable Long id,@RequestBody User user){
        userservice.updateUser(id,user);
    }
    @RequestMapping(value = "/users/{id}",method =RequestMethod.DELETE)
    public void deleteUser(@PathVariable Long id){
        userservice.deleteUser(id);
    }
}
