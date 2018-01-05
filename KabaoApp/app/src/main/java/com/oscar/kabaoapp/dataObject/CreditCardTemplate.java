package com.oscar.kabaoapp.dataObject;

/**
 * Created by Oscar on 12/28/2017.
 */

// Static credit card template.
public class CreditCardTemplate {
    private int id;
    private String productName;
    private int cardImageRId;
    private PaymentType paymentType;
    private int paymentTypeLogoRId;
    private BankName bankName;
    private String cardFeatures;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }


    public int getCardImageRId() {
        return cardImageRId;
    }

    public void setCardImageRId(int cardImageRId) {
        this.cardImageRId = cardImageRId;
    }


    public int getPaymentTypeLogoRId() {
        return paymentTypeLogoRId;
    }

    public void setPaymentTypeLogoRId(int paymentTypeLogoRId) {
        this.paymentTypeLogoRId = paymentTypeLogoRId;
    }

    public PaymentType getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(PaymentType paymentType) {
        this.paymentType = paymentType;
    }


    public BankName getBankName() {
        return bankName;
    }

    public void setBankName(BankName bankName) {
        this.bankName = bankName;
    }

    public String getCardFeatures() {
        return cardFeatures;
    }

    public void setCardFeatures(String cardFeatures) {
        this.cardFeatures = cardFeatures;
    }
}
