package com.samit.lld.designpatterns.behavioral.strategy.good;

public class PaymentProcessor {

    private PaymentStrategy paymentStrategy;// Reference to a payment strategy
    // Constructor to set the payment strategy

    public PaymentProcessor(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public void processdPayment(){
        paymentStrategy.processPayment();
    }

    public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public PaymentStrategy getPaymentStrategy() {
        return paymentStrategy;
    }
}
