package com.pingpal.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/bookings")
public class BookingController {

    @Autowired private BookingRepository bookingRepository;
    @Autowired private CoachRepository coachRepository;

    @PostMapping
    public ResponseEntity<?> createBooking(@RequestBody Map<String, Object> body) {
        Booking b = new Booking();
        b.setPlayerName((String) body.get("playerName"));
        b.setPlayerEmail((String) body.get("playerEmail"));
        b.setCoachId(Long.valueOf(body.get("coachId").toString()));
        b.setCoachName((String) body.get("coachName"));
        b.setMessage((String) body.get("message"));
        b.setPreferredDate((String) body.get("preferredDate"));
        b.setStatus("PENDING");
        bookingRepository.save(b);
        return ResponseEntity.ok("Booking request sent to " + b.getCoachName());
    }

    @GetMapping
    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }
}
