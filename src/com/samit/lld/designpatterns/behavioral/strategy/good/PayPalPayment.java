package com.samit.lld.designpatterns.behavioral.strategy.good;

// Concrete strategy for PayPal payment
public class PayPalPayment implements PaymentStrategy {
  public void processPayment() {
    System.out.println("Processing PayPal payment...");
  }
}