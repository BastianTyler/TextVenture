
public class Main {

    public static void main(String[] args) {
        // Create an instance of GameLogic to manage the game flow
        GameLogic gameLogic = new GameLogic();
        String mapPath = "Intro_1.txt";

        Player player = gameLogic.newGame();
        GameMap activeMap = new GameMap(mapPath, player.getX(), player.getY());

        // Print the player's information to the screen
        System.out.println("Player Name: " + player.getName());
        System.out.println("Player Gender: " + (player.getGender() == 'M' ? "Man" : "Woman"));


        boolean isRunning = true;

        while(isRunning){
                activeMap.printMap();
                activeMap.chooseDirection();
        }
    }
}

