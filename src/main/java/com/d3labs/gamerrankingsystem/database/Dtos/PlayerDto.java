package com.d3labs.gamerrankingsystem.database.Dtos;

import io.micrometer.common.lang.NonNull;

public class PlayerDto {

    @NonNull
    private String gamerTag;

    @NonNull
    private String firstName;

    @NonNull
    private String lastName;


    /**
     * Gets the gamer tag.
     * @return A string of the gamer tag.
     */
    public String getGamerTag(){
        return gamerTag;
    }

    /**
     * Gets the first name.
     * @return A string of the first name.
     */
    public String getFirstName(){
        return firstName;
    }

    /**
     * Gets the last name.
     * @return A string of the last name.
     */
    public String getLastName(){
        return lastName;
    }

    /**
     * Sets the gamertag
     * @param gamerTag A string of the player's gamer tag.
     */
    public void setGamerTag(String gamerTag){
        this.gamerTag = gamerTag;
    }

    /**
     * Sets the first name.
     * @param firstName A string of the player's first name.
     */
    public void setFirstName(String firstName){
        this.firstName = firstName;
    }

    /**
     * Sets the last name.
     * @param lastName A string of the player's last name.
     */
    public void setLastName(String lastName){
        this.lastName = lastName;
    }
}
