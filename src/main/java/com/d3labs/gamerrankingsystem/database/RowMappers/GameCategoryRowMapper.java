package com.d3labs.gamerrankingsystem.database.RowMappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.RowMapper;

import com.d3labs.gamerrankingsystem.database.Dtos.GameCategoryDto;

/**
 * GameCategoryRowMapper is used for mapping rows of a ResultSet from an SQL
 * database to a List of Strings.
 * This will map the current row defined by rowNum from the ResultSet to a List
 * of Strings.
 */
@SuppressWarnings("rawtypes")
public class GameCategoryRowMapper implements RowMapper {

    private Logger logger = LoggerFactory.getLogger(GameCategoryRowMapper.class);

    @Override
    public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
        GameCategoryDto gameCategory = new GameCategoryDto();

        try {
            gameCategory.setId(rs.getInt("game_category_id"));
            gameCategory.setName(rs.getString("category_name"));
        } catch (Exception e) {
            logger.error("Error mapping GameCategory row from database", e);
        }

        return gameCategory;
    }

}
