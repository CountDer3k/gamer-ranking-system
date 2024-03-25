package com.d3labs.gamerrankingsystem.Controllers;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
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
import com.d3labs.gamerrankingsystem.database.Services.PlayerService;

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
public class TestingController {
    GameService gameService;
    PlayerService playerService;
    GameCategoryService gameCategoryService;
    private Logger logger = LoggerFactory.getLogger(TestingController.class);

    /**
     * Constructor for gamecontroller with a game service instance.
     * 
     * @param gameService An instance of a GameService
     */
    @Autowired
    public TestingController(GameService gameService, PlayerService playerService,
            GameCategoryService gameCategoryService) {
        this.gameService = gameService;
        this.playerService = playerService;
        this.gameCategoryService = gameCategoryService;
    }

    /**
     * Handles a GET event for testing
     */
    @GetMapping("testing/get")
    public ModelAndView testingGet(WebRequest request) {

        ModelAndView modelAndView = new ModelAndView("testing/test");
        return modelAndView;
    }

    /**
     * Handles a POST event for testing
     */
    @PostMapping("/testing/post")
    public ModelAndView testingPost(@Validated GameDto gameDto,
            BindingResult bindResult,
            HttpServletRequest request,
            Errors errors) {

        if (bindResult.hasErrors()) {
            return new ModelAndView("error");
        }

        ModelAndView modelandView = new ModelAndView("redirect:/testing/test");

        return modelandView;
    }

    @PostMapping("/upload")
    public String uploadImage(GameDto model, @RequestParam("image") MultipartFile file) throws IOException {

        byte[] args = file.getBytes();

        return "imageupload/index";
    }
}
