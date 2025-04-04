package GameSystem;



import EnemySystem.EnemyFactory;
import EnemySystem.EnemyType;
import EnemySystem.Foe;

import java.util.ArrayList;
import java.util.HashMap;

import java.util.List;
import java.util.Map;

/**
 * Manages all game maps available in the game.
 * Provides a centralized repository for map storage and retrieval.
 * Uses a static initialization block to create and configure all maps at startup.
 */
public class GameMapManager {
    private static final Map<String, GameMap> maps = new HashMap<>();

    /**
     * Static initialization block that creates all game maps and their associated enemy pools.
     * Maps are stored in a HashMap with string keys for easy lookup.
     */
    static{

        List<Foe> intro1EnemyList = new ArrayList<>();
        intro1EnemyList.add(EnemyFactory.createFoe(EnemyType.GOBLIN));
        intro1EnemyList.add(EnemyFactory.createFoe(EnemyType.HOB_GOBLIN));

        //      name of the reference,              name of the file
        maps.put("intro_1Map", new GameMap("Intro_1.txt","Intro_One", 10,4,intro1EnemyList));
    }

    /**
     * Retrieves a game map by its name identifier.
     *
     * @param name The string key identifying the desired map.
     * @return The GameMap object associated with the given name, or null if not found.
     */
    public static GameMap getMap(String name) {
        return maps.get(name);
    }
}
