package com.pingpal.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/coaches")
public class CoachController {

    @Autowired private CoachRepository coachRepository;

    @GetMapping
    public List<Coach> getCoaches(@RequestParam(required = false) String city) {
        if (city != null) return coachRepository.findByCity(city);
        return coachRepository.findAll();
    }

    @PostMapping
    public Coach addCoach(@RequestBody Coach coach) {
        return coachRepository.save(coach);
    }
}
