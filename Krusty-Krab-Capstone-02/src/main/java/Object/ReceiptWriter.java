package util;

import Food.Order;
import Food.Sandwich;
import Food.Toppings;
import Food.Drink;
import Food.Chips;
import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ReceiptWriter {

    public static void saveReceipt(Order order) {
        LocalDateTime now = LocalDateTime.now();
        String fileName = now.format(DateTimeFormatter.ofPattern("yyyyMMdd-HHmmss")) + ".txt";
        File folder = new File("receipts");
        if (!folder.exists()) folder.mkdirs();

        File receiptFile = new File(folder, fileName);

        try (PrintWriter writer = new PrintWriter(new FileWriter(receiptFile))) {
            writer.println("Krusty Krab Receipt");
            writer.println("Date/Time: " + now.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
            writer.println();

            if (!order.getSandwiches().isEmpty()) {
                writer.println("SANDWICHES:");
                for (Sandwich s : order.getSandwiches()) {
                    writer.printf("%d\" %s bread%s%n",
                            s.getSize(), s.getBread(), s.isToasted() ? " (toasted)" : "");
                    for (Toppings t : s.getToppings()) {
                        writer.println("- " + t);
                    }
                    writer.printf("Subtotal: $%.2f%n", s.getPrice());
                    writer.println();
                }
            }

            if (!order.getDrinks().isEmpty()) {
                writer.println("DRINKS:");
                for (Drink d : order.getDrinks()) {
                    writer.println(d);
                }
                writer.println();
            }

            if (!order.getChips().isEmpty()) {
                writer.println("CHIPS:");
                for (Chips c : order.getChips()) {
                    writer.println(c);
                }
                writer.println();
            }

            writer.printf("TOTAL: $%.2f%n", order.getTotalPrice());
            writer.println("Thank you for choosing the Krusty Krab!");

        } catch (IOException e) {
            System.out.println("Error saving receipt: " + e.getMessage());
        }

        System.out.println("Receipt saved: receipts/" + fileName);
    }
}
