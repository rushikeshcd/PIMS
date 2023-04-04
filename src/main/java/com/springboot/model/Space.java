package com.springboot.model;


import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Space {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private int total_Parking;

    @Column
    private int occupied_Parking;

    @Column
    private int free_Parking;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTotal_Parking() {
        return total_Parking;
    }

    public void setTotal_Parking(int total_Parking) {
        this.total_Parking = total_Parking;
    }

    public int getOccupied_Parking() {
        return occupied_Parking;
    }

    public void setOccupied_Parking(int occupied_Parking) {
        this.occupied_Parking = occupied_Parking;
    }

    public int getFree_Parking() {
        return free_Parking;
    }

    public void setFree_Parking(int free_Parking) {
        this.free_Parking = free_Parking;
    }
}
