package com.d3labs.gamerrankingsystem.Controllers;

import java.io.IOException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.d3labs.gamerrankingsystem.database.Dtos.GameDto;
import com.d3labs.gamerrankingsystem.database.Models.GameModel;
import com.d3labs.gamerrankingsystem.database.Services.GameCategoryService;
import com.d3labs.gamerrankingsystem.database.Services.GameService;
import jakarta.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * * A class for handling front-end to the back-end call and the repostiory.
 * Interface with the rest of the program.
 */
@Controller
public class GameController {
    GameService gameService;
    GameCategoryService gameCategoryService;
    private Logger logger = LoggerFactory.getLogger(GameController.class);

    /**
     * Constructor for gamecontroller with a game service instance.
     * 
     * @param gameService An instance of a GameService
     */
    @Autowired
    public GameController(GameService gameService, GameCategoryService gameCategoryService) {
        this.gameService = gameService;
        this.gameCategoryService = gameCategoryService;
    }

    /**
     * Gets a ModelAndView for the addPlayerForm html page with a playerDto.
     * This view is used to add new game to the database.
     * 
     * @param request A WebRequest.
     * @return A ModelAndView
     */
    @GetMapping("games/addGameForm")
    public ModelAndView getAddNewGameForm(WebRequest request) {
        GameDto gameDto = new GameDto();

        List<String> categories = gameCategoryService.getAllCategories();

        ModelAndView modelAndView = new ModelAndView("games/addGameForm");
        modelAndView.getModelMap().addAttribute("game", gameDto);
        modelAndView.getModelMap().addAttribute("gameCategories", categories);
        return modelAndView;
    }

    /**
     * Gets a ModelAndView for the gameList html page.
     * This is used to show the list of games
     * 
     * @param request A WebRequest.
     * @return A ModelAndView
     */
    @GetMapping("games/gamesList")
    public ModelAndView getGamesListView(WebRequest request) {
        ModelAndView modelAndView = new ModelAndView("games/gamesList");
        List<GameModel> games = gameService.getAllGames();
        modelAndView.getModelMap().addAttribute("gamesList", games);
        return modelAndView;
    }

    /**
     * Handles POST requests to the "/games/addGame" endpoint.
     * Adds a new game to the system.
     * 
     * @param playerDto  The data transfer object containing game data. This object
     *                   is validated before processing.
     * @param bindResult The result of the binding and validation process.
     * @param request    The HttpServletRequest object.
     * @param errors     Any errors that occurred during the binding process.
     * @return ModelAndView object that redirects to the home page if the game is
     *         successfully added,
     *         or returns the error view if there are binding errors.
     * 
     * @throws Exception If an error occurs during player addition.
     */
    @PostMapping("/games/addGame")
    public ModelAndView addNewGame(@Validated GameDto gameDto,
            BindingResult bindResult,
            HttpServletRequest request,
            Errors errors) {

        if (bindResult.hasErrors()) {
            return new ModelAndView("error");
        }

        ModelAndView modelandView = new ModelAndView("redirect:/");
        GameModel game = gameService.addGame(gameDto);

        return modelandView;
    }
}
