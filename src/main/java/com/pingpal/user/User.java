package com.pingpal.user;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String email;
    private String password;
    private String displayName;
    private String city;
    private Integer skillLevel;
    private String role = "PLAYER";
    private LocalDateTime createdAt = LocalDateTime.now();

    public Long getId() { return id; }
    public String getEmail() { return email; }
    public void setEmail(String e) { this.email = e; }
    public String getPassword() { return password; }
    public void setPassword(String p) { this.password = p; }
    public String getDisplayName() { return displayName; }
    public void setDisplayName(String d) { this.displayName = d; }
    public String getCity() { return city; }
    public void setCity(String c) { this.city = c; }
    public Integer getSkillLevel() { return skillLevel; }
    public void setSkillLevel(Integer s) { this.skillLevel = s; }
    public String getRole() { return role; }
    public void setRole(String r) { this.role = r; }
}
