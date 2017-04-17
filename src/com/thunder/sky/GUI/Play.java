package com.thunder.sky.GUI;

import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

/**
 * Entry point for GUI version of the game.
 * Runs Play.java using set parameters inside
 * this file.
 */


public class Play extends StateBasedGame {

    private static final String gamename = "Thundering Sky";
    private static final int play = 0;
    private static final int xSize = 400;
    private static final int ySize = 300;
    private static final int fps = 60;
    private static final boolean showFps = true;

    private Play(String gamename) {
        super(gamename);
        this.addState(new Menu());
        this.addState(new Game());
    }

    public void initStatesList(GameContainer gc) throws SlickException {
        this.enterState(play);
    }

    public static void main(String[] args) {
        AppGameContainer gameContainer;
        try {
            gameContainer = new AppGameContainer(new Play(gamename));
            gameContainer.setShowFPS(showFps);
            gameContainer.setVSync(true); // Should probably stay true for performance
            gameContainer.setDisplayMode(xSize, ySize, false);
            gameContainer.setTargetFrameRate(fps);
            gameContainer.start();
        } catch(SlickException e) {
            e.printStackTrace();
        }
    }
}