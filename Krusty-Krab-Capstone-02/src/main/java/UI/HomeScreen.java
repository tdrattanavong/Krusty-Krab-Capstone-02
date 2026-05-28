package UI;
import Object.Sound;
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
        sound.setFile(0);
        playMusic(0);
        boolean running = true;
        while (running) {
            System.out.println("\nWelcome to the Kristy Crab!");
            System.out.println("1) New Order");
            System.out.println("0) Exit");
            System.out.print("Choice: ");

            String choice = scanner.nextLine().trim();

            if (choice.equals("1")) {
                stopMusic();
                new OrderScreen(scanner).display();
            } else if (choice.equals("0")) {
                System.out.println("Thanks for visiting the Kristy Crab! Goodbye!");
                running = false;
            } else {
                System.out.println("Invalid choice. Please enter 1 or 0.");
            }
        }
    }
    Sound sound = new Sound();

    public void playMusic(int i) {
        sound.setFile(0);
        sound.play();
        sound.loop();
    }

    public void stopMusic() {
        sound.stop();
    }

    public void playSE(int i) {
        sound.setFile(i);
        sound.play();
    }

}

