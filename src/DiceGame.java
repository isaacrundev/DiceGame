import java.io.IOException;

public class DiceGame {
    private int balance = 1000;
    private boolean memberShip = false;

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public void setMemberShip(boolean memberShip) {
        this.memberShip = memberShip;
    }

    @Override
    public String toString() {
        return "Your Balance: $" + balance;
    }

    public int getBalance() {
        return balance;
    }

    public boolean getMemberShip() {
        return memberShip;
    }

    void Win(int bet) {
        balance = balance + bet;
    }

    void Lose(int bet) {
        balance = balance - bet;
    }

    void LoseDouble(int bet) {
        balance = balance - bet * 2;
    }

    void SideOfRed(int bet, int red, int blue) {
        if (red > blue) {
            Win(bet);
            System.out.println("Red Wins. You Won!");
            System.out.println("Congratulations!!");
        } else if (red < blue) {
            Lose(bet);
            System.out.println("Blue Wins. You Lost");
        } else {
            LoseDouble(bet);
            System.out.println("Tie!");
            System.out.println("You Lost Double of Your Bet!");
        }
    }

    void SideOfBlue(int bet, int red, int blue) {
        if (red < blue) {
            Win(bet);
            System.out.println("Blue Wins. You Won!");
            System.out.println("Congratulations!!");
        } else if (red > blue) {
            Lose(bet);
            System.out.println("Red Wins. You Lost");
        } else {
            LoseDouble(bet);
            System.out.println("Tie!");
            System.out.println("You Lost Double of Your Bet!");
        }
    }

    void SideOfTie(int bet, int red, int blue) {
        if (red == blue) {
            balance = balance + bet * 4;
            System.out.println("Tie. You Won!");
            System.out.println("Congratulations!! You Got 4 Times of Your Bet!!!!");
            System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
            System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
            System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");

        } else {
            Lose(bet);
            System.out.println("You Lost!");
        }
    }

    void Ads() throws InterruptedException {
        if (memberShip == false) {
            clrscr();
            System.out.println("=Pay $500 to get ad-free membership TODAY!=");
            System.out.println("===========================================");
            System.out.println("===========================================");
            System.out.println("===========================================");
            System.out.println("===========================================");
            System.out.println("                                        [5]");
            Thread.sleep(1000);
            clrscr();
            System.out.println("===========================================");
            System.out.println("=Pay $500 to get ad-free membership TODAY!=");
            System.out.println("===========================================");
            System.out.println("===========================================");
            System.out.println("===========================================");
            System.out.println("                                        [4]");
            Thread.sleep(1000);
            clrscr();
            System.out.println("===========================================");
            System.out.println("===========================================");
            System.out.println("=Pay $500 to get ad-free membership TODAY!=");
            System.out.println("===========================================");
            System.out.println("===========================================");
            System.out.println("                                        [3]");
            Thread.sleep(1000);
            clrscr();
            System.out.println("===========================================");
            System.out.println("===========================================");
            System.out.println("===========================================");
            System.out.println("=Pay $500 to get ad-free membership TODAY!=");
            System.out.println("===========================================");
            System.out.println("                                        [2]");
            Thread.sleep(1000);
            clrscr();
            System.out.println("===========================================");
            System.out.println("===========================================");
            System.out.println("===========================================");
            System.out.println("===========================================");
            System.out.println("=Pay $500 to get ad-free membership TODAY!=");
            System.out.println("                                        [1]");
            Thread.sleep(1000);
            clrscr();
            System.out.println("===========================================");
            System.out.println("=Pay $500 to get ad-free membership TODAY!=");
            System.out.println("===========================================");
            System.out.println("=================Dice Game=================");
            System.out.println("===========================================");
            System.out.println("                                        [0]");
            Thread.sleep(1000);
            clrscr();
        }

    }

    // void signUp(Integer oneOrTwo) throws InterruptedException {

    // if (Character.toLowerCase(YorN) == 'y') {
    // balance = balance - 500;
    // memberShip = true;
    // System.out.println("You've sucessfully signed up for ad-free member.
    // Hooray!!");
    // Thread.sleep(2000);
    // clrscr();

    // } else if (Character.toLowerCase(YorN) == 'n') {
    // System.out.println("Sad to hear that");
    // Thread.sleep(2000);
    // clrscr();
    // }
    // }

    void clrscr() {
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
