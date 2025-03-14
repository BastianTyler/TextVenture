public class Main {

    public static void main(String[] args) {
        // Create an instance of GameLogic
        GameLogic gameLogic = new GameLogic();

        // Retrieve the player object information
        Player player = gameLogic.newGame();

        // Print the player's information to the screen
        System.out.println("Player Name: " + player.getName());
        System.out.println("Player Gender: " + (player.getGender() == 'M' ? "Man" : "Woman"));
    }
}

