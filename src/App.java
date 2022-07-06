import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Poker poker = new Poker();
        Random rand = new Random();
        Scanner input = new Scanner(System.in);
        System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
        System.out.println("x                   Welcome                   x");
        System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx\n");

        while (poker.getBalance() > 0) {
            try {
                System.out.println(poker.toString());
                Thread.sleep(1200);
                System.out.println("Choose the side you want to bet");
                System.out.println("(1): Red");
                System.out.println("(2): Blue");
                System.out.println("(3): Tie");
                Integer side = input.nextInt();
                if (side > 3) {
                    System.out.println("Please enter 1, 2 or 3");
                    Thread.sleep(1200);
                    clrscr();
                    continue;
                }

                Thread.sleep(1200);
                System.out.println("Place your bet: ");
                Integer bet = input.nextInt();

                if (bet > poker.getBalance()) {
                    System.out.println("Insufficient fund!!");
                    Thread.sleep(1200);
                    continue;
                }
                int red = rand.nextInt(6) + 1;
                int blue = rand.nextInt(6) + 1;
                Thread.sleep(1200);
                System.out.println("The point of red is: " + red);
                Thread.sleep(1200);
                System.out.println("The point of blue is: " + blue);
                Thread.sleep(1200);
                switch (side) {
                    case 1:
                        poker.SideOfRed(bet, red, blue);
                        break;
                    case 2:
                        poker.SideOfBlue(bet, red, blue);
                        break;
                    case 3:
                        poker.SideOfTie(bet, red, blue);
                        break;
                }
                Thread.sleep(2000);
                clrscr();
            } catch (Exception e) {
                System.out.println("Please enter vaild values");
                input.next();
                Thread.sleep(1200);
                clrscr();
            }
        }
        input.close();
        System.out.println("You've lost all your money.");
        System.out.println("---------GAME OVER---------");

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
