package com.d3labs.gamerrankingsystem.database.RowMappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.RowMapper;

import com.d3labs.gamerrankingsystem.database.Models.GameModel;

/**
 * GameRowMapper is used for mapping rows of a ResultSet from an SQL database to
 * a GameModel object.
 * This will map the current row defined by rowNum from the ResultSet to a
 * GameModel object.
 * This will extract the data from the columns of the current row and set the
 * extracted values into the field of the GameModel object.
 */
@SuppressWarnings("rawtypes")
public class GameRowMapper implements RowMapper {

    private Logger logger = LoggerFactory.getLogger(GameRowMapper.class);

    @Override
    public Object mapRow(ResultSet rs, int rowNum) throws SQLException {

        GameModel game = new GameModel();
        try {
            game.setGameId(rs.getInt("game_id"));
            game.setGameName(rs.getString("game_name"));
            game.setGameCategory(rs.getString("game_category"));
            game.setBaseImage(rs.getBytes("game_image"));
        } catch (Exception e) {
            logger.error("Error Mapping Game row from database", e);
        }

        return game;
    }

}
