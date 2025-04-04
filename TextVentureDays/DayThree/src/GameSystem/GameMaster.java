package GameSystem;

public class GameMaster {

    //Singleton acting to control game state
    private static GameMaster gmInstance;
    private GameState state = GameState.START_MENU;
    private Player player;
    private GameMap activeMap;

    /**
     * Gets the singleton instance of GameMaster, creating it if it doesn't exist.
     * Ensures only one GameMaster instance exists throughout the application.
     *
     * @return The singleton GameMaster instance.
     */
    public static GameMaster getInstance(){
        if(gmInstance == null){
            gmInstance = new GameMaster();
        }
        return gmInstance;
    }

    /**
     * Gets the current game state.
     *
     * @return The current GameState enum value.
     */
    public GameState getState() {
        return state;
    }

    /**
     * Sets the current game state.
     *
     * @param state The new GameState to transition to.
     */
    public void setState(GameState state) {
        this.state = state;
    }

    /**
     * Gets the current player object.
     *
     * @return The Player instance currently active in the game.
     */
    public Player getPlayer() {
        return player;
    }

    /**
     * Sets the current player object.
     *
     * @param player The Player instance to set as the active player.
     */
    public void setPlayer(Player player) {
        this.player = player;
    }

    /**
     * Gets the currently active game map.
     *
     * @return The active GameMap instance.
     */
    public GameMap getActiveMap() {
        return activeMap;
    }

    /**
     * Sets the active game map.
     *
     * @param activeMap The GameMap instance to set as active.
     */
    public void setActiveMap(GameMap activeMap) {
        this.activeMap = activeMap;
    }

}
