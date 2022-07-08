import java.util.InputMismatchException;
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
        do {
            // try {
            System.out.println("=======================");
            System.out.println(diceGame.toString());
            System.out.println("=======================");
            Thread.sleep(500);
            System.out.println("Choose the side you want to bet");
            System.out.println("1 - Red");
            System.out.println("2 - Blue");
            System.out.println("3 - Tie");
            try {

                Integer side = input.nextInt();
                if (side > 3 || side < 0) {
                    System.out.println("Please enter 1, 2 or 3");
                    Thread.sleep(1000);
                    diceGame.clrscr();
                    continue;
                }

                Thread.sleep(1000);
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
                diceGame.clrscr();
                System.out.println("############### ################");
                System.out.println("#     Red     # #     Blue     #");
                System.out.println("############### ################");
                Thread.sleep(1800);
                System.out.println("#      " + diceOfRed + "      #" + " " + "#       " + diceOfBlue + "      #");
                System.out.println("############### ################");
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
            } catch (Exception e) {
                System.out.println("Please enter a vaild value!!");
                input.next();
                Thread.sleep(1800);
                diceGame.clrscr();
                continue;
            }

            Thread.sleep(3000);
            diceGame.clrscr();

            if (diceGame.getMemberShip() == false && diceGame.getBalance() > 500) {
                Boolean tf = true;
                while (tf == true) {
                    System.out
                            .println("Would you like to pay $500 to sign up for ad-free membership? (1-Yes, 2-No)");
                    try {

                        Integer yOrN = input.nextInt();
                        if (yOrN > 2 || yOrN < 0) {
                            System.out.println("Please enter 1 or 2");
                            Thread.sleep(1000);
                            diceGame.clrscr();
                            continue;
                        }

                        switch (yOrN) {

                            case 1:
                                diceGame.setBalance(diceGame.getBalance() - 500);
                                diceGame.setMemberShip(true);
                                System.out.println("You've sucessfully signed up for ad-free member. Hooray!!");
                                Thread.sleep(2000);
                                diceGame.clrscr();
                                tf = false;
                                break;

                            case 2:
                                System.out.println("Sad to hear that");
                                Thread.sleep(2000);
                                diceGame.clrscr();
                                tf = false;
                                break;

                        }
                    } catch (InputMismatchException e) {
                        System.out.println("Please enter 1 or 2");
                        input.next();
                        Thread.sleep(1800);
                        diceGame.clrscr();
                        continue;
                    }
                }
            }
            // } catch (Exception e) {
            // System.out.println("Please enter a vaild value");
            // input.next();
            // Thread.sleep(1800);
            // diceGame.clrscr();
            // }
        } while (diceGame.getBalance() > 0);
        input.close();
        System.out.println("You've lost all your money.");
        Thread.sleep(1000);
        System.out.println("You're broke now.");
        Thread.sleep(1000);
        System.out.println("---------GAME OVER---------");
    }

}
