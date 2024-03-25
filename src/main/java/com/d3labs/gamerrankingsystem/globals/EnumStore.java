package com.d3labs.gamerrankingsystem.globals;

/**
 * A class that holds all the enums for the project.
 * All enums are being stored here since the application is small and doesn't
 * need further organization.
 */
public class EnumStore {

    /**
     * A enum for the category of games
     */
    public enum GameCategory {
        ARCADE,
        FPS,
        PLATFORMER,
        FIGHTING,
        RACING,
        SPORT,
        SURVIVAL,
        STEALTH,
        MINIGAME,
        STRATEGY,
        NONE,
        ERROR,
    }

    /**
     * Converts an enum of GameCategory type into its string equivalent.
     * Needed for storing this in the database.
     * 
     * @param input A GameCategory to convert.
     * @return A string equivalent of the GameCategory passed in.
     */
    public static String GetStringFromEnum(GameCategory input) {
        return input.toString();
    }

    /**
     * Converts a string into its GameCategory equivalent.
     * Needed for setting the model object from the dto.
     * 
     * @param input A string input to convert
     * @return A GameCategory equivalent of the passed in string.
     */
    public static GameCategory GetEnumFromString(String input) {
        GameCategory output = GameCategory.NONE;

        try {
            output = GameCategory.valueOf(input.toUpperCase());
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid GameCategory conversion: " + input);
            output = GameCategory.ERROR;
        }

        return output;
    }
}
