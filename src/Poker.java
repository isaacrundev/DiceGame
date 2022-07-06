public class Poker {
    private int balance = 20;

    @Override
    public String toString() {
        return "Your Balance: $" + balance;
    }

    public int getBalance() {
        return balance;
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
}
