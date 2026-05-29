package UI;

import java.util.Scanner;

public class HomeScreen {
    private Scanner scanner;

    public HomeScreen(Scanner scanner) {
        this.scanner = scanner;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        new HomeScreen(scanner).display();
        scanner.close();
    }

    public void display() {

        boolean running = true;
        while (running) {
            System.out.println("\nWelcome to the Krusty Krab!");
            System.out.println("1) New Order");
            System.out.println("0) Exit");
            System.out.println("9) Krabby Patty Secret Formula");
            System.out.print("Choice: ");

            String choice = scanner.nextLine().trim();

            if (choice.equals("1")) {

                new OrderScreen(scanner).display();
            } else if (choice.equals("9")) {
                System.out.println("");
                System.out.println("Nice try Plankton!");
            } else if (choice.equals("0")) {
                System.out.println("Thanks for visiting the Krusty Karbs! Goodbye!");
                running = false;
            } else {
                System.out.println("Invalid choice. Please enter 1, 9, or 0.");
            }
        }
    }

    }


