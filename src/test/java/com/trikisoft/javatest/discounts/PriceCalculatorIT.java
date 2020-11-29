package com.trikisoft.javatest.discounts;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class PriceCalculatorIT {
    PriceCalculator calculator;

    @Before
    public void setup() {
        calculator = new PriceCalculator();
    }

    @Test
    public void should_return_total_zero_when_there_are_not_prices() {
        assertThat(calculator.getTotal(), is(0.0));
    }

    @Test
    public void should_return_the_sum_of_prices() {
        calculator.addPrice(10.2);
        calculator.addPrice(15.5);

        assertThat(calculator.getTotal(), is(25.7));
    }

    @Test
    public void should_apply_discount_to_prices() {
        calculator.addPrice(12.5);
        calculator.addPrice(17.5);
        calculator.setDiscount(50);

        assertThat(calculator.getTotal(), is(15.0));

        calculator = new PriceCalculator();
        calculator.addPrice(100);
        calculator.addPrice(50);
        calculator.addPrice(50);
        calculator.setDiscount(25);

        assertThat(calculator.getTotal(), is(150.0));
    }
}