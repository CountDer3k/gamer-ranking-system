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

    /**
     * Constructor for playercontroller with a player service instance.
     * 
     * @param playerService
     */
    @Autowired
    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    /**
     * Gets a ModelAndView for the addPlayerForm html page with a playerDto.
     * This view is used to add new players to the database.
     * 
     * @param request A WebRequest.
     * @return A ModelAndView
     */
    @GetMapping("players/addPlayerForm")
    public ModelAndView getAddNewPlayerForm(WebRequest request) {
        PlayerDto playerDto = new PlayerDto();
        ModelAndView modelAndView = new ModelAndView("players/addPlayerForm");
        modelAndView.getModelMap().addAttribute("player", playerDto);
        return modelAndView;
    }

    /**
     * Handles POST requests to the "/players/addPlayer" endpoint.
     * Adds a new player to the system.
     * 
     * @param playerDto  The data transfer object containing player data. This
     *                   object is validated before processing.
     * @param bindResult The result of the binding and validation process.
     * @param request    The HttpServletRequest object.
     * @param errors     Any errors that occurred during the binding process.
     * @return ModelAndView object that redirects to the home page if the player is
     *         successfully added,
     *         or returns the error view if there are binding errors.
     * 
     * @throws Exception If an error occurs during player addition.
     */
    @PostMapping("/players/addPlayer")
    public ModelAndView addNewPlayer(@Validated PlayerDto playerDto,
            BindingResult bindResult,
            HttpServletRequest request,
            Errors errors) {
        if (bindResult.hasErrors()) {
            return new ModelAndView("error");
        }

        ModelAndView modelandView = new ModelAndView("redirect:/");
        PlayerModel player = playerService.addPlayer(playerDto);

        return modelandView;
    }
}
