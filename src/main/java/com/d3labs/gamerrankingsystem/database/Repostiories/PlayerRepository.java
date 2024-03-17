package com.d3labs.gamerrankingsystem.database.Repostiories;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.d3labs.gamerrankingsystem.database.Dtos.PlayerDto;
import com.d3labs.gamerrankingsystem.database.Models.PlayerModel;
import com.d3labs.gamerrankingsystem.database.RowMappers.PlayerRowMapper;

/**
 * A Repository class for interacting with the database for the players table using the the PlayerModel object class.
 */
@Repository
public class PlayerRepository {
    
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	private Logger logger = LoggerFactory.getLogger(PlayerRepository.class);

    // SQL Queries
    private static String SELECT_ALL_PLAYERS = "SELECT * FROM players ";
    private static String SELECT_PLAYER_BY_TAG = "SELECT * players p WHERE p.game_tag = :plaerID ";
    private static String INSERT_PLAYER = "INSERT INTO players(gamer_tag, first_name, last_name) VALUES(:gamer_tag, :first_name, :last_name) ";

// "INSERT INTO Post(user_id, create_on) VALUES(:userID, :create) ";

    /*
     * A constructor to instantiate the Player Repository. 
     * It takes in a NamedParameterJdbcTemplate that will interact with the database (like context).
     * 
     * @param namedParameterJdbcTemplate The Java Database Connectivity.
     */
    @Autowired
	public PlayerRepository(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
		this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
	}

    /**
     * Gets a list of all of players stored in the database.
     * @return A list of PlayerModel objects.
     */
    @SuppressWarnings({ "null", "unchecked" })
    public List<PlayerModel> getAllPlayers(){
        List<PlayerModel> players = namedParameterJdbcTemplate.query(SELECT_ALL_PLAYERS, new PlayerRowMapper()); 
        return players;
    }

    /**
     * Gets a PlayerModel object from their gamerTag if one exists.
     * @param gamerTag A string of a player's gamerTag.
     * @return A PlayerModel objecdt.
     */
    @SuppressWarnings({ "null", "unchecked" })
    public PlayerModel getPlayerByGamerTag(String gamerTag){
        try {
            // Prepare Sql query
			SqlParameterSource parameters = new MapSqlParameterSource()
					.addValue("gamer_tag", gamerTag);

            // Execute query and return result as a PlayerModel object.
			return (PlayerModel)namedParameterJdbcTemplate.queryForObject(SELECT_PLAYER_BY_TAG, parameters, new PlayerRowMapper());
		} catch(Exception e) {
			logger.error("Error occured: " + e.toString());
			return null;
		}
    }

    /**
     * Inserts a player into the database.
     * @param game A PlayerDto object (hold the most "raw" information to easily convert to the database).
     * @return The PlayerModel object passed in.
     */
    @SuppressWarnings("null")
    public PlayerModel AddPlayer(PlayerDto player){
        try {
			KeyHolder keyHolder = new GeneratedKeyHolder();
			SqlParameterSource parameters = new MapSqlParameterSource()
                .addValue("gamer_tag", player.getGamerTag())
                .addValue("first_name", player.getFirstName())
                .addValue("last_name", player.getLastName());

			namedParameterJdbcTemplate.update(INSERT_PLAYER, parameters, keyHolder);

            // Convert Dto to Model object
            return new PlayerModel(player);
		} catch(Exception e) 
		{
			logger.error("PlayerRepository - AddPlayer() " + e.getLocalizedMessage());
		}
		return null;
    } 
}
