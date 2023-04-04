package com.springboot.controllers;

import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpSession;

import com.springboot.model.ActiveSpace;
import com.springboot.model.Space;
import com.springboot.repository.ActiveSpaceRepository;
import com.springboot.repository.SpaceRepository;
import org.hibernate.query.criteria.internal.expression.function.CurrentDateFunction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.springboot.model.UserDtls;
import com.springboot.model.Vehicle;
import com.springboot.repository.UserRepository;
import com.springboot.repository.VehicleRepository;

@Controller
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private UserRepository userRepo;

	@Autowired
	private ActiveSpaceRepository activeSpaceRepository;

	@Autowired
	private SpaceRepository spaceRepository;
	
	@Autowired
	private VehicleRepository vehicleRepository;

	@Autowired
	private BCryptPasswordEncoder passwordEncode;

	@GetMapping("/")
	public String home(Model model) {
		List<Space> space = spaceRepository.findAll();
		model.addAttribute("space", space.get(0));
		List<ActiveSpace> activeSpaceList = activeSpaceRepository.findAll();
		model.addAttribute("activeSpaceList", activeSpaceList);
		return "admin/home";
	}

	@GetMapping("/removevehicle")
	public String addspace() {
		return "admin/removevehicle";
	}

	@GetMapping("/changepassword")
	public String Changepassword() {
		return "admin/changepassword";
	}

	@GetMapping("/parkingreport")
	public String parkingreport(Model model) {
		List<Vehicle> vehicleList = vehicleRepository.findAll();
		for(int i = 0; i < vehicleList.size(); i++) {
			vehicleList.get(i).setSrNo(i+1);
		}
		model.addAttribute("vehicleList", vehicleList);
		return "admin/parkingreport";
	}


	@PostMapping("/updatePassword")
	public String changePassword(Principal p, @RequestParam("oldPass") String oldPass,
			@RequestParam("newPass") String newPass, HttpSession session) {

		String email = p.getName();

		UserDtls loginUser = userRepo.findByEmail(email);

		// password encoding
		boolean f = passwordEncode.matches(oldPass, loginUser.getPassword());

		
		if (f) {
			loginUser.setPassword(passwordEncode.encode(newPass)); // passwordEncode.encode
			UserDtls updatePasswordUser = userRepo.save(loginUser);

			if (updatePasswordUser != null) {
				session.setAttribute("msg", "Password Changed Successfully");
			} else {
				session.setAttribute("msg", "Something Wrong on Server!!");
			}

		} else {

			session.setAttribute("msg", "Incorrect old password");

		}
		return "redirect:/admin/changepassword";


	}

	@PostMapping("/removeVehicle")
	public String removeVehicle(@RequestParam("vehicleNo") String vehicleNumber) {
		ActiveSpace activeSpace = activeSpaceRepository.findByVehicleNumber(vehicleNumber).get(0);
		System.out.println("Removing Vehicle" + vehicleNumber + activeSpace);
		activeSpaceRepository.delete(activeSpace);
		Space space = spaceRepository.findAll().get(0);
		int totalSpace = (int)(activeSpaceRepository.count());
		space.setOccupied_Parking(totalSpace);
		space.setFree_Parking(100 - totalSpace);
		spaceRepository.save(space);
		return "admin/success";
	}


}
