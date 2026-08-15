package com.samit.lld.designpatterns.behavioral.strategy.bad;

public class StripePayment implements PaymentMethod {
  public void processPayment() {
    System.out.println("Processing Stripe payment...");
  }
}