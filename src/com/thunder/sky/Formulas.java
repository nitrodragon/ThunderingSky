package com.thunder.sky;

import static java.lang.Math.floor;

/**
 * REAGAN LAND ONLY
 *
 * This class provides formulas used
 * by other classes such as players
 * and monsters.
 */
class Formulas {

    static int getHPStat(int base, int level, int iv, int ev) {
        return (int) floor((((base + iv) * 2 + ((Math.sqrt(ev) / 4))) * level) / 100) + level + 10; // Hecka long formula
    }

    static int getOtherStat(int base, int level, int iv, int ev) {
        return (int) floor((((base + iv) * 2 + ((Math.sqrt(ev) / 4))) * level) / 100) + 5; // Hecka long formula
    }

    static int calculateNext(int level, int classNum) {
        if (classNum == 0) {
            return (int) floor(((4 * level)^3) / 5);
        } else if (classNum == 1) {
            return level ^ 3;
        } else if (classNum == 2) {
            return (int) floor((((6/5) * level)^3) - ((15 * level)^2) + (100 * level) - 140); // Oh dear goodness I liked the class 2s until this
            // Hooray for polynomials amirite
        } else if (classNum == 3) {
            return (int) floor(((5 * level)^3) / 4);
        } else return 1000000;
    }

}
