package com.d3labs.gamerrankingsystem.database.Models;

import com.d3labs.gamerrankingsystem.database.Dtos.GameDto;
import com.d3labs.gamerrankingsystem.database.Models._Base.ImageContainingModelBase;

/**
 * A model class for the game object.
 * Used to transfer data around on the application level.
 */
public class GameModel extends ImageContainingModelBase {

    private int GameId;
    private String Name;
    private String Category;

    /**
     * Instantiates a GameModel object.
     */
    public GameModel() {

    }

    /**
     * Instatiates a GameModel object that is populated by the game dto.
     * 
     * @param game
     */
    public GameModel(GameDto game) {
        this.Name = game.getGameName();
        this.Category = "---";// EnumStore.GetEnumFromString(game.getGameCategory());
    }

    /**
     * Gets the game's id.
     * 
     * @return
     */
    public int getGameId() {
        return this.GameId;
    }

    /**
     * Gets the game name.
     * 
     * @return A string of the game name.
     */
    public String getGameName() {
        return this.Name;
    }

    /**
     * Gets the game category
     * 
     * @return A string fo the game category.
     */
    public String getGameCategory() {
        return this.Category;
    }

    /**
     * Sets the game id
     * 
     * @param newGameId An int of the new game id.
     */
    public void setGameId(int newGameId) {
        this.GameId = newGameId;
    }

    /**
     * Sets the game name
     * 
     * @param name A string of the game's name.
     */
    public void setGameName(String name) {
        this.Name = name;
    }

    /**
     * Sets the game category.
     * 
     * @param category A string fo the game's category.
     */
    public void setGameCategory(String category) {
        this.Category = category;
    }
}
