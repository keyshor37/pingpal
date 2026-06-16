package com.pingpal.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import java.util.Map;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired private UserService userService;
    @Autowired private PasswordEncoder passwordEncoder;
    @Autowired private UserRepository userRepository;

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody Map<String, Object> body) {
        User user = userService.register(
            (String) body.get("email"),
            (String) body.get("password"),
            (String) body.get("displayName"),
            (String) body.get("city"),
            (Integer) body.get("skillLevel")
        );
        return ResponseEntity.ok("Registered: " + user.getEmail());
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Map<String, Object> body) {
        String email = (String) body.get("email");
        String password = (String) body.get("password");
        try {
            User user = userService.findByEmail(email);
            if (passwordEncoder.matches(password, user.getPassword())) {
                return ResponseEntity.ok(Map.of("message", "Login successful", "displayName", user.getDisplayName(), "city", user.getCity(), "skillLevel", user.getSkillLevel()));
            } else {
                return ResponseEntity.status(401).body("Invalid password");
            }
        } catch (Exception e) {
            return ResponseEntity.status(401).body("User not found");
        }
    }
}
