// import nothing

import static java.lang.Math.floor;

public class BaseCharacter {

    private String characterClass;

    public void setCharacterClass(String characterClass) {
        this.characterClass = characterClass;
    }

    public int HP;
    public int ATK;
    public int DEF;
    public int MAG;
    public int SPD;

    public BaseCharacter(String characterClass, int HP, int ATK, int DEF, int MAG, int SPD) {
        this.characterClass = characterClass;
        this.HP = HP;
        this.ATK = ATK;
        this.DEF = DEF;
        this.MAG = MAG;
        this.SPD = SPD;
    }

    public String getCharacterClass() {
        return characterClass;
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

    public int getMAG() {
        return MAG;
    }

    public int getSPD() {
        return SPD;
    }

    public void setHP(int base, int level, int iv, int ev) {
        this.HP = (int) floor((((base + iv) * 2 + ((Math.sqrt(ev) / 4))) * level) / 100) + level + 10;
    }

    public void setATK(int base, int level, int iv, int ev) {
        this.ATK = (int) floor((((base + iv) * 2 + ((Math.sqrt(ev) / 4))) * level) / 100) + 5;
    }

    public void setDEF(int base, int level, int iv, int ev) {
        this.DEF = (int) floor((((base + iv) * 2 + ((Math.sqrt(ev) / 4))) * level) / 100) + 5;
    }

    public void setMAG(int base, int level, int iv, int ev) {
        this.MAG = (int) floor((((base + iv) * 2 + ((Math.sqrt(ev) / 4))) * level) / 100) + 5;
    }

    public void setSPD(int base, int level, int iv, int ev) {
        this.SPD = (int) floor((((base + iv) * 2 + ((Math.sqrt(ev) / 4))) * level) / 100) + 5;
    }

}
