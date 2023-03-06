package com.melikesivrikaya.interaction.controller;
import com.melikesivrikaya.interaction.model.User;
import com.melikesivrikaya.interaction.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
    public final UserService userService;
    @GetMapping
    public List<User> getAllUsers(){
        return userService.getAllUser();
    }
    @GetMapping("/{userId}")
    public User getUser(@PathVariable Long userId){
        return userService.getUser(userId);
    }
    @PostMapping
    public User saveUser(@RequestBody User newUser){
        return userService.saveUser(newUser);
    }

    @PutMapping
    public User updateUser(@RequestBody User newUser){
        return userService.updateUser(newUser);
    }

    @DeleteMapping("/{userId}")
    public void deleteUser(@PathVariable Long userId){
        userService.deleteUser(userId);
    }
}
