package com.trikisoft.javatest.payments;

/**
 * This interface simulates a class which we cannot instance
 * We have to mock it
 */
public interface PaymentGateway {
    PaymentResponse requestPayment(PaymentRequest request);
}
