package com.pingpal.user;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface CoachRepository extends JpaRepository<Coach, Long> {
    List<Coach> findByCity(String city);
}
