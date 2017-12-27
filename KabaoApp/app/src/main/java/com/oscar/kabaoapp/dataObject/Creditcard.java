package com.oscar.kabaoapp.dataObject;

/**
 * Created by oscar on 12/10/17.
 */

public class Creditcard {
    private int id;
    private String productName;
    private String cardNo;
    private int sequence;
    private BankName bankName;

    public Creditcard(int id, String productName, String cardNo, int sequence)
    {
        this.id = id;
        this.productName = productName;
        this.cardNo = cardNo;
        this.sequence = sequence;
    }

    public int getId() { return id; }

    public String getName() { return productName;}

    public String getCardNo() {return cardNo;}

    public int getSequence() {return sequence;}
}
