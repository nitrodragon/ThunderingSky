package com.thunder.sky;

public abstract class Fighter {

    private int Hp, Atk, Def, Spd;

    public int getHp() {
        return Hp;
    }

    public int getAtk() {
        return Atk;
    }

    public int getDef() {
        return Def;
    }

    public int getSpd() {
        return Spd;
    }

    public void setHp(int hp) {
        Hp = hp;
    }

    public void setAtk(int atk) {
        Atk = atk;
    }

    public void setDef(int def) {
        Def = def;
    }

    public void setSpd(int spd) {
        Spd = spd;
    }
}
