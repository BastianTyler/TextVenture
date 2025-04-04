package MenuSystem;

import GameSystem.GameMaster;
import GameSystem.GameState;
import Support.HelperMethods;

public class MainMenu {

    private GameMaster gM = GameMaster.getInstance();


    public void startMenu(){
        while( gM.getState() == GameState.START_MENU){
            //print start menu
            HelperMethods.printFourChoices("New Game", "Load Game","Settings","Quit");
            //get user input
            int input = HelperMethods.getIntInput(4);
            //switch state depending on input
            switch(input){
                case 1 -> gM.setState(GameState.NEW_GAME);
                case 2 -> gM.setState(GameState.LOAD_GAME);
                case 3 -> gM.setState(GameState.SETTINGS);
                case 4 -> gM.setState(GameState.QUIT);
            }
        }
    }
}
