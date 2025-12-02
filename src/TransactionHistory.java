/**
 * Author:  Alexander Rothstein
 * Date: 12/01/2025
 */



public class TransactionHistory {
    private String ticker;
    private String transDate;
    private String transType;
    private double qty;
    private double costBasis;

    public TransactionHistory() {

        this.ticker = "";
        this.transDate = "";
        this.transType = "";
        this.qty = 0.0;
        this.costBasis;

    }
    public TransactionHistory(String ticker, transDate, String transType, double qty, double costBasis){
        this.ticker = ticker;
        this.transDate = transDate;
        this.transType = transType;
        this.qty = qty;
        this.costBasis = costBasis;
    }

    public String getTicker() { return ticker; }
    public void setTicker(String ticker){this.ticker = ticker;}

    public String getTransDate() { return transDate; }
    public void setTransDate( String transDate ) {this.transDate = transDate; }

}
