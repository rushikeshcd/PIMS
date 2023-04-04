package com.springboot.controllers;

import java.security.Principal;
import java.time.LocalDateTime;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.springboot.model.*;
import com.springboot.repository.ActiveSpaceRepository;
import com.springboot.repository.SpaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springboot.repository.VehicleRepository;


@Controller
@RequestMapping("/booking")
public class BookingController {
	
	@Autowired
	private VehicleRepository vehicleRepository;

	@Autowired
	private ActiveSpaceRepository activeSpaceRepository;

	@Autowired
	private SpaceRepository spaceRepository;

	@GetMapping("")
	public String home() {
		return "booking/home";
	}

	@PostMapping("/initiateBooking")
	public String initiateBooking(BookingData bookingData, HttpServletRequest httpServletRequest,
								  HttpServletResponse httpServletResponse, Principal session) {
		System.out.println("\n\n\n\n<=========Control here inititiateBooking===========>");
		bookingData.setEmail(session.getName());
		System.out.println("<========Booking Data============>:"+bookingData.toString()+"\n\n\n\n"+session.getName());
		// Data stored in session

		httpServletRequest.getSession().setAttribute("initialBookingData",bookingData);
		return "booking/payment";
	}

	@PostMapping("/paymentComplete")
	public String paymentComplete(PaymentData paymentData, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
		System.out.println("\n\n\n\n<=======Control here paymentComplete=========>");
		System.out.println("<========Payment Data============>:"+paymentData+"\n\n\n\n");
		
		
		//Get data from session
		BookingData bookingData = (BookingData) httpServletRequest.getSession().getAttribute("initialBookingData");
		System.out.println("<========Booking Data============>:"+bookingData+"\n\n\n\n");
		Vehicle vehicle = new Vehicle();
		vehicle.setVehicle_no(bookingData.getVehicleno());
		vehicle.setEmail(bookingData.getEmail());
		vehicle.setAmount_paid(bookingData.getAmount());
		vehicle.setEntry_datetime(LocalDateTime.parse(bookingData.getEntrydate()));
		vehicle.setExit_datetime(LocalDateTime.parse(bookingData.getExitdate()));
		List<Space> spaceList = spaceRepository.findAll();

		ActiveSpace activeSpace = new ActiveSpace();
		activeSpace.setEmail(vehicle.getEmail());
		activeSpace.setAmount_paid(bookingData.getAmount());
		activeSpace.setEntry_datetime(LocalDateTime.parse(bookingData.getEntrydate()));
		activeSpace.setExit_datetime(LocalDateTime.parse(bookingData.getExitdate()));
		activeSpace.setVehicleNumber(bookingData.getVehicleno());
		activeSpaceRepository.save(activeSpace);
		vehicleRepository.save(vehicle);
		int totalSpace = (int)(activeSpaceRepository.count());
		Space space = spaceList.get(0);
		space.setOccupied_Parking(totalSpace);
		space.setFree_Parking(100 - totalSpace);
		spaceRepository.save(space);
		return "booking/success";
	}
}
