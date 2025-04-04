package GameSystem;

import Support.HelperMethods;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GameMap {
    private int rows;
    private int cols;
    private int playerX;
    private int playerY;
    private String name;
    private char[][] mapGrid;
    private char newPlayerPosSymbol;

    public GameMap(String filePath, String name, int playerX, int playerY){
        loadMap(filePath);
        this.playerX = playerX;
        this.playerY = playerY;
        this.name = name;

    }

    public void loadMap(String filePath){
        List<char[]> tempGrid = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader(filePath));
            String line;
            while((line = br.readLine()) != null){
                tempGrid.add(line.toCharArray());
            }
            rows = tempGrid.size();
            cols = tempGrid.get(0).length;
            mapGrid = tempGrid.toArray(new char[rows][cols]);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void printMap(){
        for (char[] row : mapGrid){
            System.out.println(new String(row));
        }
    }

    public boolean isMoveValid(int newX, int newY){
        try {
            return (newX >= 0 && newX < cols && newY >= 0 && newY < rows && getTile(newX, newY) != '#');
        } catch (Exception e) {
            System.out.println("Invalid coordinate for this map.");
            throw new RuntimeException(e);
        }
    }

    public boolean checkNorth(){
        return isMoveValid(playerX, playerY - 1);
    }

    public boolean checkWest(){
        return isMoveValid(playerX - 2, playerY);
    }

    public boolean checkSouth(){
        return isMoveValid(playerX, playerY + 1);
    }

    public boolean checkEast(){
        return isMoveValid(playerX + 2, playerY);
    }

    public ArrayList<String> getValidDirections(){
        ArrayList<String> validDirections = new ArrayList<>();
        if (checkNorth()) validDirections.add("North");
        if (checkWest()) validDirections.add("West");
        if (checkSouth()) validDirections.add("South");
        if (checkEast()) validDirections.add("East");
        return validDirections;
    }

    private void printDirectionChoices(ArrayList<String> validDirections) {
        for (int i = 0; i < validDirections.size(); i++) {
            System.out.printf("(%d) %s\n", i + 1, validDirections.get(i));
        }
    }

    public void updatePlayerTile(){
        updateTile(playerX, playerY, '.');
    }
    private void movePlayer(String direction){
        switch (direction){
            case "North" :{
                updatePlayerTile();
                playerY = playerY - 1;
                break;
            }
            case "West" :{
                updatePlayerTile();
                playerX = playerX - 2;
                break;
            }
            case "South" :{
                updatePlayerTile();
                playerY = playerY + 1;
                break;
            }
            case "East" :{
                updatePlayerTile();
                playerX = playerX + 2;
                break;
            }
        }
    }


    public void chooseDirection(){
        HelperMethods.defaultHeaderGenerator("Choose a direction");
        //Player Coords.
//        System.out.println(playerX);
//        System.out.println(playerY);

        printDirectionChoices(getValidDirections());
        int direction = HelperMethods.getIntInput("-->", getValidDirections().size());
        movePlayer(getValidDirections().get(direction - 1));
        newPlayerPosSymbol = getTile(playerX, playerY);
        updatePlayerTile();
        updateTile(playerX, playerY, 'P' );
    }

    public char getTile(int x, int y){
        return mapGrid[y][x];
    }

    public void updateTile(int x, int y, char newSymbol){
        mapGrid[y][x] = newSymbol;
    }

    public String getName() {
        return name;
    }

    public char getNewPlayerPosSymbol() {
        return newPlayerPosSymbol;
    }
}
