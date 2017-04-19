package com.thunder.sky.GUI;

import org.newdawn.slick.*;
import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.command.*;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.state.*;
import java.awt.Font;
import java.util.LinkedList;

import org.newdawn.slick.TrueTypeFont;
import com.thunder.sky.Player;

import java.awt.*;

public class LevelUp extends BasicGameState {

    private double frameCount = 0;
    private TrueTypeFont active;

    public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
        active = new TrueTypeFont(Fonts.active.getFont(), true);
    }

    public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
        g.translate(0, 0);
        float scaler = (float)Math.abs(Math.sin(frameCount)) + 1;
        g.scale(scaler, scaler);
        active.drawString(200, 200, "Pulsing Text", Color.black);
        g.scale(1, 1);
    }

    public void update(GameContainer gc, StateBasedGame sbg,int DELTA) throws SlickException {
        frameCount += 0.1;
    }

    @Override
    public int getID() {
        return 3;
    }

}
