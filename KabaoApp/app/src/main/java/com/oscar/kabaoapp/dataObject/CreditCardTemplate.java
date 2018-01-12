package com.oscar.kabaoapp.dataObject;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Oscar on 12/28/2017.
 */

// Static credit card template.
public class CreditCardTemplate implements Parcelable {
    private int id;
    private String productName;
    private int cardImageRId;
    private PaymentType paymentType;
    private int paymentTypeLogoRId;
    private BankName bankName;
    private String cardFeatures;

    public CreditCardTemplate()
    {
    }

    protected CreditCardTemplate(Parcel in) {
        id = in.readInt();
        productName = in.readString();
        cardImageRId = in.readInt();
        paymentType = PaymentType.valueOf(in.readString());
        paymentTypeLogoRId = in.readInt();
        bankName = BankName.valueOf(in.readString());
        cardFeatures = in.readString();
    }

    public static final Creator<CreditCardTemplate> CREATOR = new Creator<CreditCardTemplate>() {
        @Override
        public CreditCardTemplate createFromParcel(Parcel in) {
            return new CreditCardTemplate(in);
        }

        @Override
        public CreditCardTemplate[] newArray(int size) {
            return new CreditCardTemplate[size];
        }
    };

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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(productName);
        dest.writeInt(cardImageRId);
        dest.writeString(paymentType.toString());
        dest.writeInt(paymentTypeLogoRId);
        dest.writeString(bankName.toString());
        dest.writeString(cardFeatures);
    }
}
