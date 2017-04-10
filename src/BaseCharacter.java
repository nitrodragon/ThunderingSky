// import nothing

public class BaseCharacter {

    private String characterClass;
    private int HP;
    private int ATK;
    private int DEF;
    private int MAG;
    private int SPD;

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
}
