package com.d3labs.gamerrankingsystem.database.RowMappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.d3labs.gamerrankingsystem.database.Models.PlayerModel;

/**
 * PlayerRowMapper is used for mapping rows of a ResultSet from an SQL database to a PlyaerModel object.
 * This will map the current row defined by rowNum from the ResultSet to a PlayerModel object. 
 * This will extract the data from the columns of the current row and set the extracted values into the field of the PlayerModel object.
 */
@SuppressWarnings("rawtypes")
public class PlayerRowMapper implements RowMapper{

    /**
     * Maps a row from Result set to the PlayerModel object class.
     * 
     * @param rs A Result Set containing relevant databsase information.
     * @param rowNum The interget of a row number.
     * @return A PlayerModel class filled with information provided.
     * @throws SQLException
     */
    @Override
	public PlayerModel mapRow(ResultSet rs, int rowNum) throws SQLException {
		PlayerModel player = new PlayerModel();

        player.setGamerTag(rs.getString("gamer_tag"));
        player.setFirstName(rs.getString("first_name"));
        player.setLastName(rs.getString("last_name"));
        player.setId(rs.getInt("player_id"));
		return player;
	}
}
