package com.housebooking.app.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.housebooking.app.model.HouseModel;
import com.housebooking.app.model.UserModel;
import com.housebooking.app.service.HomeService;
import com.housebooking.app.service.HouseOwnerService;
import com.housebooking.app.utils.FileUploadUtil;

@Controller
public class HouseOwnerController {
	@Autowired
	private HomeService homeService;
	
	@Autowired
	private HouseOwnerService houseOwnerService;
	
	@GetMapping("/houseowner")
	public String getHouseOwnerWelcomePage(@ModelAttribute("user") UserModel user, Model model, HttpSession session)
	{
		@SuppressWarnings("unchecked")
        List<String> messages = (List<String>) session.getAttribute("MY_SESSION_MESSAGES");

        if (messages == null) {
            messages = new ArrayList<>();
        }
        model.addAttribute("sessionMessages", messages);
        UserModel userdata = homeService.findUser(messages.get(0));
        model.addAttribute("role", userdata.getUsertype());
//        String base64EncodedImage = Base64.getEncoder().encodeToString(houseOwnerService.getHouse().getHousePhoto());
//        model.addAttribute("image", base64EncodedImage);
//        System.out.println(base64EncodedImage);
		return "houseowner/welcomehouseowner";
	}
	
	@GetMapping("/createHouse")
	public String createHouse(Model model) {
		
		HouseModel house = new HouseModel();
		model.addAttribute("house", house);
		return "houseowner/createhouse";
	}
	
	@PostMapping("/saveHouse")
	public String saveHouseBooking(@ModelAttribute("house") HouseModel house, @RequestParam("image") MultipartFile multipartFile)
	{
		System.out.println("house created");
		String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
		
		try {
			house.setHousePhoto(Base64.getEncoder().encodeToString(multipartFile.getBytes()));
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		house.setIsBooked(0);
		house.setIsHide(0);
		houseOwnerService.saveHouse(house);
		
		return "redirect:/houseowner";
	}
	
	@GetMapping("/viewHouses")
	public String viewHouses(Model model, HttpSession session) {
		
		
		@SuppressWarnings("unchecked")
        List<String> messages = (List<String>) session.getAttribute("MY_SESSION_MESSAGES");
		if(messages == null) {
			model.addAttribute("errormsg", "Session Expired. Please Login Again");
			return "home/error";
		}
		UserModel userdata = homeService.findUser(messages.get(0));
		List<HouseModel> houses = houseOwnerService.getAllHousesByEmail(userdata.getEmail());
		model.addAttribute("houses", houses);
		return "houseowner/displayhouses";
	}
}
