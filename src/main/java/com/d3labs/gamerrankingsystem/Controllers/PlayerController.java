package com.d3labs.gamerrankingsystem.Controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import com.d3labs.gamerrankingsystem.database.Dtos.PlayerDto;
import com.d3labs.gamerrankingsystem.database.Models.PlayerModel;
import com.d3labs.gamerrankingsystem.database.Services.PlayerService;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.context.request.WebRequest;


@Controller
public class PlayerController {
    PlayerService playerService;
    private Logger logger = LoggerFactory.getLogger(PlayerController.class);

	@Autowired
	public PlayerController(PlayerService playerService) {
		this.playerService = playerService;
	}

    @GetMapping("players/addPlayerForm")
    public ModelAndView getAddNewPlayerForm(WebRequest request) {
        PlayerDto playerDto = new PlayerDto();
		ModelAndView modelAndView = new ModelAndView("players/addPlayerForm");
		modelAndView.getModelMap().addAttribute("player", playerDto);
		return modelAndView;
    }
    

    @PostMapping("/players/addPlayer")
    public ModelAndView addNewPlayer(@Validated PlayerDto playerDto,
    BindingResult bindResult,
    HttpServletRequest request,
    Errors errors){
        if(bindResult.hasErrors()){
            return new ModelAndView("error");
        }

        ModelAndView modelandView = new ModelAndView("redirect:/");
        PlayerModel player = playerService.addPlayer(playerDto);

        return modelandView;
    }
}
