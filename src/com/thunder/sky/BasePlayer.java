package com.thunder.sky;

import static java.lang.Math.floor;

class BasePlayer extends Fighter {

    private String characterClass;
    int Mag;

    BasePlayer(String characterClass, int HP, int ATK, int DEF, int MAG, int SPD) {
        this.characterClass = characterClass;
        setHp(HP);
        setAtk(ATK);
        setDef(DEF);
        setSpd(SPD);
        this.Mag = MAG;
    }

    String getCharacterClass() {
        return characterClass;
    }

    int getMag() {
        return Mag;
    }

    void setMag(int MAG) {
        this.Mag = MAG;
    }
}
