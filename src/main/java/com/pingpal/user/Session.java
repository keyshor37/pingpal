package com.pingpal.user;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "sessions")
public class Session {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String venueName;
    private String city;
    private String scheduledAt;
    private Integer maxPlayers;
    private String creatorName;
    private LocalDateTime createdAt = LocalDateTime.now();

    public Long getId() { return id; }
    public String getTitle() { return title; }
    public void setTitle(String v) { this.title = v; }
    public String getVenueName() { return venueName; }
    public void setVenueName(String v) { this.venueName = v; }
    public String getCity() { return city; }
    public void setCity(String v) { this.city = v; }
    public String getScheduledAt() { return scheduledAt; }
    public void setScheduledAt(String v) { this.scheduledAt = v; }
    public Integer getMaxPlayers() { return maxPlayers; }
    public void setMaxPlayers(Integer v) { this.maxPlayers = v; }
    public String getCreatorName() { return creatorName; }
    public void setCreatorName(String v) { this.creatorName = v; }
    public LocalDateTime getCreatedAt() { return createdAt; }
}
