package com.example.example.user;

import com.example.example.location.Location;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userrepository;
    public List<User> getAllUsers(){
        List<User> users=new ArrayList<>();
        userrepository.findAll().forEach(users::add);
        return users;
    }

    public Optional<User> getUser(Long id) {

        return userrepository.findById(id);
    }

    public void addUser(User user) {
        userrepository.save(user);
    }

    public void updateUser(Long id, User user) {
        User ur=userrepository.findById(id).orElseThrow(()->new IllegalStateException("user id is not exist"));
        ur.setEmail(user.getEmail());
        ur.setLastname(user.getLastname());
        ur.setFirstname(user.getFirstname());
        ur.setLocation_id(user.getLocation_id());
        userrepository.save(ur);
    }

    public void deleteUser(Long id) {
        userrepository.deleteById(id);
    }
}
