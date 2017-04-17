package com.thunder.sky.GUI;

import org.lwjgl.opengl.Display;
import org.newdawn.slick.*;
import org.newdawn.slick.state.*;
import java.awt.Toolkit;
import java.awt.Dimension;


/**
 * Entry point for GUI version of the game.
 * Runs Play.java using set parameters inside
 * this file.
 */


public final class Play extends StateBasedGame {

    private static final String gamename = "Thundering Sky";
    private static final int play = 0;
    private static final int fps = 60;
    private static final boolean showFps = false;
    static int width;
    static int height;

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
            Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
            width = (int)screenSize.getWidth();
            height = (int)screenSize.getHeight();
            gameContainer = new AppGameContainer(new Play(gamename));
            gameContainer.setVSync(true); // Should probably stay true for performance
            gameContainer.setDisplayMode(width, height, true);
            gameContainer.setTargetFrameRate(fps);
            gameContainer.setShowFPS(showFps);
            Display.setInitialBackground(1, 1, 1);
            gameContainer.start();
        } catch(SlickException e) {
            e.printStackTrace();
        }
    }
}