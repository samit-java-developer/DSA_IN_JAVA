package com.samit.lld.designpatterns.behavioral.strategy.bad;

public class PayPalPayment implements PaymentMethod {
  public void processPayment() {
    System.out.println("Processing PayPal payment...");
  }
}