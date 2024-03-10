package com.d3labs.gamerrankingsystem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.d3labs.gamerrankingsystem.database.Services.PlayerService;

@Controller
public class HomeController {
    PlayerService _playerService;

    @Autowired
	public HomeController(PlayerService playerService) {
		_playerService = playerService;
	}

    @GetMapping("/")
	public ModelAndView home(){
		
		ModelAndView modelAndView = new ModelAndView("index");
		
		try {
            // Do something here
			return modelAndView;
            
			} catch(Exception e) {
				return new ModelAndView("/error");
			}
	}
}
