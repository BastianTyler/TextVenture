package GameSystem;

import EnemySystem.EnemyFactory;
import EnemySystem.EnemyType;
import EnemySystem.Foe;
import Support.HelperMethods;

import java.util.Random;


/**
 * Handles battle encounters between the player and enemies.
 * Manages combat mechanics, including damage calculation, turn execution, and battle outcomes.
 */

public class BattleEncounter {

    private final GameMaster gM = GameMaster.getInstance();
    private final Player player = gM.getPlayer();
    private final Foe enemy;
    private int playerDamage = 0;


    /**
     * Initializes a battle encounter with a randomly chosen enemy.
     */

    public BattleEncounter(){
        gM.setFoe(getRandomFoe());
        this.enemy = gM.getFoe();
        battle();
    }


    /**
     * Retrieves a random foe from the active map's list of valid enemies.
     * @return A new instance of a randomly selected Foe, or null if no enemies are available.
     */
    public Foe getRandomFoe(){

        if (gM.getActiveMap().getValidEnemies().isEmpty()) {
            return null;
        }

        Random random = new Random();
        int randomIndex = random.nextInt(gM.getActiveMap().getValidEnemies().size());
        //Very important, create a new instance of the enemy.
        try{
            return gM.getActiveMap().getValidEnemies().get(randomIndex);
        } catch (Exception e){
            System.out.println("Error creating enemy instance: " + e);
            return null;
        }
    }


    /**
     * Displays the battle introduction message to the player.
     */
    public void BattleSetup(){
        HelperMethods.headerGenerator("You are under attack!\n" +
                "A " + enemy.getName() + " is screaming death at you, prepare yourself!", 100);
        HelperMethods.anythingToContinue();
    }
    /**
     * Prints the combat menu with available player actions.
     */
    public void printCombatMenu(){
        HelperMethods.printFourChoices("Attack", "Defend", "Open Inventory", "Attempt to Flee");
    }
    /**
     * Checks if a combatant's HP is zero or below.
     * @param combatant The combatant whose status is being checked.
     * @return True if the combatant is dead, false otherwise.
     */
    public boolean checkForDeath(Combatant combatant){
        return (combatant.getHp() <= 0);
    }

    /**
     * Calculates damage dealt from an attacker to a defender.
     * @param attacker The attacking combatant.
     * @param defender The defending combatant.
     * @return The calculated damage amount.
     */
    public int calculateDamage(Combatant attacker, Combatant defender){
        int damage = attacker.getAttackPower() - defender.getDefencePower();
        if(damage < 0) damage = 0;
        return damage;
    }

    /**
     * Determines whether the battle is over and handles victory or defeat.
     * @return True if the battle is over, false otherwise.
     */
    public boolean determineBattleOver(){
        boolean battleOver = false;
        if(checkForDeath(enemy) && !checkForDeath(player)){
            handleVictory();
            battleOver = true;
        }
        if(checkForDeath(player)){
            handleDefeat();
            battleOver = false;
        }
        return battleOver;
    }

    /**
     * Handles victory conditions and rewards the player.
     */
    public void handleVictory(){
        HelperMethods.defaultHeaderGenerator("Foe Vanquished!");
    }

    /**
     * Handles defeat conditions.
     */
    public void handleDefeat(){
        HelperMethods.defaultHeaderGenerator(enemy.getName() + " has defeated you....");
    }

    /**
     * Applies damage to the player.
     */
    public void damagePlayer(){
        int enemyDamage = calculateDamage(enemy, player);
        player.setHp(player.getHp() - enemyDamage);
    }

    /**
     * Applies damage to the enemy.
     */
    public void damageEnemy(){
        int playerDamage = calculateDamage(player, enemy);
        enemy.setHp(enemy.getHp() - playerDamage);

    }


    /**
     * Executes an attack sequence for both the player and enemy.
     */
    //old attack method to just do raw damage
    public boolean attack(){
        //Calculate Damage & Set HP and check for deaths.
        damageEnemy();
        damagePlayer();
        return true;
        //Print Turn Overview
    }

    /**
     * Displays an overview of the last turn.
     */
    public void printTurnOverview(){

//        Utils.HelperMethods.clearScreen();
        HelperMethods.defaultHeaderGenerator("BATTLE REVIEW!");
        System.out.println("You dealt " + playerDamage+ " damage to the " + enemy.getName() + "!");
        System.out.println("The " + enemy.getName() + " dealt " + calculateDamage(enemy,player) + " damage to you!");
        HelperMethods.printDecorations(30);
        HelperMethods.anythingToContinue();
    }

    /**
     * Executes the defend action, calculating enemy damage and reducing the player's HP accordingly.
     */
    public boolean defend(){
        int enemyDamage = calculateDamage(player, enemy);
        player.setHp(player.getHp() - enemyDamage);
        return true;
    }

    /**
     * Attempts to flee from battle. (Currently unimplemented)
     */
    public boolean rollFlee(){
        return false;
    }

    /**
     * Executes the selected action based on the player's choice.
     *
     * @param action The action chosen by the player.
     *               1 -> Open skill menu
     *               2 -> Defend
     *               3 -> Open inventory
     *               4 -> Attempt to flee
     */
    public boolean executeAction(int action){

//        switch (action){
//            case START_MENU: mainMenu.startMenu();
//                break;
//            case NEW_GAME: gL.newGame();
//                break;
//            case LOAD_GAME: gL.loadGame();
//            case EXPLORE: gL.explore();
//                break;
//        }

        switch(action){
            case 1 -> {
                return attack();
            }
            case 2 -> {
                return defend();
            }
            case 3 -> {
                return false;
            }
            case 4 -> {
                return rollFlee();
            }
        }
        return false;
    }
    /**
     * Initiates a battle loop, handling combat turns until one participant's HP reaches zero.
     */
    public void battle(){
        boolean battleOver = false;
        boolean executed;
        BattleSetup();

        // Battle loop
        while(!battleOver){
            // Display enemy and player HP status
            HelperMethods.defaultHeaderGenerator(enemy.getName() + "\nHP: " + enemy.getHp() + "/" + enemy.getMaxHP());
            HelperMethods.defaultHeaderGenerator(player.getName() + "\nHP: " + player.getHp() + "/" + player.getMaxHP());

            // Print combat menu
            printCombatMenu();

            // Get user input for action
            int action = HelperMethods.getIntInput("", 4);

            // Execute chosen action
            executed = executeAction(action);

            if(executed) damagePlayer();

            printTurnOverview();

            // Check if battle is over
            battleOver = determineBattleOver();

        }
    }

}
