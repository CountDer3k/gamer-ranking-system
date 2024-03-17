package com.d3labs.gamerrankingsystem.database.Services;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.d3labs.gamerrankingsystem.database.Dtos.PlayerDto;
import com.d3labs.gamerrankingsystem.database.Models.PlayerModel;
import com.d3labs.gamerrankingsystem.database.Repostiories.PlayerRepository;

/**
 * A class for handling calls to the database through the access layer of a repository. Interface with the rest of the program.
 */
@Service
public class PlayerService {
     private PlayerRepository playerRepository;
    private Logger logger = LoggerFactory.getLogger(PlayerRepository.class);

    // Instance of the player service
    private static PlayerService INSTANCE;
    
    public PlayerService() {
    	
    } 
    
    @Autowired
    public PlayerService(PlayerRepository playerRepo) {
    	this.playerRepository = playerRepo;
    }

    /**
     * Gets a list of all the player in the database by calling the player repository.
     * @return A list of PlayerModels
     */
     public List<PlayerModel> getAllPlayers(){
    	List<PlayerModel> players = playerRepository.getAllPlayers();
    	return players;
    }

    /**
     * Gets a PlayerModel object based on the gamertag through the player repository.
     * @param gamerTag A string of the player's gamertag.
     * @return A PlayerModel object.
     */
    public PlayerModel getPlayerModelByGamerTag(String gamerTag){
        return playerRepository.getPlayerByGamerTag(gamerTag);
    }

    /**
     * Inserts a new Player into the database through the player repostiory.
     * @param player The PlayerModel objecdt to add to the database.
     * @return A PlayerModel object.
     */
    public PlayerModel addPlayer(PlayerDto playerDto){
        // Add player to database through repository.
        return playerRepository.AddPlayer(playerDto);
    }

}
