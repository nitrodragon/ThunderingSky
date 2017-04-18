package com.thunder.sky;

class BaseMonster extends Fighter {

    private String name;
    private int reward;
    // Maybe implement a magic option later?

    BaseMonster (String name, int HP, int ATK, int DEF, int SPD, int reward) {
        this.name = name;
        setHp(HP);
        setAtk(ATK);
        setDef(DEF);
        setSpd(SPD);
        this.reward = reward;
    }

    String getName() {
        return name;
    }

    void setName(String name) {
        this.name = name;
    }


    int getReward() {
        return reward;
    }
}
