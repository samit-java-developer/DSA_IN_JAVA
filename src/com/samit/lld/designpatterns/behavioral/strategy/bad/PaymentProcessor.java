package com.samit.lld.designpatterns.behavioral.strategy.bad;

public class PaymentProcessor {
  // This method will process payment based on payment method type
  public void processPayment(String paymentMethod) {
    if (paymentMethod.equals("CreditCard")) {
      // Process Credit Card payment
      System.out.println("Processing credit card payment...");
    } else if (paymentMethod.equals("PayPal")) {
      // Process PayPal payment
      System.out.println("Processing PayPal payment...");
    } else if (paymentMethod.equals("Crypto")) {
      // Process Crypto payment
      System.out.println("Processing crypto payment...");
    } else {
      // If an unsupported payment method is entered
      System.out.println("Payment method not supported.");
    }
  }
  // if we want to add one more payment method then i need to add one more if for new type payment like Stripe.

  // via this approach we improved slightly....
  public void processPayment2UsingInterface(String paymentMethod) {
    if (paymentMethod.equals("CreditCard")) {
      CreditCardPayment creditCard = new CreditCardPayment();
      creditCard.processPayment(); // Process Credit Card payment
    } else if (paymentMethod.equals("PayPal")) {
      PayPalPayment payPal = new PayPalPayment();
      payPal.processPayment(); // Process PayPal payment
    } else if (paymentMethod.equals("Crypto")) {
      CryptoPayment crypto = new CryptoPayment();
      crypto.processPayment(); // Process Crypto payment
    } else if (paymentMethod.equals("Stripe")) {
      StripePayment stripe = new StripePayment();
      stripe.processPayment(); // Process Stripe payment
    } else {
      System.out.println("Payment method not supported.");
    }
  }

  //Why Is This Still a Problem? 🔴
        //  1. Adding New Payment Methods:
 // Every time a new payment method is added, you need to go into the PaymentProcessor class and add a new else if block. This results in code duplication and poor maintainability.
         // 2. Scalability Issues:
  //As the number of payment methods increases (imagine 20+ methods), the PaymentProcessor class will become massive, making it hard to read and hard to modify.

}