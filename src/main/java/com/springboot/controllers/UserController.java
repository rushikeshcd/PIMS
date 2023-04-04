package com.springboot.controllers;

import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpSession;

import com.springboot.model.Space;
import com.springboot.model.Vehicle;
import com.springboot.repository.SpaceRepository;
import com.springboot.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.springboot.model.UserDtls;
import com.springboot.repository.UserRepository;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncode;
	@Autowired
	private SpaceRepository spaceRepository;
	@Autowired
	private VehicleRepository vehicleRepository;

	@ModelAttribute
	private void userDetails(Model ma, Principal p) {
		String email = p.getName();
		UserDtls user = userRepo.findByEmail(email);

		ma.addAttribute("user", user);

	}

	@GetMapping("/")
	public String home(Model model) {
		List<Space> space = spaceRepository.findAll();
		model.addAttribute("space", space.get(0));
		return "user/home";
	}
	
	@GetMapping("/bookingslot")
	public String bookingslot() {
		return "user/bookingslot";
	}
	
	
	@GetMapping("/manageprofile")
	public String manageprofile() {
		return "user/manageprofile";
	}
	
	@GetMapping("/changepassword")
	public String Changepassword() {
		return "user/changepassword";
	}
	
	@GetMapping("/payment")
	public String payment() {
		return "user/payment";
	}
	
	@GetMapping("/bookinghistory")
	public String bookinghistory(Model model, Principal p) {
		String email = p.getName();
		List<Vehicle> vehicleList = vehicleRepository.findByEmail(email);
		for(int i = 0; i < vehicleList.size(); i++) {
			vehicleList.get(i).setSrNo(i+1);
		}
		model.addAttribute("vehicleList", vehicleList);
		return "user/bookinghistory";
	}
	
	
	//update old pass with new within session
	@PostMapping("/updatePassword")
	public String changePassword(Principal p, @RequestParam("oldPass")String oldPass, @RequestParam("newPass")String newPass,HttpSession session) {
		
		String email = p.getName();
		
		UserDtls loginUser = userRepo.findByEmail(email);
		
		// password encoding
		boolean f = passwordEncode.matches(oldPass, loginUser.getPassword());
		
		if (f) {
			loginUser.setPassword(passwordEncode.encode(newPass));   //passwordEncode.encode
			UserDtls updatePasswordUser = userRepo.save(loginUser);
			
			if (updatePasswordUser != null) {
				session.setAttribute("msg", "Password Changed Successfully");
			}else {
				session.setAttribute("msg", "Something Wrong on Server!!");
			}
			
		} else {
			
			session.setAttribute("msg", "Incorrect old password");
			
		}
		return "redirect:/user/changepassword";
		
	}

	@GetMapping("/parkingreport")
	public String parkingreport(Model model,  Principal p) {
		String email = p.getName();
		List<Vehicle> vehicleList = vehicleRepository.findAll();
		for(int i = 0; i < vehicleList.size(); i++) {
			vehicleList.get(i).setSrNo(i+1);
		}
		model.addAttribute("vehicleList", vehicleList);
		return "user/parkingreport";
	}
	
	
	
	
}
