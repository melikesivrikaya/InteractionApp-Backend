package com.melikesivrikaya.interaction.service;

import com.melikesivrikaya.interaction.model.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public interface UserService {

    List<User> getAllUser();

    User getUser(Long userId);

    User saveUser(User newUser);

    User updateUser(User newUser);

    void deleteUser(Long userId);
}
