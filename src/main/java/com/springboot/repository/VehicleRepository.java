package com.springboot.repository;

import com.springboot.model.UserDtls;
import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.model.Vehicle;

import java.util.List;

public interface VehicleRepository extends JpaRepository<Vehicle, String> {
    public List<Vehicle> findByEmail(String email);
}


