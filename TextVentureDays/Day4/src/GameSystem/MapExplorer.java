package GameSystem;

public class MapExplorer {

    private GameMaster gM = GameMaster.getInstance();
    private GameMap activeMap;
    private Encounter encounter;

    public void startMapLoop(String mapName) {
        gM.setActiveMap(GameMapManager.getMap(mapName));
        this.activeMap = gM.getActiveMap();

        while (gM.getState() == GameState.EXPLORING){
            activeMap.printMap();
            activeMap.chooseDirection();

            System.out.println(gM.getActiveMap().getName());
            this.encounter = new Encounter();
            encounter.determineEncounter(activeMap.getNewPlayerPosSymbol());

        }
    }
}
