package com.springboot.model;

import javax.persistence.*;

import lombok.Data;

import java.time.LocalDateTime;
@Data
@Entity
@Table(name = "activespace")
public class ActiveSpace {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String vehicleNumber;

    @Column
    private String email;

    @Column
    private int amount_paid;

    @Column
    private LocalDateTime entry_datetime;

    @Column
    private LocalDateTime exit_datetime;


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    public int getAmount_paid() {
        return amount_paid;
    }

    public void setAmount_paid(int amount_paid) {
        this.amount_paid = amount_paid;
    }

    public LocalDateTime getEntry_datetime() {
        return entry_datetime;
    }

    public void setEntry_datetime(LocalDateTime entry_datetime) {
        this.entry_datetime = entry_datetime;
    }

    public LocalDateTime getExit_datetime() {
        return exit_datetime;
    }

    public void setExit_datetime(LocalDateTime exit_datetime) {
        this.exit_datetime = exit_datetime;
    }

    @Override
    public String toString() {
        return "ActiveSpace{" +
                "vehicleNumber='" + vehicleNumber + '\'' +
                ", amount_paid=" + amount_paid +
                ", entry_datetime=" + entry_datetime +
                ", exit_datetime=" + exit_datetime +
                '}';
    }

}
