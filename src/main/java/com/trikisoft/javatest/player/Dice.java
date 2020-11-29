package com.trikisoft.javatest.player;

import java.util.Random;

public class Dice {

    public int roll() {
        return new Random().nextInt();
    }
}
