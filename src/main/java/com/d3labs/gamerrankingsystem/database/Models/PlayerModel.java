package com.d3labs.gamerrankingsystem.database.Models;

import com.d3labs.gamerrankingsystem.database.Dtos.PlayerDto;

/*
 * A model class for the player object.
 * Used to transfer data around on the application level.
 */
public class PlayerModel {
    
    private int PlayerId;
    private String GamerTag;
    private String FirstName;
    private String LastName;

    /*
     * Instantiates a PlayerModel object.
    */
    public PlayerModel(){

    }

    /**
     * Instantiates a PlayerModel object that if populated by the player dto.
     * @param player
     */
    public PlayerModel(PlayerDto player){
        this.GamerTag = player.getGamerTag();
        this.FirstName = player.getFirstName();
        this.LastName = player.getLastName();
    }

    /**
     * Gets the player id.
     * @return An int of the player's id.
     */
    public int getPlayerId(){
        return this.PlayerId;
    }

    /**
     * Gets the player's gamer tag.
     * @return A string of the player's gamer tag.
     */
    public String getGamerTag(){
        return this.GamerTag;
    }

    /**
     * Gets the player's first name.
     * @return A string of the player's first name.
     */
    public String getFirstName(){
        return this.FirstName;
    }

    /**
     * Gets the player's last name.
     * @return A string of the player's last name.
     */
    public String getLastName(){
        return this.LastName;
    }

    /**
     * Sets the player's id.
     * @param id The id of the player.
     */
    public void setId(int id){
        this.PlayerId = id;
    }

    /**
     * Sets the player's gamer tag.
     * @param gamerTag The gamerTag of the player.
     */
    public void setGamerTag(String gamerTag){
        this.GamerTag = gamerTag;
    }

    /**
     * Sets the player's first name.
     * @param firstName The first name of the player.
     */
    public void setFirstName(String firstName){
        this.FirstName = firstName;
    }

    /**
     * Sets the player's last name.
     * @param lastName The last name of the player.
     */
    public void setLastName(String lastName){
        this.LastName = lastName;
    }
}
