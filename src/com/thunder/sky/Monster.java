package com.thunder.sky;

import java.util.concurrent.ThreadLocalRandom;

import static java.lang.Math.floor;

class Monster extends Fighter implements Monsters {

    private int reward;
    private String name;
    private boolean isMagic;

    private Player player;

    Monster(Player player, int monsterName, boolean isMagic) { // Constructor will take a player instance later
        BaseMonster mnst = monsters[monsterName];
        this.name = mnst.getName();
        this.reward = mnst.getReward();
        this.player = player;
        this.isMagic = isMagic;
        System.out.println("\nA " + name + " is approaching!");
        if (mnst.getSpd() > player.getSpd()) {
            attack();
        } else {
            defend();
        }
    }

    private void attack() {
        int tempHp;
        tempHp = getAtk() - (player.getDef() / 2); // Deal default damage minus half the players def
        if (tempHp < 1) {
            tempHp = 1; // Ensure the monster always deals at least 1 damage
        }
        player.setHp(player.getHp() - tempHp);
        System.out.println("The " + name + " attacks for " + tempHp + " damage. com.thunder.sky.Player now has " + player.getHp() +
        " health remaining.");
        if (player.getHp() > 0) {
            defend();
        } else {
            System.out.println("com.thunder.sky.Player died!");
        }
    }

    private void defend() {
        int tempHp;
        if (isMagic) {
            tempHp = player.getMag() - getDef(); // Magic deals less damage, but armor better armor penetration
        } else {
            tempHp = player.getAtk() - getDef() * 2; // Normal attacks
        }
        if (tempHp < 1) {
            tempHp = 1;
        }
        setHp(getHp() - tempHp);
        System.out.println("com.thunder.sky.Player attacks for " + tempHp + " damage. The " + name + " now has " + getHp() +
        " health remaining.");
        if (getHp() > 0) {
            attack();
        } else {
            System.out.println("com.thunder.sky.Monster dead");
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
}
