public class Poker {
    private int balance = 100;

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

}
