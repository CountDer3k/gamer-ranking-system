package com.d3labs.gamerrankingsystem;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.d3labs.gamerrankingsystem.database.Models.PlayerModel;
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
			List<PlayerModel> players = _playerService.getAllPlayers();

			if(players.size() == 0){
				// Return empty view
				//modelAndView.getModelMap().addAttribute("isEmpty", true);
				//modelAndView.getModelMap().addAttribute("empty", "No content available to display...");
			}
			else {
				// Add players to view
				modelAndView.getModelMap().addAttribute("playerList", players);
			}

			return modelAndView;
            
		} catch(Exception e) {
				return new ModelAndView("/error");
		}
	}
}
