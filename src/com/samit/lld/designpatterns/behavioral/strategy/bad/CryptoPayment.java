package com.samit.lld.designpatterns.behavioral.strategy.bad;

public class CryptoPayment implements PaymentMethod {
  public void processPayment() {
    System.out.println("Processing crypto payment...");
  }
}