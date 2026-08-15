package com.samit.lld.designpatterns.behavioral.strategy.good;

public class CryptoPayment implements PaymentStrategy {
  public void processPayment() {
    System.out.println("Processing crypto payment...");
  }
}