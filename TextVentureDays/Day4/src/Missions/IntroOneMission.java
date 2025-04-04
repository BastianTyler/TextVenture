package Missions;

import GameSystem.GameMaster;
import GameSystem.GameState;
import GameSystem.MapExplorer;

public class IntroOneMission implements Mission {
    private GameMaster gM = GameMaster.getInstance();
    private MapExplorer explorer = new MapExplorer();


    @Override
    public void play() {
        gM.setState(GameState.EXPLORING);

        explorer.startMapLoop("intro_1Map");
    }
}
