package com.thunder.sky;

public class Main {

    /**
     * This should be the ONLY static/functional class
     *
     * com.thunder.sky.GUI.Play will eventually be the
     * real "main" class, but this is useful for testing
     */
    public static void main(String[] args) {
        System.out.println(5 ^ 10);
        Player players = new Player(0,3,0,0); // Turn this into an array to store multiple players
    }
}
