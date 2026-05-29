package UI;

import Food.Order;
import Food.Sandwich;
import Food.Drink;
import Food.Chips;
import util.ReceiptWriter;
import java.util.Scanner;

public class CheckoutScreen {
    private Scanner scanner;
    private Order order;

    public CheckoutScreen(Scanner scanner, Order order) {
        this.scanner = scanner;
        this.order = order;
    }

    public void display() {
        System.out.println("\nOrder Summary");

        if (!order.getSandwiches().isEmpty()) {
            System.out.println("\nSandwiches:");
            for (Sandwich s : order.getSandwiches()) {
                System.out.println(s);
                System.out.println();
            }
        }

        if (!order.getDrinks().isEmpty()) {
            System.out.println("Drinks:");
            for (Drink d : order.getDrinks()) {
                System.out.println(d);
            }
            System.out.println();
        }

        if (!order.getChips().isEmpty()) {
            System.out.println("Chips:");
            for (Chips c : order.getChips()) {
                System.out.println(c);
            }
            System.out.println();
        }

        System.out.printf("TOTAL: $%.2f%n", order.getTotalPrice());

        System.out.println("\n1) Confirm Order");
        System.out.println("0) Cancel Order");

        while (true) {
            System.out.print("Choice: ");
            String choice = scanner.nextLine().trim();
            if (choice.equals("1")) {
                ReceiptWriter.saveReceipt(order);
                System.out.println("\nOrder confirmed! Receipt saved.");
                System.out.println("Thank you for choosing The Krusty Krab!");
                break;
            } else if (choice.equals("0")) {
                System.out.println("Order cancelled. Returning to home screen.");
                break;
            } else {
                System.out.println("Invalid choice. Please enter 1 to confirm or 0 to cancel.");
            }
        }
    }
}
