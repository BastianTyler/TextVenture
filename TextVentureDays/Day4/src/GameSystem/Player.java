package GameSystem;

import java.util.ArrayList;

/**
 * Represents the player character in the game.
 * Extends Combatant with player-specific attributes and functionality.
 */
public class Player extends Combatant {

    private StoryState storyState = StoryState.INTRO_ONE;
    private int x;
    private int y;
    /**
     * Creates a new Player with the specified basic attributes.
     * Initializes the player with default stats, starting skills, and inventory items.
     *
     * @param name The name of the player character.
     * @param gender The gender of the player character.
     * @param age The age of the player character in years.
     */
    public Player(String name, char gender, int age){
        super(name,gender,age,100,100, 10, 0);
    }

    /**
     * Gets the player's current X position on the map.
     *
     * @return Integer X coordinate.
     */
    public int getX() {
        return x;
    }

    /**
     * Sets the player's X position on the map.
     *
     * @param x New X coordinate.
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * Gets the player's current Y position on the map.
     *
     * @return Integer Y coordinate.
     */
    public int getY() {
        return y;
    }

    /**
     * Sets the player's Y position on the map.
     *
     * @param y New Y coordinate.
     */
    public void setY(int y) {
        this.y = y;
    }

    /**
     * Gets the player's current story progression state.
     *
     * @return StoryState enum value representing current narrative progress.
     */
    public StoryState getStoryState() {
        return storyState;
    }

    /**
     * Updates the player's story progression state.
     * Used when advancing the narrative.
     *
     * @param storyState New StoryState enum value.
     */
    public void setStoryState(StoryState storyState) {
        this.storyState = storyState;
    }

}

