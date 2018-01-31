package com.oscar.kabaoapp.dataObject;

import android.os.Parcel;
import android.os.Parcelable;
import android.view.View;

import com.oscar.kabaoapp.Common.ResourceHelper;

/**
 * Created by Oscar on 12/28/2017.
 */

// Static credit card template.
public class CreditCardTemplate implements Parcelable {
    protected String productName;
    protected String cardImageName;
    protected PaymentType cardIssuer;
    protected String cardIssuerLogoName;
    protected BankName bankName;
    protected String cardFeatures;

    public CreditCardTemplate()
    {
    }

    protected CreditCardTemplate(Parcel in) {
        productName = in.readString();
        cardImageName = in.readString();
        cardIssuer = PaymentType.valueOf(in.readString());
        cardIssuerLogoName = in.readString();
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



    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getCardImageName() { return cardImageName; }

    public void setCardImageName(String cardImageName) {
        this.cardImageName = cardImageName;
    }

    public int getCardImageRId(View v)
    {
        return ResourceHelper.GetResId(getCardImageName(), v);
    }

    public void setCardImageRId(int Rid, View v) {
        setCardImageName(ResourceHelper.GetResName(Rid, v));
    }

    public PaymentType getCardIssuer() {
        return cardIssuer;
    }

    public void setCardIssuer(PaymentType cardIssuer) {
        this.cardIssuer = cardIssuer;
    }

    public String getCardIssuerLogoName() { return cardIssuerLogoName; }

    public void setCardIssuerLogoName(String cardIssuerLogoName) {
        this.cardIssuerLogoName = cardIssuerLogoName;
    }

    public int getCardIssuerLogoRId(View v)
    {
        return ResourceHelper.GetResId(getCardIssuerLogoName(), v);
    }

    public void setCardIssuerLogoRId(int Rid, View v) {
        setCardIssuerLogoName(ResourceHelper.GetResName(Rid, v));
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
        dest.writeString(productName);
        dest.writeString(cardImageName);
        dest.writeString(cardIssuer.toString());
        dest.writeString(cardIssuerLogoName);
        dest.writeString(bankName.toString());
        dest.writeString(cardFeatures);
    }
}
