import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        DiceGame poker = new DiceGame();
        Random rand = new Random();
        Scanner input = new Scanner(System.in);
        System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
        System.out.println("x                   Welcome                   x");
        System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx\n");

        while (poker.getBalance() > 0) {
            try {
                System.out.println(poker.toString());
                Thread.sleep(1800);
                System.out.println("Choose the side you want to bet");
                System.out.println("(1): Red");
                System.out.println("(2): Blue");
                System.out.println("(3): Tie");
                Integer side = input.nextInt();
                if (side > 3 || side < 0) {
                    System.out.println("Please enter 1, 2 or 3");
                    Thread.sleep(1800);
                    clrscr();
                    continue;
                }

                Thread.sleep(1800);
                System.out.println("Place your bet: ");
                Integer bet = input.nextInt();

                if (bet < 0) {
                    System.out.println("Please enter a vaild value");
                    Thread.sleep(1800);
                    clrscr();
                    continue;
                } else if (bet > poker.getBalance()) {
                    System.out.println("Insufficient fund!!");
                    Thread.sleep(1800);
                    clrscr();
                    continue;
                }
                int diceOfRed = rand.nextInt(6) + 1;
                int diceOfBlue = rand.nextInt(6) + 1;
                Thread.sleep(1800);
                System.out.println("The point of red is: " + diceOfRed);
                Thread.sleep(1800);
                System.out.println("The point of blue is: " + diceOfBlue);
                Thread.sleep(1800);
                switch (side) {
                    case 1:
                        poker.SideOfRed(bet, diceOfRed, diceOfBlue);
                        break;
                    case 2:
                        poker.SideOfBlue(bet, diceOfRed, diceOfBlue);
                        break;
                    case 3:
                        poker.SideOfTie(bet, diceOfRed, diceOfBlue);
                        break;
                }
                Thread.sleep(2000);
                clrscr();
            } catch (Exception e) {
                System.out.println("Please enter a vaild value");
                input.next();
                Thread.sleep(1800);
                clrscr();
            }
        }
        input.close();
        System.out.println("You've lost all your money.");
        System.out.println("---------GAME OVER---------");
        Thread.sleep(1800);

    }

    public static void clrscr() {
        // Clears Screen in java
        try {
            if (System.getProperty("os.name").contains("Windows"))
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            else
                Runtime.getRuntime().exec("clear");
            System.out.print("\033\143");
        } catch (IOException | InterruptedException ex) {
        }
    }
}
