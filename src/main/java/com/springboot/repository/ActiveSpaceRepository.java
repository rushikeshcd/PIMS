package com.springboot.repository;

import com.springboot.model.ActiveSpace;
import com.springboot.model.UserDtls;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ActiveSpaceRepository extends JpaRepository<ActiveSpace, Integer> {

    public List<ActiveSpace> findByVehicleNumber(String vehicleNumber);

}
