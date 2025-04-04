package EnemySystem;

import GameSystem.Combatant;

/**
 * The Foe class represents an enemy entity in the game.
 * It is an abstract class that extends Combatant, meaning all enemies share common combat-related properties.
 */
public abstract class Foe extends Combatant {

    /** The specific type of enemy (e.g., Goblin, HobGoblin, Shadow). */
    private final EnemyType enemyType;
    private final int experienceValue;

    /**
     * Constructs a Foe with the given attributes.
     *
     * @param name          The name of the enemy.
     * @param gender        The gender or classification of the enemy (e.g., 'M' for male, 'N' for neutral).
     * @param age           The age of the enemy.
     * @param hp            The current health points of the enemy.
     * @param maxHP         The maximum health points the enemy can have.
     * @param attackPower   The enemy's attack power, affecting damage dealt.
     * @param defencePower  The enemy's defense power, affecting damage received.
     * @param enemyType     The specific type of enemy, defined by the EnemyType enum.
     */
    public Foe(String name, char gender, int age, int hp, int maxHP, int attackPower, int defencePower, EnemyType enemyType, int experienceValue) {
        super(name, gender, age, hp, maxHP, attackPower, defencePower);
        this.enemyType = enemyType;
        this.experienceValue = experienceValue;
    }

    /**
     * Gets the type of enemy.
     *
     * @return The EnemyType associated with this foe.
     */
    public EnemyType getEnemyType() {
        return enemyType;
    }

    public int getExperienceValue() {
        return experienceValue;
    }
}

