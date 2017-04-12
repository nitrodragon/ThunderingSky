import static java.lang.Math.ceil;

public class Monster implements Monsters {

    private int hp;
    private int atk;
    private int def;
    private int spd;

    String name;
    boolean isMagic;

    private Player player;

    Monster(Player player, int monsterName, boolean isMagic) { // Constructor will take a player instance later
        BaseMonster tempMonster = monsters[monsterName];
        this.hp = tempMonster.getHP();
        this.atk = tempMonster.getATK();
        this.def = tempMonster.getDEF();
        this.spd = tempMonster.getSPD();
        this.name = tempMonster.getName();
        this.player = player;
        this.isMagic = isMagic;
        System.out.println("\nA " + name + " is approaching!");
        if (spd > player.getSpd()) {
            attack();
        } else {
            defend();
        }
    }

    void attack() {
        int tempHp;
        tempHp = atk - (player.getDef() / 2); // Deal default damage minus half the players hp
        if (tempHp < 1) {
            tempHp = 1; // Ensure the monster always deals at least 1 damage
        }
        player.setHp(player.getHp() - tempHp);
        System.out.println("The " + name + " attacks for " + tempHp + " damage. Player now has " + player.getHp() +
        " health remaining.");
        if (player.getHp() > 0) {
            defend();
        } else {
            System.out.println("Player died!");
        }
    }

    void defend() {
        int tempHp;
        if (isMagic) {
            tempHp = player.getMag() - def; // Magic deals less damage, but armor better armor penetration
        } else {
            tempHp = player.getAtk() - def * 2; // Normal attacks
        }
        if (tempHp < 1) {
            tempHp = 1;
        }
        hp -= tempHp;
        System.out.println("Player attacks for " + tempHp + " damage. The " + name + " now has " + hp +
        " health remaining.");
        if (hp > 0) {
            attack();
        } else {
            System.out.println("Monster dead");
        }
    }

}
