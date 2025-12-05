/**
 * Author:  Alexander Rothstein
 * Date: 12/01/2025
 */

import java.text.DecimalFormat;
// for each transaction in PortfolioManager
public class TransactionHistory {
    private String ticker;
    private String transDate;
    private String transType;
    private double qty;
    private double costBasis;

//initial default constructor
    public TransactionHistory() {

        this.ticker = "";
        this.transDate = "";
        this.transType = "";
        this.qty = 0.0;
        this.costBasis = 0.0;
    }
//constructor for transactions in PortfolioManager
    public <transDate> TransactionHistory(String transDate,String ticker, String transType, double qty, double costBasis){
        this.ticker = ticker;
        this.transDate =  transDate;
        this.transType = transType;
        this.qty = qty;
        this.costBasis = costBasis;
    }
// all get/set
    public String getTicker() { return ticker; }
    public void setTicker(String ticker){this.ticker = ticker;}

    public String getTransDate() { return transDate; }
    public void setTransDate( String transDate ) {this.transDate = transDate; }

    public String getTransType() {return transType;}
    public void setTransType(String transType) {this.transType = transType;}

    public double getQty() {return qty;}
    public void setQty(double qty) {this.qty = qty; }

    public double getCostBasis( ) {return costBasis;}
    public void setCostBasis(double costBasis) {this.costBasis = costBasis;}
//display format for transactions in PortfolioManager
    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("#,##0.0");
        DecimalFormat money = new DecimalFormat("$#,##0.0");

        return String.format("%-12s %-8s %-12s %-12s %-12s",
                transDate,
                ticker,
                df.format(qty),
                money.format(costBasis),
                transType);
    }

}
