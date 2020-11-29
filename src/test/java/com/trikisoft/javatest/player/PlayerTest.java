package com.trikisoft.javatest.player;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class PlayerTest {

    private Dice dice;
    private Player player;

    @Before
    public void setup() {
        dice = Mockito.mock(Dice.class);
        player = new Player(dice, 5);
    }

    @Test
    public void looses_when_dice_number_is_too_low() {
        Mockito.when(dice.roll()).thenReturn(2);

        assertFalse(player.play());
    }

    @Test
    public void wins_when_dice_number_is_big() {
        Mockito.when(dice.roll()).thenReturn(6);

        assertTrue(player.play());
    }
}