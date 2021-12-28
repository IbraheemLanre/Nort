package com.nortal.platformer;

import java.util.*;

public class Game {

    public static void main(String[] args) {
        Game game = new Game("platforms.csv");
        game.run();
    }

    private Integer points = 500;
    private Platform activePlatform;
    private final String gameFile;

    public Game(String gameFile) {
        this.gameFile = gameFile;
    }

    public void run() {
        List<Platform> platforms = readPlatforms();

        // TODO: Implement your mighty algorithm and jump to oblivion.
        activePlatform = platforms.get(0);
        Platform nextPlatform = findNextPlatform(activePlatform);
        jumpTo(nextPlatform);

    }

    /**
     * Reads platforms from csv file and returns the as list.
     * @return platforms - Platforms as list
     */
    private List<Platform> readPlatforms() {
        return Collections.emptyList();
    }


    /**
     * Invoke this function to jump to next platform.
     * @param platform - Platform that you are going to jump to.
     */
    public void jumpTo(Platform platform) {

        activePlatform = platform;
    }

    private Platform findNextPlatform(Platform platform) {

        activePlatform = platform;
        int currentPlatform = 1;
        while(true){
            if(currentPlatform >= activePlatform.getIndex() && points > activePlatform.getCost()){
                points = points - activePlatform.getCost();
                System.out.println("You have " + points + " points");
            }

            if(currentPlatform >= activePlatform.getIndex() && points < activePlatform.getCost()){
                System.out.println("Go back to the previous platform");
                points = points + activePlatform.getCost();
                System.out.println("You have " + points + " points");
            }

            if(currentPlatform < activePlatform.getIndex()){
                break;
            }

            if(!readPlatforms().contains(activePlatform)){
                System.out.println("You cannot go outside platform numbers");
            }
        }
        return platform;
    }

}
