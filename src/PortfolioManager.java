
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.LocalDate;
import java.util.HashMap;
import java.util.Map;


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
            choice = getInput(sc, "Select menu (0 to 6): ");
            switch (choice) {
                case 0 -> System.out.println("Exit");
                case 1 -> depositCash(sc);
                case 2 -> withdrawCash(sc);
                case 3 -> buyStock(sc);
                case 4 -> sellStock(sc);
                case 5 -> displayTransactionHistory();
                case 6 -> displayPortfolio();
                default -> System.out.println("invalid, select again");

            }

        } while (choice !=0);
        sc.close();

    }
    private void printMenu() {
        System.out.println(" Brokerage Acount ");
        System.out.println("0 - Exit");
        System.out.println("1 - Deposit");
        System.out.println("2 - Withdraw");
        System.out.println("3 - Purchase Stock");
        System.out.println("4 - Sell Stock");
        System.out.println("5 - Display Transaction History");
        System.out.println("6 - Display Portfolio");
    }
    private void depositCash(Scanner sc) {
        double amount = getDoubleInput(sc, "Deposit amount");
        if (amount <= 0) {
            System.out.println("Needs to be positive");
            return;
        }

    }



    }

}
