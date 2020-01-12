package com.testwork.onlineshop.service;

import com.testwork.onlineshop.entity.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface UserService extends UserDetailsService {
    @Override
    UserDetails loadUserByUsername(String s) throws UsernameNotFoundException;
    boolean addUser(User user);
    User findByUsername(String username);
    void save(User user);
    User findById(Long id);
    List<User> findAll();
}
