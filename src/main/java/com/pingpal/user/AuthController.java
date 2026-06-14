package com.pingpal.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Map;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired private UserService userService;

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
}
