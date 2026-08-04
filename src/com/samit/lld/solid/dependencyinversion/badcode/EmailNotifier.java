package com.samit.lld.solid.dependencyinversion.badcode;

// Problematic approach that violates DIP
class EmailNotifier {
    public void sendEmail(String message) {
        // Configure SMTP
        // Set up email templates
        // Send email implementation
    }
}

class Order {
    public String getId() {
        return "";
    }
}

class DatabaseLogger {
    public void logTransaction(String s) {
    }
}

class InventorySystem {
    public void updateStock(Order order) {
    }
}

class OrderService {
    private EmailNotifier emailNotifier;
    private DatabaseLogger logger;
    private InventorySystem inventory;

    public OrderService() {
        // Direct dependencies on concrete implementations
        this.emailNotifier = new EmailNotifier();
        this.logger = new DatabaseLogger();
        this.inventory = new InventorySystem();
    }

    public void placeOrder(Order order) {
        // Process order
        inventory.updateStock(order);
        emailNotifier.sendEmail("Order #" + order.getId() + " placed successfully");
        logger.logTransaction("Order placed: " + order.getId());
    }
}