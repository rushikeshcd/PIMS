package com.springboot.model;

public class BookingData {

	private String vehicleno;

	private String email;
	private String entrydate;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	private String exitdate;
	private Integer amount;

	public String getVehicleno() {
		return vehicleno;
	}

	public void setVehicleno(String vehicleno) {
		this.vehicleno = vehicleno;
	}

	public String getEntrydate() {
		return entrydate;
	}

	public void setEntrydate(String entrydate) {
		this.entrydate = entrydate;
	}

	public String getExitdate() {
		return exitdate;
	}

	public void setExitdate(String exitdate) {
		this.exitdate = exitdate;
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "BookingData{" +
				"vehicleno='" + vehicleno + '\'' +
				", entrydate='" + entrydate + '\'' +
				", exitdate='" + exitdate + '\'' +
				", amount=" + amount +
				'}';
	}
}
