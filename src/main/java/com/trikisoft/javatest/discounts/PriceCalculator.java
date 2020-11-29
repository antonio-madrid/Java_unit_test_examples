package com.trikisoft.javatest.discounts;

import java.util.ArrayList;
import java.util.List;

public class PriceCalculator {

    private final List<Double> prices = new ArrayList<>();
    private double discount = 0;

    public double getTotal() {

        double result = 0;

        for (Double price : prices) {
            result += price;
        }

        return calculateDiscount(result);
    }

    public void addPrice(double price) {
        prices.add(price);
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    /**
     * Formula to calculate a discount
     */
    private Double calculateDiscount(double givenNumber) {
        return givenNumber * ((100 - discount) / 100);
    }
}
