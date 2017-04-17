package com.thunder.sky;

import static java.lang.Math.floor;
public class LevelUpFormulas {

    private int level;
    private int EXP;
    private int nextEXP;

    private int getLevel(Player plr) {
        level = plr.getLevel();
        return plr.getLevel();
    }
    private int calculateNext(int level, int classNum) {
        if (classNum == 0) {
            return (int) floor(((4 * level)^3) / 5);
        } else if (classNum == 1) {
            return level^3;
        } else if (classNum == 2) {
            return (int) floor((((6/5) * level)^3) - ((15 * level)^2) + (100 * level) - 140); // Oh dear goodness I liked the class 2s until this
            // Hooray for polynomials amirite
        } else if (classNum == 3) {
            return (int) floor(((5 * level)^3) / 4);
        } else return 1000000;
    }

}
