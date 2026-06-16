package com.pingpal.user;

import jakarta.persistence.*;

@Entity
@Table(name = "coaches")
public class Coach {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String city;
    private String bio;
    private Double hourlyRate;
    private Integer experienceYears;
    private String speciality;

    public Long getId() { return id; }
    public String getName() { return name; }
    public void setName(String n) { this.name = n; }
    public String getCity() { return city; }
    public void setCity(String c) { this.city = c; }
    public String getBio() { return bio; }
    public void setBio(String b) { this.bio = b; }
    public Double getHourlyRate() { return hourlyRate; }
    public void setHourlyRate(Double h) { this.hourlyRate = h; }
    public Integer getExperienceYears() { return experienceYears; }
    public void setExperienceYears(Integer e) { this.experienceYears = e; }
    public String getSpeciality() { return speciality; }
    public void setSpeciality(String s) { this.speciality = s; }
}
