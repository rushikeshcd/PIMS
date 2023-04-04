package com.springboot.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "vehicle")
public class Vehicle {

//	@Id
//	private String vehicleNumber;
//	
//	@Column
//	private VehicleType vehicleType;
//
//	public Vehicle(String vehicleNumber, VehicleType vehicleType) {
//		super();
//		this.vehicleNumber = vehicleNumber;
//		this.vehicleType = vehicleType;
//	}
    
	@Column
	private String vehicle_no;

	@Column
	private String email;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column
	private int amount_paid;

	@Column
	private LocalDateTime entry_datetime;

	@Column
	private LocalDateTime exit_datetime;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer srNo;

	public String getVehicle_no() {
		return vehicle_no;
	}

	public void setVehicle_no(String vehicle_no) {
		this.vehicle_no = vehicle_no;
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

	public Integer getSrNo() {
		return srNo;
	}

	public void setSrNo(Integer srNo) {
		this.srNo = srNo;
	}

	@Override
	public String toString() {
		return "Vehicle{" +
				"vehicle_no='" + vehicle_no + '\'' +
				", amount_paid=" + amount_paid +
				", entry_datetime=" + entry_datetime +
				", exit_datetime=" + exit_datetime +
				", srNo=" + srNo +
				'}';
	}
}
