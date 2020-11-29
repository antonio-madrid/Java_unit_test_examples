package com.trikisoft.javatest.payments;

public class PaymentRequest {

    private final double amount;

    public PaymentRequest(double amount) {
        this.amount = amount;
    }

    public double getAmount() {
        return amount;
    }
}
