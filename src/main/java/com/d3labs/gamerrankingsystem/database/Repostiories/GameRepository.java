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
import com.d3labs.gamerrankingsystem.database.RowMappers.GameRowMapper;
import com.d3labs.gamerrankingsystem.globals.EnumStore.GameCategory;

/**
 * A Repository class for interacting with the database for the games table
 * using the the GameModel object class.
 */
@Repository
public class GameRepository {
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    private Logger logger = LoggerFactory.getLogger(GameRepository.class);

    // SQL Queries
    private static String SELECT_ALL_GAMES = "SELECT * FROM games ";
    private static String SELECT_ALL_BY_CATEGORY = "SELECT * from games p WHERE p.category = :gCategory ";
    private static String INSERT_GAME = "INSERT INTO games(game_name, game_category, game_image) VALUES(:gName, :gCategory, :gImage) ";
    // "SELECT * players p WHERE p.game_tag = :playerID ";
    // "INSERT INTO players(gamer_tag, first_name, last_name) VALUES(:gamer_tag,
    // :first_name, :last_name) ";

    /**
     * A constructor to instatiate the Game Repository.
     * It takes in a NamedParameterJdbcTemplate that will interact with the database
     * (like context).
     * 
     * @param namedParameterJdbcTemplate The Java Database Connectivity.
     */
    @Autowired
    public GameRepository(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    /**
     * Gets a list of all games stored in the database.
     * 
     * @return A list of GameModel objects.
     */
    @SuppressWarnings("unchecked")
    public List<GameModel> getAllGames() {
        List<GameModel> games = namedParameterJdbcTemplate.query(SELECT_ALL_GAMES, new GameRowMapper());
        return games;
    }

    /**
     * Gets a list of all games stored in the database that fit into the category.
     * 
     * @param category The category to query by.
     * @return A list of game models
     */
    public List<GameModel> getGameByCategory(GameCategory category) {
        List<GameModel> games = namedParameterJdbcTemplate.query(SELECT_ALL_BY_CATEGORY, new GameRowMapper());
        return games;
    }

    /**
     * Inserts a games into the database.
     * 
     * @param game A GameDto object (hold the most "raw" information to easily
     *             convert to the database).
     * @return The GameModel object passed in.
     */
    @SuppressWarnings("null")
    public GameModel AddGame(GameDto game) {
        try {
            KeyHolder keyHolder = new GeneratedKeyHolder();
            SqlParameterSource parameters = new MapSqlParameterSource()
                    .addValue("gName", game.getGameName())
                    .addValue("gCategory", game.getGameCategory())
                    .addValue("gImage", game.getGameImage());

            namedParameterJdbcTemplate.update(INSERT_GAME, parameters, keyHolder);

            return new GameModel(game);
        } catch (Exception e) {
            String error = e.getLocalizedMessage();
            logger.error("GameRepository - AddGame() " + error);
        }
        return null;
    }
}
