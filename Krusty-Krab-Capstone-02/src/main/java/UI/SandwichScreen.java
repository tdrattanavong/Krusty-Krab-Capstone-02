package UI;

import Food.Sandwich;
import Food.Meat;
import Food.Cheese;
import Food.FreeToppings;
import java.util.Scanner;

public class SandwichScreen {
    private Scanner scanner;

    private static final String[] BREADS = {"white", "wheat", "rye", "wrap"};
    private static final String[] MEATS = {"steak", "ham", "salami", "roast beef", "chicken", "bacon"};
    private static final String[] CHEESES = {"american", "provolone", "cheddar", "swiss"};
    private static final String[] REGULAR_TOPPINGS = {
            "lettuce", "peppers", "onions", "tomatoes", "jalapeños",
            "cucumbers", "pickles", "guacamole", "mushrooms"
    };
    private static final String[] SAUCES = {
            "mayo", "mustard", "ketchup", "ranch", "thousand islands", "vinaigrette"
    };
    private static final String[] SIDES = {"au jus", "sauce"};

    public SandwichScreen(Scanner scanner) {
        this.scanner = scanner;
    }

    public Sandwich buildSandwich() {
        System.out.println("\nBuild a Sandwich");


        System.out.println("\nSelect bread:");
        for (int i = 0; i < BREADS.length; i++) {
            System.out.printf("%d) %s%n", i + 1, BREADS[i]);
        }
        System.out.print("Choice: ");
        int breadIdx = parseChoice(scanner.nextLine().trim(), BREADS.length);
        if (breadIdx < 0) {
            System.out.println("Invalid bread choice. Returning to order screen.");
            return null;
        }
        String bread = BREADS[breadIdx];


        System.out.println("\nSelect size:");
        System.out.println("1) 4\"  ($5.50)");
        System.out.println("2) 8\"  ($7.00)");
        System.out.println("3) 12\" ($8.50)");
        System.out.print("Choice: ");
        String sizeInput = scanner.nextLine().trim();
        int size;
        if (sizeInput.equals("1"))      size = 4;
        else if (sizeInput.equals("2")) size = 8;
        else if (sizeInput.equals("3")) size = 12;
        else                            size = -1;
        if (size < 0) {
            System.out.println("Invalid size choice. Returning to order screen.");
            return null;
        }

        Sandwich sandwich = new Sandwich(size, bread);

        addToppings(sandwich);

        sandwich.setToasted(askYesNo("\nWould you like the sandwich toasted? (y/n): "));

        return sandwich;
    }

    private void addToppings(Sandwich sandwich) {


        System.out.println("\nSelect meat (0 to skip):");
        for (int i = 0; i < MEATS.length; i++) {
            System.out.printf("%d) %s%n", i + 1, MEATS[i]);
        }
        while (true) {
            System.out.print("Choice: ");
            String meatInput = scanner.nextLine().trim();
            if (meatInput.equals("0") || meatInput.isBlank()) break;
            int idx = parseChoice(meatInput, MEATS.length);
            if (idx >= 0) {
                sandwich.addTopping(new Meat(MEATS[idx], false));
                if (askYesNo("Add extra " + MEATS[idx] + "? (y/n): ")) {
                    sandwich.addTopping(new Meat(MEATS[idx], true));
                }
                break;
            }
            System.out.println("Invalid choice. Please enter 1-" + MEATS.length + " or 0 to skip.");
        }


        System.out.println("\nSelect cheese (0 to skip):");
        for (int i = 0; i < CHEESES.length; i++) {
            System.out.printf("%d) %s%n", i + 1, CHEESES[i]);
        }
        while (true) {
            System.out.print("Choice: ");
            String cheeseInput = scanner.nextLine().trim();
            if (cheeseInput.equals("0") || cheeseInput.isBlank()) break;
            int idx = parseChoice(cheeseInput, CHEESES.length);
            if (idx >= 0) {
                sandwich.addTopping(new Cheese(CHEESES[idx], false));
                if (askYesNo("Add extra " + CHEESES[idx] + "? (y/n): ")) {
                    sandwich.addTopping(new Cheese(CHEESES[idx], true));
                }
                break;
            }
            System.out.println("Invalid choice. Please enter 1-" + CHEESES.length + " or 0 to skip.");
        }


        System.out.println("\nSelect other toppings (enter a number to add, 0 when done):");
        for (int i = 0; i < REGULAR_TOPPINGS.length; i++) {
            System.out.printf("%d) %s%n", i + 1, REGULAR_TOPPINGS[i]);
        }
        while (true) {
            System.out.print("Choice (0 to finish): ");
            String regularInput = scanner.nextLine().trim();
            if (regularInput.equals("0") || regularInput.isBlank()) break;
            int idx = parseChoice(regularInput, REGULAR_TOPPINGS.length);
            if (idx >= 0) {
                sandwich.addTopping(new FreeToppings(REGULAR_TOPPINGS[idx]));
                System.out.println(REGULAR_TOPPINGS[idx] + " added.");
            } else {
                System.out.println("Invalid choice. Please enter 1-" + REGULAR_TOPPINGS.length + " or 0 to finish.");
            }
        }


        System.out.println("\nSelect sauces (enter a number to add, 0 when done):");
        for (int i = 0; i < SAUCES.length; i++) {
            System.out.printf("%d) %s%n", i + 1, SAUCES[i]);
        }
        while (true) {
            System.out.print("Choice (0 to finish): ");
            String sauceInput = scanner.nextLine().trim();
            if (sauceInput.equals("0") || sauceInput.isBlank()) break;
            int idx = parseChoice(sauceInput, SAUCES.length);
            if (idx >= 0) {
                sandwich.addTopping(new FreeToppings(SAUCES[idx]));
                System.out.println(SAUCES[idx] + " added.");
            } else {
                System.out.println("Invalid choice. Please enter 1-" + SAUCES.length + " or 0 to finish.");
            }
        }


        System.out.println("\nSelect sides (enter a number to add, 0 when done):");
        for (int i = 0; i < SIDES.length; i++) {
            System.out.printf("%d) %s%n", i + 1, SIDES[i]);
        }
        while (true) {
            System.out.print("Choice (0 to finish): ");
            String sideInput = scanner.nextLine().trim();
            if (sideInput.equals("0") || sideInput.isBlank()) break;
            int idx = parseChoice(sideInput, SIDES.length);
            if (idx >= 0) {
                sandwich.addTopping(new FreeToppings(SIDES[idx]));
                System.out.println(SIDES[idx] + " added.");
            } else {
                System.out.println("Invalid choice. Please enter 1-" + SIDES.length + " or 0 to finish.");
            }
        }
    }

    private int parseChoice(String input, int max) {
        try {
            int val = Integer.parseInt(input) - 1;
            return (val >= 0 && val < max) ? val : -1;
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    private boolean askYesNo(String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine().trim().toLowerCase();
            if (input.equals("y")) return true;
            if (input.equals("n")) return false;
            System.out.println("Invalid input. Please enter y or n.");
        }
    }
}
