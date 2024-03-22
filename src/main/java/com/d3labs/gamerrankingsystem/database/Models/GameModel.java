package com.d3labs.gamerrankingsystem.database.Models;

import com.d3labs.gamerrankingsystem.database.Dtos.GameDto;
import com.d3labs.gamerrankingsystem.globals.EnumStore;
import com.d3labs.gamerrankingsystem.globals.EnumStore.GameCategory;

/**
 * A model class for the game object.
 * Used to transfer data around on the application level.
 */
public class GameModel {
    
    private int GameId;
    private String Name;
    private GameCategory Category;
    private byte[] gameImage;

    /**
     * Instantiates a GameModel object.
     */
    public GameModel(){

    }

    /**
     * Instatiates a GameModel object that is populated by the game dto.
     * @param game
     */
    public GameModel(GameDto game){
        this.Name = game.getGameName();
        this.Category = EnumStore.GetEnumFromString(game.getGameCategory());
    }
    
    /**
     * Gets the game's id.
     * @return
     */
    public int getGameId(){
        return this.GameId;
    }

    /**
     * Gets the game name.
     * @return A string of the game name.
     */
    public String getGameName(){
        return this.Name;
    }

    /**
     * Gets the game category
     * @return A string fo the game category.
     */
    public GameCategory getGameCategory(){
        return this.Category;
    }

    /**
     * Gets the game Image as a byte array.
     * @return
     */
    public byte[] getGameImage(){
        return this.gameImage;
    }

    /**
     * Sets the game id
     * @param newGameId An int of the new game id.
     */
    public void setGameId(int newGameId){
        this.GameId = newGameId;
    }

    /**
     * Sets the game name
     * @param name A string of the game's name.
     */
    public void setGameName(String name){
        this.Name = name;
    }

    /**
     * Sets the game category.
     * @param category A string fo the game's category.
     */
    public void setGameCategory(GameCategory category){
        this.Category = category;
    }

    /**
     * Sets the game Image.
     * @param gameImage A byte array that should have an image file.
     */
    public void setGameImage(byte[] gameImage){
        this.gameImage = gameImage;
    }
}
