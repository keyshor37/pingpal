package com.pingpal.user;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "bookings")
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String playerName;
    private String playerEmail;
    private String coachName;
    private Long coachId;
    private String message;
    private String preferredDate;
    private String status;
    private LocalDateTime createdAt = LocalDateTime.now();

    public Long getId() { return id; }
    public String getPlayerName() { return playerName; }
    public void setPlayerName(String v) { this.playerName = v; }
    public String getPlayerEmail() { return playerEmail; }
    public void setPlayerEmail(String v) { this.playerEmail = v; }
    public String getCoachName() { return coachName; }
    public void setCoachName(String v) { this.coachName = v; }
    public Long getCoachId() { return coachId; }
    public void setCoachId(Long v) { this.coachId = v; }
    public String getMessage() { return message; }
    public void setMessage(String v) { this.message = v; }
    public String getPreferredDate() { return preferredDate; }
    public void setPreferredDate(String v) { this.preferredDate = v; }
    public String getStatus() { return status; }
    public void setStatus(String v) { this.status = v; }
    public LocalDateTime getCreatedAt() { return createdAt; }
}
