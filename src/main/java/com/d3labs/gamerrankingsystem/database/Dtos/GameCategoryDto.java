package com.d3labs.gamerrankingsystem.database.Dtos;

import io.micrometer.common.lang.NonNull;

/**
 * A class of the Game Category database object.
 * No applicadtion model exists for this since its a database only object and
 * will only use the name as a list by the application
 */
public class GameCategoryDto {
	@NonNull
	private int id;

	@NonNull
	private String name;

	/**
	 * Gets the id of the category
	 * 
	 * @return An int
	 */
	public int getId() {
		return this.id;
	}

	/**
	 * Gets the name of the category.
	 * 
	 * @return A string representation of a category
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * Sets the id of the category
	 * 
	 * @param id new Id
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Sets the name of the category.
	 * 
	 * @param name String varaible holding new name.
	 */
	public void setName(String name) {
		this.name = name;
	}
}
