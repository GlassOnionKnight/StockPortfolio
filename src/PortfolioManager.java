
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.LocalDate;


public class PortfolioManager {
    private ArrayList<TransactionHistory> portfolioList = new ArrayList<>();
    private double cashBalance = 0.0;

    public static void main (String[] args) {
        PortfolioManager manager = new PortfolioManager();
        manager.run();

    }

    private void run() {
        Scanner sc = new Scanner(System.in);
        int choice;
        do {
            printMenu();


        }

    }
}
