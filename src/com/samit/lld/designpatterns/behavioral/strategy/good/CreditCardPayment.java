package com.samit.lld.designpatterns.behavioral.strategy.good;

// Concrete strategy for credit card payment
public class CreditCardPayment implements PaymentStrategy {
  public void processPayment() {
    System.out.println("Processing credit card payment...");
  }
}