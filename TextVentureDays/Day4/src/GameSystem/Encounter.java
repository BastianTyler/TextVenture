package GameSystem;

/**
 * Handles the determination and execution of encounters during map exploration.
 * Interprets map symbols and triggers appropriate game events.
 */
public class Encounter {

    private final GameMaster gM = GameMaster.getInstance();

    /**
     * Handles randomized encounters.
     * Currently implemented as a stub for future functionality.
     */
    public void randomEncounter(){

    }

    /**
     * Handles transitions between different map areas.
     * Updates the game state and story progression as needed.
     */
    public void mapTransition(){

    }

    /**
     * Main encounter determination method called after each player movement.
     * Interprets the symbol at the player's new position and triggers appropriate events.
     *
     * @param symbol The character at the player's new position.
     */
    public void determineEncounter(char symbol){
        switch(symbol) {
            case '!' -> new BattleEncounter();
            case '$' -> randomEncounter();
            case '?' -> randomEncounter();
            case 'X' -> mapTransition();
        }
    }
}
