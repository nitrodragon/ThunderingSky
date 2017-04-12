import static java.lang.Math.floor;

class BaseCharacter {

    private String characterClass;
    
    private int HP;
    private int ATK;
    private int DEF;
    private int MAG;
    private int SPD;


    BaseCharacter(String characterClass, int HP, int ATK, int DEF, int MAG, int SPD) {
        this.characterClass = characterClass;
        this.HP = HP;
        this.ATK = ATK;
        this.DEF = DEF;
        this.MAG = MAG;
        this.SPD = SPD;
    }

    String getCharacterClass() {
        return characterClass;
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

    int getMAG() {
        return MAG;
    }

    int getSPD() {
        return SPD;
    }

    public void setCharacterClass(String characterClass) {
        this.characterClass = characterClass;
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
