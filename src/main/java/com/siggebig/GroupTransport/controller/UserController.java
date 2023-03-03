package com.siggebig.GroupTransport.controller;

import com.siggebig.GroupTransport.model.User;
import com.siggebig.GroupTransport.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class UserController {


    @Autowired
    private UserService userService;


    @GetMapping("users")
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = userService.getAll();

        if (users.isEmpty()) {
            return ResponseEntity
                    .status(204)
                    .header("x-info", "no users was found in database")
                    .build();
        } else {
            return ResponseEntity.ok(users);
        }
    }

    @PostMapping
    @PatchMapping
    @PutMapping
    public ResponseEntity<List<User>> createUser(@RequestBody User user) {
        userService.save(user);
        return getAllUsers();
    }


    @DeleteMapping("user/{userId}")
    public ResponseEntity<List<User>> deleteUser(@PathVariable long userId) {
        userService.delete(userId);
        return getAllUsers();
    }

    @PostMapping("user/{userId}/{groupId}")
    public ResponseEntity<String> addUserToGroup(@PathVariable Long userId, @PathVariable Long groupId) {
        userService.addUserToGroup(userId, groupId);
        return ResponseEntity.ok("User added to group successfully.");
    }

    @DeleteMapping("user/{userId}/{groupId}")
    public ResponseEntity<String> removeUserFromGroup(@PathVariable Long userId, @PathVariable Long groupId) {
        userService.removeUserFromGroup(userId, groupId);
        return ResponseEntity.ok("User removed from group successfully.");
    }


}