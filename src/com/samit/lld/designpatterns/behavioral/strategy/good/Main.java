package com.samit.lld.designpatterns.behavioral.strategy.good;

public class Main {
    public static void main(String[] args) {
        PaymentStrategy creditCardPayment=new CreditCardPayment();
        PaymentStrategy cryptoPayment=new CryptoPayment();
        PaymentStrategy payPalPayment=new PayPalPayment();
        PaymentStrategy stripePayment=new StripePayment();

        PaymentProcessor paymentProcessor=new PaymentProcessor(creditCardPayment);
        paymentProcessor.processdPayment();
        paymentProcessor.setPaymentStrategy(cryptoPayment);
        paymentProcessor.processdPayment();
        paymentProcessor.setPaymentStrategy(payPalPayment);
        paymentProcessor.processdPayment();
        paymentProcessor.setPaymentStrategy(stripePayment);
        paymentProcessor.processdPayment();

    }
}
