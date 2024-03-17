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

import com.d3labs.gamerrankingsystem.database.Dtos.GameDto;
import com.d3labs.gamerrankingsystem.database.Models.GameModel;
import com.d3labs.gamerrankingsystem.database.Models.PlayerModel;
import com.d3labs.gamerrankingsystem.database.RowMappers.GameRowMapper;

/**
 * A Repository class for interacting with the database for the games table using the the GameModel object class.
 */
@Repository
public class GameRepository {
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    private Logger logger = LoggerFactory.getLogger(GameRepository.class);

    // SQL Queries
    private static String SELECT_ALL_GAMES = "";
    private static String SELECT_GAME_BY_CATEGORY = "";
    private static String INSERT_GAME = "";

    /**
     * A constructor to instatiate the Game Repository.
     * It takes in a NamedParameterJdbcTemplate that will interact with the database (like context).
     * 
     * @param namedParameterJdbcTemplate The Java Database Connectivity.
     */
    @Autowired
    public GameRepository(NamedParameterJdbcTemplate namedParameterJdbcTemplate){
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    /**
     * Gets a list of all of games stored in the database.
     * @return A list of GameModel objects.
     */
    public List<GameModel> getAllGames(){
        List<GameModel> games = namedParameterJdbcTemplate.query(SELECT_ALL_GAMES, new GameRowMapper());
        return games;
    }

    /**
     * Inserts a games into the database.
     * @param game A GameDto object (hold the most "raw" information to easily convert to the database).
     * @return The GameModel object passed in.
     */
    @SuppressWarnings("null")
    public GameModel AddPlayer(GameDto game){
        try {
			KeyHolder keyHolder = new GeneratedKeyHolder();
			SqlParameterSource parameters = new MapSqlParameterSource()
                .addValue("gameName", game.getGameName())
                .addValue("gameCategory", game.getGameCategory());

			namedParameterJdbcTemplate.update(INSERT_GAME, parameters, keyHolder);

            return new GameModel(game);
		} catch(Exception e) 
		{
			logger.error("PlayerRepository - AddPlayer() " + e.getLocalizedMessage());
		}
		return null;
    } 
}
