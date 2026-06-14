package com.pingpal.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired private UserRepository userRepository;
    @Autowired private PasswordEncoder passwordEncoder;

    public User register(String email, String password, String displayName, String city, Integer skillLevel) {
        if (userRepository.existsByEmail(email)) throw new RuntimeException("Email already exists");
        User user = new User();
        user.setEmail(email.toLowerCase());
        user.setPassword(passwordEncoder.encode(password));
        user.setDisplayName(displayName);
        user.setCity(city);
        user.setSkillLevel(skillLevel);
        return userRepository.save(user);
    }
}
