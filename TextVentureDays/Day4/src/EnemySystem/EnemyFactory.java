package EnemySystem;

/**
 * EnemyFactory is responsible for creating different types of enemies (Foes)
 * based on the specified EnemyType.
 */
public class EnemyFactory {

    /**
     * Creates and returns an instance of a specific type of Foe.
     *
     * @param enemyType The type of enemy to create, specified using the EnemyType enum.
     * @return A new instance of a Foe subclass
     */
    public static Foe createFoe(EnemyType enemyType) {
        return switch (enemyType) {
            case GOBLIN ->
                    new Goblin("Goblin", 'M', 20, 20, 20, 5, 0, EnemyType.GOBLIN, 10);
            case HOB_GOBLIN ->
                    new HobGoblin("Hob Goblin", 'M', 30, 40, 40, 10, 5, EnemyType.HOB_GOBLIN, 10);
        };
    }
}

