package com.pingpal.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/sessions")
public class SessionController {

    @Autowired private SessionRepository sessionRepository;

    @GetMapping
    public List<Session> getSessions() {
        return sessionRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<?> createSession(@RequestBody Map<String, Object> body) {
        String title = (String) body.get("title");
        String venue = (String) body.get("venueName");
        String city = (String) body.get("city");
        String date = (String) body.get("scheduledAt");
        Object maxP = body.get("maxPlayers");
        String creator = (String) body.get("creatorName");
        if (title==null||title.isEmpty()) return ResponseEntity.badRequest().body("Title is required");
        if (venue==null||venue.isEmpty()) return ResponseEntity.badRequest().body("Venue is required");
        if (city==null||city.isEmpty()) return ResponseEntity.badRequest().body("City is required");
        if (date==null||date.isEmpty()) return ResponseEntity.badRequest().body("Date is required");
        if (maxP==null) return ResponseEntity.badRequest().body("Max players is required");
        Session s = new Session();
        s.setTitle(title); s.setVenueName(venue); s.setCity(city);
        s.setScheduledAt(date); s.setMaxPlayers(Integer.valueOf(maxP.toString()));
        s.setCreatorName(creator != null ? creator : "Anonymous");
        sessionRepository.save(s);
        return ResponseEntity.ok("Session created: " + title);
    }
}