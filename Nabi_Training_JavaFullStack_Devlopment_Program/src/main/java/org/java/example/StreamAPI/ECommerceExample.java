package org.java.example.StreamAPI;

import java.util.*;
import java.util.stream.Collectors;

class Order {
    private String orderId;
    private String customerId;
    private double amount;
    private boolean delivered;

    // Constructor, getters and setters

    public Order(String orderId, String customerId, double amount, boolean delivered) {
        this.orderId = orderId;
        this.customerId = customerId;
        this.amount = amount;
        this.delivered = delivered;
    }

    public String getCustomerId() {
        return customerId;
    }

    public double getAmount() {
        return amount;
    }

    public boolean isDelivered() {
        return delivered;
    }
}

public class ECommerceExample {
    public static void main(String[] args) {
        List<Order> orders = Arrays.asList(
                new Order("001", "A123", 100.50, true),
                new Order("002", "B456", 200.00, false),
                new Order("003", "A123", 50.25, true),
                new Order("004", "C789", 300.00, true),
                new Order("005", "B456", 150.00, true),
                new Order("006", "D012", 5.00, false),
                new Order("007", "A123", 400.00, true)
        );

        Map<String, Double> topCustomers = orders.stream()
                .filter(Order::isDelivered)  // Filter delivered orders
                .collect(Collectors.groupingBy(
                        Order::getCustomerId,
                        Collectors.summingDouble(Order::getAmount)
                )) // Group by customer ID and sum their order amounts
                .entrySet().stream()
                .sorted(Map.Entry.<String, Double>comparingByValue().reversed())
                .limit(5) // Top 5 customers
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (e1, e2) -> e1,
                        LinkedHashMap::new
                ));

        System.out.println(topCustomers);
    }
}
