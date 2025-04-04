package GameSystem;

import Missions.IntroOneMission;
import Support.HelperMethods;

public class GameLogic {
    private boolean isRunning = true;
    private final GameMaster gM = GameMaster.getInstance();
    private GameMap activeMap;


    public String setPlayerName() {
        boolean nameSet = false;
        String playerName;

        do {
            HelperMethods.defaultHeaderGenerator("Pick a name");
            playerName = HelperMethods.getStringInput();
            HelperMethods.headerGenerator("Is " + playerName + " truly your name?", 75);
            HelperMethods.printTwoChoices("Yes", "No");
            int input = HelperMethods.getIntInput(" ---> ", 2);
            if (input == 1)
                nameSet = true;
        } while (!nameSet);

        return playerName;
    }

    public char setPlayerGender() {
        boolean genderSet = false;
        String genderString = "";
        char genderChar = '?';

        do {
            HelperMethods.defaultHeaderGenerator("What is your gender?");
            HelperMethods.printTwoChoices("Man", "Woman");
            int genderInput = HelperMethods.getIntInput("--->", 2);

            if (genderInput == 1) {
                genderString = "Man";
                genderChar = 'M';
            } else {
                genderString = "Woman";
                genderChar = 'W';
            }

            HelperMethods.headerGenerator("You are a " + genderString, 40);
            HelperMethods.printTwoChoices("Yes", "No");
            int input = HelperMethods.getIntInput(" ---> ", 2);
            if (input == 1)
                genderSet = true;
        } while (!genderSet);

        return genderChar;
    }

//    public Player newGame() {
//        String playerName = setPlayerName();
//        char playerGender = setPlayerGender();
//        Player player = new Player(playerName, playerGender, 10, 10, 4);  // Setting default age as 10
//
//
//        HelperMethods.headerGenerator("Character Created!", 30);
//        System.out.println("Name: " + player.getName());
//        System.out.println("Gender: " + player.getGender());
//        System.out.println("Age: " + player.getAge());
//        System.out.println("Health: " + player.getHealth());
//        HelperMethods.anythingToContinue();
//
//        return player;
//    }

    public void newGame(){
        String playerName = setPlayerName();
        char playerGender = setPlayerGender();
        Player player = new Player(playerName,playerGender,10);
        gM.setPlayer(player);
        gM.setState(GameState.EXPLORE);
    }


    public void mapLoop(){
        while (gM.getState() == GameState.EXPLORING){
            activeMap.printMap();
            activeMap.chooseDirection();
        }
    }


    public void explore(){
        while(gM.getState() == GameState.EXPLORE){
            switch(gM.getPlayer().getStoryState()){
                case StoryState.INTRO_ONE -> new IntroOneMission().play();
            }
        }
    }

}
