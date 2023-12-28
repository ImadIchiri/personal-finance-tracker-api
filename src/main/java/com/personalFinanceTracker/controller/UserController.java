package com.personalFinanceTracker.controller;

import com.personalFinanceTracker.model.User;
import com.personalFinanceTracker.service.InterUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/user")
public class UserController {

    @Autowired
    private InterUser userervice;

    @GetMapping("")
    public List<User> getAllUsers() {
        return userervice.getAllUsers();
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        Optional<User> optUser = userervice.getUserById(id);

        if (optUser.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        System.out.println("User: " + optUser.get());
        System.out.println("####################################");
        System.out.println("User's transList: " + optUser.get().getTransactionList());

        return new ResponseEntity<>(optUser.get(), HttpStatus.OK);
    }

    @PostMapping("/create")
    public User createUser(@RequestBody User user) {
        return userervice.createUser(user);
    }

    @PutMapping("/{id}/edit")
    public User editUser(@PathVariable Long id, @RequestBody User user) {
        return userervice.updateUser(user);
    }

    @DeleteMapping("/{id}/delete")
    public ResponseEntity<String> deleteUser(@PathVariable Long id, @RequestBody User user) {
        if (id != user.getId()) {
            return new ResponseEntity<>(
                    "Request Error: id on the the path not equal to the one on the Request Body !",
                    HttpStatus.OK);
        }

        userervice.deleteUser(user);
        return new ResponseEntity<>("User Deleted !", HttpStatus.OK);
    }

}
