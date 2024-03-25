package com.d3labs.gamerrankingsystem.database.Repostiories;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.d3labs.gamerrankingsystem.database.Dtos.GameCategoryDto;
import com.d3labs.gamerrankingsystem.database.RowMappers.GameCategoryRowMapper;

/**
 * A Repository class for interacting with the database for the game categories.
 */
@Repository
public class GameCategoryRepository {
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	private Logger logger = LoggerFactory.getLogger(GameCategoryRepository.class);

	private static String SELECT_ALL_CATEGORIES = "SELECT * FROM gameCategory ";

	/**
	 * A constructor to instatiate the Game Category Repository.
	 * It takes in a NamedParameterJdbcTemplate that will interact with the database
	 * (like context).
	 * 
	 * @param namedParameterJdbcTemplate The Java Database Connectivity.
	 */
	@Autowired
	public GameCategoryRepository(NamedParameterJdbcTemplate nPJT) {
		this.namedParameterJdbcTemplate = nPJT;
	}

	/**
	 * Get a list of the strings of every game category in the database.
	 * 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<String> getAllCategories() {
		List<String> categories = new ArrayList<String>();
		try {
			List<GameCategoryDto> gameCategories = namedParameterJdbcTemplate.query(SELECT_ALL_CATEGORIES,
					new GameCategoryRowMapper());

			for (GameCategoryDto gcd : gameCategories) {
				categories.add(gcd.getName());
			}
		} catch (Exception e) {
			logger.error("Failed to get all categories from database", e);
		}

		return categories;
	}
}
