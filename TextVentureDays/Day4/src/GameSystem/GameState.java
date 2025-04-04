package GameSystem;

public enum GameState {
    START_MENU,     // Initial menu state when game launches
    NEW_GAME,       // Creating a new game
    LOAD_GAME,      // Loading a saved game
    SETTINGS,       // Settings menu
    QUIT,           // Exiting the game
    EXPLORING,      // Generic exploring state
    EXPLORE,        // Active map exploration
    PLAYER_CREATION, // Character creation screen
    INTRO_MAP,      // Introduction/tutorial map
    VILLAGE_WAKE_UP, // Special state for village wake up sequence
    VILLAGE,        // Village hub area
    SHOP,           // Shop interaction
    INN,            // Inn/rest area
    GUILD           // Guild/quest hub
}
