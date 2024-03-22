package com.d3labs.gamerrankingsystem.database.Dtos;

import io.micrometer.common.lang.NonNull;

/**
 * A class of the Game's dto object.
 * This is a transfer data object used to transfer data from the database to the application and vice-versa.
 */
public class GameDto {
    
    @NonNull
    private String gameName;

    @NonNull
    private String gameCategory;

    private byte[] gameImage;

    /**
     * Gets the GameName.
     * @return A string of the game name.
     */
    public String getGameName(){
        return this.gameName;
    }

    /**
     * Gets the game category
     * @return A string fo the game category.
     */
    public String getGameCategory(){
        return this.gameCategory;
    }

    /**
     * Gets the game image.
     * @return A byte array containing the raw image data.
     */
    public byte[] getGameImage(){
        return this.gameImage;
    }

    /**
     * Sets the game name
     * @param name A string of the game's name.
     */
    public void setGameName(String name){
        this.gameName = name;
    }

    /**
     * Sets the game category.
     * @param category A string fo the game's category.
     */
    public void setGameCategory(String category){
        this.gameCategory = category;
    }

    /**
     * Set the game image.
     * @param gameImage A byte array containing raw image data.
     */
    public void setGameImage(byte[] gameImage){
        this.gameImage = gameImage;
    }
}
