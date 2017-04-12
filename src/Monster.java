import java.util.concurrent.ThreadLocalRandom;

import static java.lang.Math.floor;

class Monster implements Monsters {

    private int hp;
    private int atk;
    private int def;
    private int reward;

    private String name;
    private boolean isMagic;

    private Player player;

    Monster(Player player, int monsterName, boolean isMagic) { // Constructor will take a player instance later
        BaseMonster mnst = monsters[monsterName];
        this.hp = mnst.getHP();
        this.atk = mnst.getATK();
        this.def = mnst.getDEF();
        this.name = mnst.getName();
        this.reward = mnst.getReward();
        this.player = player;
        this.isMagic = isMagic;
        System.out.println("\nA " + name + " is approaching!");
        if (mnst.getSPD() > player.getSpd()) {
            attack();
        } else {
            defend();
        }
    }

    private void attack() {
        int tempHp;
        tempHp = atk - (player.getDef() / 2); // Deal default damage minus half the players def
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

    private void defend() {
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
            earnXp();
        }
    }

    private void earnXp() {
        for (int i = 0; i < reward; i++) {
            switch(ThreadLocalRandom.current().nextInt(0,5)) {
                case 0:
                    player.setHpEV(player.getHpEV() + 1);
                    break;
                case 1:
                    player.setAtkEV(player.getAtkEV() + 1);
                    break;
                case 2:
                    player.setDefEV(player.getDefEV() + 1);
                    break;
                case 3:
                    player.setMagEV(player.getMagEV() + 1);
                    break;
                case 4:
                    player.setSpdEV(player.getSpdEV() + 1);
                    break;
                default:
                    player.setHpEV(player.getHpEV() + 1);
                    break;
            }
        }
    }

    // damageFormula
    private int damageFormula() {
        int power = 15; // Implementing 15 here in place of a weapon!
        int playerLevel = player.getLevel();
        int playerAtk = player.getAtk();
        int monsterDef = def;
        double modifier = ThreadLocalRandom.current().nextDouble(0.85, 1.0);
        return (int) floor((((((2 * playerLevel) / 5) + 2) * power * (playerAtk / monsterDef) / 50) + 2) * modifier);
    }

}
