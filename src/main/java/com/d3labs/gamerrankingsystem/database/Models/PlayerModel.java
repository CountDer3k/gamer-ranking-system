package com.d3labs.gamerrankingsystem.database.Models;

import java.util.Base64;

import org.springframework.util.Base64Utils;

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
    private byte[] PlayerImage;

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
     * Gets the player's image
     * @return A byte array containing raw image data.
     */
    public byte[] getPlayerImage(){
        return this.PlayerImage;
    }

    /**
     * Converts the byte array of the image (the BLOB) into a base64 encoded string
     * @return A base64 encoded string representation of the image.
     */
    public String getImageAsBase64(){
        if(this.PlayerImage != null){

            String imageString = Base64.getEncoder().encodeToString(this.PlayerImage);

            return imageString;
        }
        return null;
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

    /**
     * Sets the player's image.
     * @param image A byte array containing raw image data
     */
    public void setPlayerImage(byte[] image){
        this.PlayerImage = image;
    }
}
