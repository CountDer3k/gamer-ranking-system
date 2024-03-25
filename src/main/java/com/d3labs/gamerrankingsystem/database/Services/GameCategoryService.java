package com.d3labs.gamerrankingsystem.database.Services;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.d3labs.gamerrankingsystem.database.Repostiories.GameCategoryRepository;

/**
 * A class for handling calls to the database through the access layer of a
 * repository. Interface with the rest of the program.
 */
@Service
public class GameCategoryService {
    private GameCategoryRepository gameCategoryRepository;
    private Logger logger = LoggerFactory.getLogger(GameCategoryService.class);

    private static GameCategoryService INSTANCE;

    /**
     * Constructor for game category service
     */
    public GameCategoryService() {

    }

    /**
     * Constructor for game service using the game category repository.
     * 
     * @param gameRepo A game category repostiory passed in.
     */
    @Autowired
    public GameCategoryService(GameCategoryRepository gameRepo) {
        this.gameCategoryRepository = gameRepo;
    }

    /**
     * Gets a list of all the games in the database by calling the games repository.
     * 
     * @return A list of GameModels
     */
    public List<String> getAllCategories() {
        List<String> categories = gameCategoryRepository.getAllCategories();
        return categories;
    }

}
