package GameSystem;

/**
 * Represents a non-player character in the game world.
 * Stores basic attributes and state information about NPCs.
 */
public class NPC {

    private String name;
    private char gender;
    private int age;
    private int hp;
    private int maxHP;

    /**
     * Creates a new NPC with the specified attributes.
     *
     * @param name The name of the NPC.
     * @param gender The gender of the NPC, represented as a character.
     * @param age The age of the NPC in years.
     * @param hp The current hit points (health) of the NPC.
     * @param maxHP The maximum possible hit points of the NPC.
     */
    public NPC(String name, char gender, int age, int hp, int maxHP){
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.hp = hp;
        this.maxHP = maxHP;
    }

    /**
     * Gets the name of the NPC.
     *
     * @return The NPC's name.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the NPC.
     *
     * @param name The new name to assign to the NPC.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the gender of the NPC.
     *
     * @return Character representing the NPC's gender.
     */
    public char getGender() {
        return gender;
    }

    /**
     * Sets the gender of the NPC.
     *
     * @param gender Character representing the new gender to assign.
     */
    public void setGender(char gender) {
        this.gender = gender;
    }

    /**
     * Gets the age of the NPC.
     *
     * @return Integer representing the NPC's age in years.
     */
    public int getAge() {
        return age;
    }

    /**
     * Sets the age of the NPC.
     *
     * @param age Integer for the new age in years.
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * Gets the current hit points (health) of the NPC.
     *
     * @return Integer representing current HP.
     */
    public int getHp() {
        return hp;
    }

    /**
     * Sets the hit points (health) of the NPC.
     * Prevents HP from going below zero.
     *
     * @param hp The new HP value to set.
     */
    public void setHp(int hp) {
        this.hp = Math.max(hp, 0); //Return hp until 0, then return 0
    }

    /**
     * Gets the maximum hit points of the NPC.
     *
     * @return Integer representing maximum possible HP.
     */
    public int getMaxHP() {
        return maxHP;
    }

    /**
     * Sets the maximum hit points of the NPC.
     *
     * @param maxHP The new maximum HP value.
     */
    public void setMaxHP(int maxHP) {
        this.maxHP = maxHP;
    }
}
