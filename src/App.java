import java.util.Random;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        DiceGame diceGame = new DiceGame();
        Random rand = new Random();
        Scanner input = new Scanner(System.in);
        System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
        System.out.println("x            Welcome to The Dice Game            x");
        System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx\n");
        while (diceGame.getBalance() > 0) {
            try {
                System.out.println("=======================");
                System.out.println(diceGame.toString());
                System.out.println("=======================");
                Thread.sleep(500);
                System.out.println("Choose the side you want to bet");
                System.out.println("(1): Red");
                System.out.println("(2): Blue");
                System.out.println("(3): Tie");

                Integer side = input.nextInt();
                if (side > 3 || side < 0) {
                    System.out.println("Please enter 1, 2 or 3");
                    Thread.sleep(1800);
                    diceGame.clrscr();
                    continue;
                }

                Thread.sleep(1800);
                System.out.println("Place your bet: ");
                Integer bet = input.nextInt();

                if (bet < 0) {
                    System.out.println("Please enter a vaild value");
                    Thread.sleep(1800);
                    diceGame.clrscr();
                    continue;
                } else if (bet > diceGame.getBalance()) {
                    System.out.println("Insufficient fund!!");
                    Thread.sleep(1800);
                    diceGame.clrscr();
                    continue;
                }

                int diceOfRed = rand.nextInt(6) + 1;
                int diceOfBlue = rand.nextInt(6) + 1;
                diceGame.Ads();
                Thread.sleep(1800);
                System.out.println("###############################");
                System.out.println("The point of Red is: " + diceOfRed);
                System.out.println("###############################");
                Thread.sleep(1800);
                System.out.println("###############################");
                System.out.println("The point of Blue is: " + diceOfBlue);
                System.out.println("###############################");
                Thread.sleep(1800);
                switch (side) {
                    case 1:
                        diceGame.SideOfRed(bet, diceOfRed, diceOfBlue);
                        break;
                    case 2:
                        diceGame.SideOfBlue(bet, diceOfRed, diceOfBlue);
                        break;
                    case 3:
                        diceGame.SideOfTie(bet, diceOfRed, diceOfBlue);
                        break;
                    // default:
                    // System.out.println("Please enter 1, 2 or 3");
                    // continue;
                }

                Thread.sleep(1800);

                diceGame.clrscr();
                if (diceGame.getMemberShip() == false && diceGame.getBalance() > 500) {
                    System.out.println("Would you like to pay $500 to sign up for ad-free membership? (Y/N)");
                    Character membership = input.next().charAt(0);
                    Character.toLowerCase(membership);
                    diceGame.signUp(membership);
                }
            } catch (Exception e) {
                System.out.println("Please enter a vaild value");
                input.next();
                Thread.sleep(1800);
                diceGame.clrscr();
            }
        }
        input.close();
        System.out.println("You've lost all your money.");
        System.out.println("---------GAME OVER---------");
        Thread.sleep(1800);

    }

}
