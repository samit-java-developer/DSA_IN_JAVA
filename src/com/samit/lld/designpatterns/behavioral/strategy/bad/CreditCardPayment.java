package com.samit.lld.designpatterns.behavioral.strategy.bad;

public class CreditCardPayment implements PaymentMethod {
  public void processPayment() {
    System.out.println("Processing credit card payment...");
  }
}