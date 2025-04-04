package GameSystem;

import MenuSystem.MainMenu;

public class GameEngine {
    private final MainMenu mainMenu = new MainMenu();
    private final GameMaster gM = GameMaster.getInstance();
    private final GameLogic gL = new GameLogic();
    private boolean isRunning = true;

    /**
     * Main game loop that controls the flow of the application.
     * Initializes tile events and then continuously processes the current game state,
     * directing control to the appropriate menu or logic handler.
     */
    public void runGame(){
        while (isRunning){
            switch (gM.getState()){
                case START_MENU: mainMenu.startMenu();
                    break;
                case NEW_GAME: gL.newGame();
                    break;
                case EXPLORE: gL.explore();
                    break;
            }
        }
    }
}
