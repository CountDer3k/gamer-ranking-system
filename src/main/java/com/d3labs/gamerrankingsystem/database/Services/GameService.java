package com.d3labs.gamerrankingsystem.database.Services;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.d3labs.gamerrankingsystem.database.Dtos.GameDto;
import com.d3labs.gamerrankingsystem.database.Models.GameModel;
import com.d3labs.gamerrankingsystem.database.Repostiories.GameRepository;
import com.d3labs.gamerrankingsystem.globals.EnumStore.GameCategory;

/**
 * A class for handling calls to the database through the access layer of a
 * repository. Interface with the rest of the program.
 */
@Service
public class GameService {
    private GameRepository gameRepository;
    private Logger logger = LoggerFactory.getLogger(GameService.class);

    private static GameService INSTANCE;

    /**
     * Constructor for game service
     */
    public GameService() {

    }

    /**
     * Constructor for game service using the game repository.
     * 
     * @param gameRepo A game repostiory passed in.
     */
    @Autowired
    public GameService(GameRepository gameRepo) {
        this.gameRepository = gameRepo;
    }

    /**
     * Gets a list of all the games in the database by calling the games repository.
     * 
     * @return A list of GameModels
     */
    public List<GameModel> getAllGames() {
        List<GameModel> games = gameRepository.getAllGames();
        return games;
    }

    /**
     * Gets a PlayerModel object based on the gamertag through the player
     * repository.
     * 
     * @param gamerTag A string of the player's gamertag.
     * @return A PlayerModel object.
     */
    public List<GameModel> getGameByCategory(GameCategory category) {
        return gameRepository.getGameByCategory(category);
    }

    /**
     * Inserts a new Game into the database through the game repostiory.
     * 
     * @param player The GameModel objecdt to add to the database.
     * @return A GameDto object.
     */
    public GameModel addGame(GameDto gameDto) {
        // Add player to database through repository.
        return gameRepository.AddGame(gameDto);
    }
}
