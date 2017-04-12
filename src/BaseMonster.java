class BaseMonster {

    private String name;
    private int HP;
    private int ATK;
    private int DEF;
    private int SPD;
    private int reward;
    // Maybe implement a magic option later?

    BaseMonster (String name, int HP, int ATK, int DEF, int SPD, int reward) {
        this.name = name;
        this.HP = HP;
        this.ATK = ATK;
        this.DEF = DEF;
        this.SPD = SPD;
        this.reward = reward;
    }

    String getName() {
        return name;
    }

    void setName(String name) {
        this.name = name;
    }

    int getHP() {
        return HP;
    }

    int getATK() {
        return ATK;
    }

    int getDEF() {
        return DEF;
    }

    int getSPD() {
        return SPD;
    }

    void setHP(int HP) {
        this.HP = HP;
    }

    void setATK(int ATK) {
        this.ATK = ATK;
    }

    void setDEF(int DEF) {
        this.DEF = DEF;
    }

    void setSPD(int SPD) {
        this.SPD = SPD;
    }

    int getReward() {
        return reward;
    }
}
