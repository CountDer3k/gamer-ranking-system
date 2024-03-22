package com.d3labs.gamerrankingsystem.database.RowMappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.d3labs.gamerrankingsystem.database.Models.GameModel;
import com.d3labs.gamerrankingsystem.globals.EnumStore;

/**
 * GAmeRowMapper is used for mapping rows of a ResultSet from an SQL database to a GameModel object.
 * This will map the current row defined by rowNum from the ResultSet to a GameModel object. 
 * This will extract the data from the columns of the current row and set the extracted values into the field of the GameModel object.
 */
@SuppressWarnings("rawtypes")
public class GameRowMapper implements RowMapper{

    @Override
    public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
        GameModel game = new GameModel();

        game.setGameId(rs.getInt("game_id"));
        game.setGameName(rs.getString("gameName"));
        // Set category based on the enum
        String gameCategory =rs.getString("gameCategory");
        game.setGameCategory(EnumStore.GetEnumFromString(gameCategory));
        game.setGameImage(rs.getBytes("game_image"));
        
        return game;
    }
    
    
}
