import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Poker poker = new Poker();
        Random rand = new Random();
        Scanner input = new Scanner(System.in);
        System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
        System.out.println("x                   Welcome                   x");
        System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
        while (poker.getBalance() > 0) {
            // try {
            System.out.println(poker.toString());
            Thread.sleep(1200);
            System.out.println("Place your bet: ");
            Integer bet = input.nextInt();

            if (bet > poker.getBalance()) {
                System.out.println("Insufficient fund!!");
                Thread.sleep(1200);
                System.out.println("===========================");
                continue;
            }
            int player = rand.nextInt(13) + 1;
            int banker = rand.nextInt(13) + 1;
            Thread.sleep(1200);
            System.out.println("Your card is: " + player);
            Thread.sleep(1200);
            System.out.println("Banker's card is: " + banker);
            Thread.sleep(1200);
            if (player > banker) {
                poker.Win(bet);
                System.out.println("You Win!");
            } else if (player == banker) {
                System.out.println("Tie!");
            } else if (player < banker) {
                poker.Lose(bet);
                System.out.println("You Lose!");
            }
            System.out.println("===========================");
            Thread.sleep(1200);
            // } catch (InputMismatchException e) {
            // System.out.println("Please enter vaild numbers");
            // }
        }
        input.close();
        System.out.println("You've lost all your money.");
        System.out.println("---------GAME OVER---------");

    }
}
