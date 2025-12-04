
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;

public class PortfolioManager {
    private ArrayList<TransactionHistory> portfolioList = new ArrayList<>();
    private double cashBalance = 0.0;
    private Map<String, Double> stockHoldings = new HashMap<>();

    public static void main (String[] args) {
        PortfolioManager manager = new PortfolioManager();
        manager.run();

    }

    private void run() {
        Scanner sc = new Scanner(System.in);
        int choice;
        do {
            printMenu();
            choice = getIntInput(sc, "Select menu (0 to 6): ");
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
        System.out.println(" Brokerage Account ");
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
        cashBalance += amount;
        portfolioList.add(new TransactionHistory("CASH", today(),"DEPOSIT", amount, 1.00));
        System.out.println("Cash deposited successfully.");

    }

    private void withdrawCash(Scanner sc){
        double amount = getDoubleInput(sc, "Amount to withdraw: ");
        if (amount <= 0) {
            System.out.println("Needs positive input.");
            return;
        }
    if (amount > cashBalance) {
        System.out.println("Insufficient Funds");
        return;
    }
    cashBalance -= amount;
    portfolioList.add(new TransactionHistory ("CASH", today(),"WITHDRAW", amount, 1.00));
    System.out.println("Successful withdrawal");

    }
    private void buyStock(Scanner sc) {
        System.out.print("Input Stock Ticker");
        String ticker = sc.next().toUpperCase();
        double shares = getDoubleInput(sc, "Input amount of shares");
        double price = getDoubleInput(sc, "Share Price");
        double totalCost = shares * price;

        if (totalCost > cashBalance) {
            System.out.println("Not enough funds for stock purchase");
            return;
        }
        cashBalance -= totalCost;
        portfolioList.add(new TransactionHistory("CASH", today(), "WITHDRAW", -totalCost, 1.00));

        stockHoldings.put(ticker, stockHoldings.getOrDefault(ticker, 0.0) + shares);
        portfolioList.add(new TransactionHistory(ticker, today(), "BUY", shares, price));

        System.out.println("Success stock purchased.");
    }
    private void sellStock(Scanner sc) {
        System.out.println("Input ticker");
        String ticker = sc.next().toUpperCase();
        double shares = getDoubleInput(sc, "Amount to sell: ");
        double price = getDoubleInput(sc, "Share Price");

        double ownedShares = stockHoldings.getOrDefault(ticker, 0.0);
        if (shares > ownedShares) {
            System.out.println("Not enough shares");
            return;
        }
        double totalProceeds = shares * price;
        cashBalance += totalProceeds;
        portfolioList.add(new TransactionHistory("CASH", today(), "DEPOSIT", totalProceeds, 1.00));
        portfolioList.add(new TransactionHistory(ticker, today(), "SELL", shares, price));

        System.out.println("Success stock sold.");
    }
        private void displayTransactionHistory() {
        if (portfolioList.isEmpty()) {
            System.out.println("Empty transaction list");
            return;
        }
        System.out.println("Past Transactions");
        for (TransactionHistory th : portfolioList){
            System.out.println(th);
        }

    }

    private void displayPortfolio() {
        System.out.println("Summary of portfolio.");
        System.out.printf("Balance: $%.2f\n", cashBalance);

        if(stockHoldings.isEmpty()) {
            System.out.println("No holdings");
        } else {
            System.out.println("Current holdings:");
            for (Map.Entry<String, Double> entry : stockHoldings.entrySet()) {
                if (entry.getValue() > 0) {
                    System.out.printf("%-8s Shares: %.2f\n", entry.getKey(), entry.getValue());
                }
            }

        }

    }
    private String today() {
        return LocalDate.now().toString();
    }

    private int getIntInput(Scanner sc, String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                return sc.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Invalid enter int.");
                sc.nextLine();
            }
        }

    }
    private double getDoubleInput(Scanner sc, String prompt){
        while (true) {
            try {
                System.out.print(prompt);
                return sc.nextDouble();
            } catch (InputMismatchException e) {
                System.out.println("Input invalid enter a number");
                sc.nextLine();
            }
        }
    }

}
