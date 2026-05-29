package UI;

import Food.Order;
import Food.Sandwich;
import Food.Drink;
import Food.Chips;
import java.util.List;
import java.util.Scanner;

public class OrderScreen {
    private static final String RESET  = "\033[0m";
    private static final String STYLE  = "\033[1;38;2;101;28;28;48;2;205;170;105m";
    private static final String HEADER = "\033[1;38;2;101;28;28;48;2;190;155;90m";

    private Scanner scanner;
    private Order order;

    public OrderScreen(Scanner scanner) {
        this.scanner = scanner;
        this.order = new Order();
    }

    // Helper methods to keep styling consistent throughout
    private void println(String msg) {
        System.out.println(STYLE + msg + RESET);
    }

    private void print(String msg) {
        System.out.print(STYLE + msg + RESET);
    }

    public void display() {
        boolean ordering = true;
        while (ordering) {
            System.out.println();
            System.out.println(HEADER + "          GALLEY GRUB           " + RESET);
            System.out.println(STYLE  + "          Your Order             " + RESET);
            displayCurrentOrder();
            println("  1)  Add Sandwich               ");
            println("  2)  Add Drink                  ");
            println("  3)  Add Chips                  ");
            println("  4)  Checkout                   ");
            println("  0)  Cancel Order               ");
            print("Choice: ");

            String choice = scanner.nextLine().trim();

            if (choice.equals("1")) {
                Sandwich sandwich = new SandwichScreen(scanner).buildSandwich();
                if (sandwich != null) {
                    order.addSandwich(sandwich);
                    println("  Sandwich added!               ");
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
                    println("  Your order is empty!         ");
                } else {
                    new CheckoutScreen(scanner, order).display();
                    ordering = false;
                }
            } else if (choice.equals("0")) {
                println("  Order cancelled.             ");
                ordering = false;
            } else {
                println("  Invalid choice. Try again.   ");
            }
        }
    }

    private void displayCurrentOrder() {
        if (order.getSandwiches().isEmpty() && order.getDrinks().isEmpty() && order.getChips().isEmpty()) {
            println("  (empty)                        ");
            return;
        }

        List<Sandwich> sandwiches = order.getSandwiches();
        for (int i = sandwiches.size() - 1; i >= 0; i--) {
            Sandwich s = sandwiches.get(i);
            System.out.println(STYLE + String.format("  [Sandwich] %d\" %-18s", s.getSize(), s.getBread()) + RESET);
        }
        List<Drink> drinks = order.getDrinks();
        for (int i = drinks.size() - 1; i >= 0; i--) {
            System.out.println(STYLE + String.format("  [Drink]    %-20s", drinks.get(i)) + RESET);
        }
        List<Chips> chips = order.getChips();
        for (int i = chips.size() - 1; i >= 0; i--) {
            System.out.println(STYLE + String.format("  [Chips]    %-20s", chips.get(i)) + RESET);
        }
        System.out.println(STYLE + String.format("  Running total: $%-16.2f", order.getTotalPrice()) + RESET);
    }

    private void addDrink() {
        System.out.println();
        System.out.println(HEADER + "            Add Drink           " + RESET);
        println("  1)  Small  ($2.00)           ");
        println("  2)  Medium ($2.50)           ");
        println("  3)  Large  ($3.00)           ");

        String size = null;
        while (size == null) {
            print("Size: ");
            String sizeChoice = scanner.nextLine().trim();
            if (sizeChoice.equals("1"))      size = "Small";
            else if (sizeChoice.equals("2")) size = "Medium";
            else if (sizeChoice.equals("3")) size = "Large";
            else println("  Invalid. Please enter 1, 2, or 3.");
        }

        System.out.println();
        System.out.println(HEADER + "          Select a Flavor       " + RESET);
        for (int i = 0; i < Drink.FLAVORS.length; i++) {
            System.out.println(STYLE + String.format("  %d)  %-27s", i + 1, Drink.FLAVORS[i]) + RESET);
        }

        String flavor = null;
        while (flavor == null) {
            print("Flavor: ");
            String flavorChoice = scanner.nextLine().trim();
            try {
                int idx = Integer.parseInt(flavorChoice) - 1;
                if (idx >= 0 && idx < Drink.FLAVORS.length) flavor = Drink.FLAVORS[idx];
                else println("  Invalid. Please enter 1-" + Drink.FLAVORS.length + ".");
            } catch (NumberFormatException e) {
                println("  Invalid. Please enter 1-" + Drink.FLAVORS.length + ".");
            }
        }

        order.addDrink(new Drink(size, flavor));
        println("  Drink added!                 ");
    }

    private void addChips() {
        System.out.println();
        System.out.println(HEADER + "          Add Chips ($1.50)     " + RESET);
        for (int i = 0; i < Chips.FLAVORS.length; i++) {
            System.out.println(STYLE + String.format("  %d)  %-27s", i + 1, Chips.FLAVORS[i]) + RESET);
        }

        print("Type: ");
        String typeChoice = scanner.nextLine().trim();
        int idx;
        try {
            idx = Integer.parseInt(typeChoice) - 1;
        } catch (NumberFormatException e) {
            idx = -1;
        }

        if (idx < 0 || idx >= Chips.FLAVORS.length) {
            println("  Invalid choice.              ");
            return;
        }

        order.addChips(new Chips(Chips.FLAVORS[idx]));
        println("  Chips added!                 ");
    }
}
