package com.thunder.sky.GUI;

import org.lwjgl.opengl.Display;
import org.newdawn.slick.*;
import org.newdawn.slick.command.*;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.state.*;
import java.awt.Font;
import org.newdawn.slick.TrueTypeFont;
import com.thunder.sky.Player;

import static com.thunder.sky.Player.getCharacterClass;

/**
 * Main menu screen. Currently only used to
 * input stats that are printed to console.
 */

public class Menu extends BasicGameState implements InputProviderListener {

    private float frameCount = 0;
    private TrueTypeFont active;
    private TrueTypeFont inactive;
    private String[] statNames = {"Attack: ", "Defence: ", "Magic: ", "Speed: "};
    private int[] statValues = {0, 0, 0, 0};
    private BasicCommand up = new BasicCommand("up");
    private BasicCommand down = new BasicCommand("down");
    private BasicCommand left = new BasicCommand("left");
    private BasicCommand right = new BasicCommand("right");
    private BasicCommand enter = new BasicCommand("enter");
    private int pointer = 0; // Which stat is being edited
    private Rectangle[] rect = new Rectangle[4];
    private StateBasedGame sb;
    private Graphics grp;
    private boolean firstRender = true;
    private String playerName = "Villager";

    public void init(GameContainer gc, StateBasedGame sbg)
            throws SlickException {
        sb = sbg;
        InputProvider provider = new InputProvider(gc.getInput());
        provider.addListener(this);
        Font finactive = new Font("Open Sans", Font.PLAIN, Play.width/60);
        Font factive = new Font("Open Sans", Font.BOLD, Play.width/40);
        active = new TrueTypeFont(factive, true);
        inactive = new TrueTypeFont(finactive, true);
        provider.bindCommand(new KeyControl(Input.KEY_UP), up);
        provider.bindCommand(new KeyControl(Input.KEY_DOWN), down);
        provider.bindCommand(new KeyControl(Input.KEY_LEFT), left);
        provider.bindCommand(new KeyControl(Input.KEY_RIGHT), right);
        provider.bindCommand(new KeyControl(Input.KEY_ENTER), enter);
        for (int i = 0; i < rect.length; i++) {
            rect[i] = new Rectangle(100, 20 + (70 * i), statValues[i] * 40, 20);
        }
    }

    public void render(GameContainer gc, StateBasedGame sbg, Graphics g)
            throws SlickException {
        if (firstRender) {
            g.setBackground(Color.white);
            g.setColor(Color.black);
        }
        for (int i = 0; i < statNames.length; i++) {
            if (pointer == i) {
                // + (float)Math.sin(frameCount * 25)
                g.setColor(Color.black);
                active.drawString(20, 20 + (70 * i), statNames[i] + statValues[i], Color.black);
            } else {
                g.setColor(Color.black);
                inactive.drawString(20, 20 + (70 * i), statNames[i] + statValues[i], Color.black);
            }
            active.drawString(Play.width/3, Play.height/4, playerName, Color.black);

            if (statValues[i] > 0) g.draw(rect[i]);
        }
        firstRender = false; // Should be last statement
    }

    public void update(GameContainer gc, StateBasedGame sbg, int delta)
            throws SlickException {
        frameCount += 0.01;
    }

    @Override
    public void controlPressed(Command command) {
        if (command.toString().equals("[Command=down]")) {
            if (pointer < 3) pointer++;
        } else if (command.toString().equals("[Command=up]")){
            if (pointer > 0) pointer--;
        } else if (command.toString().equals("[Command=right]")) {
            if (statValues[pointer] < 3) {
                statValues[pointer]++;
                rect[pointer].setWidth(statValues[pointer] * 40);
            }
        } else if (command.toString().equals("[Command=left]")) {
            if (statValues[pointer] > 0) {
                statValues[pointer]--;
                rect[pointer].setWidth(statValues[pointer] * 40);
            }
        } else {
            Player player = new Player(statValues[0], statValues[1], statValues[2], statValues[3]);
            sb.enterState(2);
            return;
        }
        playerName = Player.getPlayerName(getCharacterClass(statValues[0], statValues[1], statValues[2], statValues[3]));
    }

    @Override
    public void controlReleased(Command command) {

    }

    public int getID() {
        return 0;
    }
}