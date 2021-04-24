package com.springbootcodeproject.springbootcodeproject.Controller;

import com.springbootcodeproject.springbootcodeproject.Model.User;
import com.springbootcodeproject.springbootcodeproject.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(path = "users", produces=MediaType.APPLICATION_JSON_VALUE)
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity getAllUsers(){
        List<User> users = userService.getAllUsers();

        return ResponseEntity.status(200).body(users);
    }

    @PostMapping
    public void Create(@RequestBody User user) {
        userService.create(user);
    }

    @GetMapping("/{id}")
    public User Read(@PathVariable Integer id) {
        return userService.read(id);
    }

    @PutMapping("/{id}")
    public User Update(@RequestBody User user, @PathVariable Integer id) {
        User updatedUser = userService.update(id, user);
        return updatedUser;
    }

    @DeleteMapping("/{id}")
    public void Delete(@PathVariable Integer id) {
        userService.delete(id);
    }
}
