public class BaseMonster {

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHP() {
        return HP;
    }

    public int getATK() {
        return ATK;
    }

    public int getDEF() {
        return DEF;
    }

    public int getSPD() {
        return SPD;
    }

    public void setHP(int HP) {
        this.HP = HP;
    }

    public void setATK(int ATK) {
        this.ATK = ATK;
    }

    public void setDEF(int DEF) {
        this.DEF = DEF;
    }

    public void setSPD(int SPD) {
        this.SPD = SPD;
    }

    public int getReward() {
        return reward;
    }
}
