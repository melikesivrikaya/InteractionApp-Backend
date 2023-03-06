package com.melikesivrikaya.interaction.service;

import com.melikesivrikaya.interaction.model.User;
import com.melikesivrikaya.interaction.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{
    public final UserRepository userRepository;
    @Override
    public List<User> getAllUser() {
        return userRepository.findAll();
    }
    @Override
    public User getUser(Long userId) {
       Optional<User> user = userRepository.findById(userId);
       if (user.isPresent()){
           return user.get();
       }
        return null;
    }
    @Override
    public User saveUser(User newUser) {
        return userRepository.save(newUser);
    }
    @Override
    public User updateUser(User newUser) {
        if (isUser(newUser.getId())){
            return userRepository.save(newUser);
        }
        return null;
    }
    @Override
    public void deleteUser(Long userId) {
        if(isUser(userId)){
            userRepository.deleteById(userId);
        }
    }
    public boolean isUser(Long userId){
        Optional<User> user = userRepository.findById(userId);
        if (user.isPresent()){
            return true;
        }
        return false;
    }
}
