package com.samit.lld.designpatterns.behavioral.strategy.good;

public class StripePayment implements PaymentStrategy {
  public void processPayment() {
    System.out.println("Processing Stripe payment...");
  }
}