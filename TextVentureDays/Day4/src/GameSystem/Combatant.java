package GameSystem;

/**
 * Represents a character that can engage in combat.
 * Extends NPC with combat-specific attributes and skills.
 */
public class Combatant extends NPC{

    private int attackPower;
    private int defencePower;

    /**
     * Creates a new Combatant with the specified attributes.
     *
     * @param name The name of the combatant.
     * @param gender The gender of the combatant.
     * @param age The age of the combatant in years.
     * @param hp The current hit points of the combatant.
     * @param maxHP The maximum hit points of the combatant.
     * @param attackPower The offensive combat strength.
     * @param defencePower The defensive combat resistance.
     */
    public Combatant(String name, char gender, int age, int hp, int maxHP, int attackPower, int defencePower) {
        super(name, gender, age, hp, maxHP);
        this.attackPower = attackPower;
        this.defencePower = defencePower;
    }


    /**
     * Gets the attack power of the combatant.
     *
     * @return Integer representing attack strength.
     */
    public int getAttackPower() {
        return attackPower;
    }

    /**
     * Sets the attack power of the combatant.
     *
     * @param attackPower The new attack power value.
     */
    public void setAttackPower(int attackPower) {
        this.attackPower = attackPower;
    }

    /**
     * Gets the defence power of the combatant.
     *
     * @return Integer representing defensive capability.
     */
    public int getDefencePower() {
        return defencePower;
    }

    /**
     * Sets the defence power of the combatant.
     *
     * @param defencePower The new defence power value.
     */
    public void setDefencePower(int defencePower) {
        this.defencePower = defencePower;
    }

}
