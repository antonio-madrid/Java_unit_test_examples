package com.trikisoft.javatest.player;

public class Player {

    private final Dice dice;
    private final int minNumberToWin;

    public Player(Dice dice, int minNumberToWin) {
        this.dice = dice;
        this.minNumberToWin = minNumberToWin;
    }

    public boolean play() {
        int diceNumber = dice.roll();
        return diceNumber > minNumberToWin;
    }
}
