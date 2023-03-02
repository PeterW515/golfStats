package com.pwgolf.golfStats.controller;

import com.pwgolf.golfStats.model.impl.User;
import com.pwgolf.golfStats.model.api.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
//import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
public class UserController {
    UserRepository repository;

    @Autowired
    public UserController(UserRepository userRepository) {
        this.repository = userRepository;
    }

    @GetMapping("/api/users")
    public List<User> getAllUsers() {
        List<User> userList = repository.findAll();
        return userList;
    }

    @GetMapping("/api/users/{id}")
    public User getUserById(@PathVariable Long id) {
        return repository.getReferenceById(id);
    }

    @PostMapping("/api/users")
    public User addUser(@RequestBody User user) {
        //user.setPassword(BCrypt.hashpw(user.getPassword(), BCrypt.gensalt()));
        repository.save(user);
        return user;
    }

    @PutMapping("/api/users/{id}")
    public User updateUser(@PathVariable Long id, @RequestBody User user) {
        User tempUser = repository.getReferenceById(id);
        if (Objects.nonNull(tempUser)) {
            user.setId(tempUser.getId());
            repository.save(user);
        }
        return user;
    }

    @DeleteMapping("api/users/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteUser(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
