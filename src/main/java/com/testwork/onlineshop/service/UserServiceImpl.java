package com.testwork.onlineshop.service;

import com.testwork.onlineshop.entity.User;
import com.testwork.onlineshop.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User u=userRepo.findByUsername(username);
        if(u==null){
            throw new UsernameNotFoundException("user not found");
        }
        return u;
    }
    @Override
    public User findByUsername(String username) {
        return userRepo.findByUsername(username);
    }

    @Override
    public void save(User user) {
        userRepo.save(user);
    }

    @Override
    public User findById(Long id) {
        return userRepo.findById(id).get();
    }

    @Override
    public List<User> findAll() {
        return userRepo.findAll();
    }



    @Override
    public boolean addUser(User user) {
        User userDB = userRepo.findByUsername(user.getUsername());
        if (userDB != null) {
            return true;
        }
        userRepo.save(user);
        return false;
    }
}
