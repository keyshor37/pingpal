package com.pingpal.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/players")
@CrossOrigin(origins = "*")
public class PlayerController {

    @Autowired private UserRepository userRepository;

    @GetMapping
    public List<User> getPlayers(@RequestParam(required = false) String city) {
        if (city != null) return userRepository.findByCity(city);
        return userRepository.findAll();
    }
}
