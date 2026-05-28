package UI;

import Food.Order;
import Food.Sandwich;
import Food.Drink;
import Food.Chips;
import java.util.List;
import java.util.Scanner;

public class OrderScreen {
    private Scanner scanner;
    private Order order;

    public OrderScreen(Scanner scanner) {
        this.scanner = scanner;
        this.order = new Order();
    }

    public void display() {
        boolean ordering = true;
        while (ordering) {
            System.out.println("\nYour Order");
            displayCurrentOrder();
            System.out.println("\n1) Add Sandwich");
            System.out.println("2) Add Drink");
            System.out.println("3) Add Chips");
            System.out.println("4) Checkout");
            System.out.println("0) Cancel Order");
            System.out.print("Choice: ");

            String choice = scanner.nextLine().trim();

            if (choice.equals("1")) {
                Sandwich sandwich = new SandwichScreen(scanner).buildSandwich();
                if (sandwich != null) {
                    order.addSandwich(sandwich);
                    System.out.println("Sandwich added!");
                }
            } else if (choice.equals("2")) {
                addDrink();
            } else if (choice.equals("3")) {
                addChips();
            } else if (choice.equals("4")) {
                boolean hasItems = !order.getSandwiches().isEmpty()
                        || !order.getDrinks().isEmpty()
                        || !order.getChips().isEmpty();
                if (!hasItems) {
                    System.out.println("Your order is empty! Add at least a drink or chips.");
                } else {
                    new CheckoutScreen(scanner, order).display();
                    ordering = false;
                }
            } else if (choice.equals("0")) {
                System.out.println("Order cancelled. Returning to home screen.");
                ordering = false;
            } else {
                System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void displayCurrentOrder() {
        if (order.getSandwiches().isEmpty() && order.getDrinks().isEmpty() && order.getChips().isEmpty()) {
            System.out.println("  (empty)");
            return;
        }

        List<Sandwich> sandwiches = order.getSandwiches();
        for (int i = sandwiches.size() - 1; i >= 0; i--) {
            Sandwich s = sandwiches.get(i);
            System.out.printf("  [Sandwich] %d\" %s%n", s.getSize(), s.getBread());
        }
        List<Drink> drinks = order.getDrinks();
        for (int i = drinks.size() - 1; i >= 0; i--) {
            System.out.println("  [Drink]    " + drinks.get(i));
        }
        List<Chips> chips = order.getChips();
        for (int i = chips.size() - 1; i >= 0; i--) {
            System.out.println("  [Chips]    " + chips.get(i));
        }
        System.out.printf("  Running total: $%.2f%n", order.getTotalPrice());
    }

    private void addDrink() {
        System.out.println("\nAdd Drink");
        System.out.println("  1) Small  ($2.00)");
        System.out.println("  2) Medium ($2.50)");
        System.out.println("  3) Large  ($3.00)");
        System.out.print("Size: ");

        String sizeChoice = scanner.nextLine().trim();
        String size;
        if (sizeChoice.equals("1"))      size = "Small";
        else if (sizeChoice.equals("2")) size = "Medium";
        else if (sizeChoice.equals("3")) size = "Large";
        else                             size = null;

        if (size == null) {
            System.out.println("Invalid size.");
            return;
        }

        System.out.print("Flavor: ");
        String flavor = scanner.nextLine().trim();
        if (flavor.isBlank()) flavor = "Fountain";

        order.addDrink(new Drink(size, flavor));
        System.out.println("Drink added!");
    }

    private void addChips() {
        System.out.println("\nAdd Chips ($1.50)");
        System.out.println("  1) Classic");
        System.out.println("  2) BBQ");
        System.out.println("  3) Sour Cream & Onion");
        System.out.println("  4) Salt & Vinegar");
        System.out.println("  5) Spicy");
        System.out.print("Type: ");

        String typeChoice = scanner.nextLine().trim();
        String type = switch (typeChoice) {
            case "1" -> "Classic";
            case "2" -> "BBQ";
            case "3" -> "Sour Cream & Onion";
            case "4" -> "Salt & Vinegar";
            case "5" -> "Spicy";
            default -> null;
        };

        if (type == null) {
            System.out.println("Invalid choice.");
            return;
        }

        order.addChips(new Chips(type));
        System.out.println("Chips added!");
    }
}
