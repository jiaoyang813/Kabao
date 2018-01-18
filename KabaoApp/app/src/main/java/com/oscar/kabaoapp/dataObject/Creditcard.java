package com.oscar.kabaoapp.dataObject;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.arch.persistence.room.TypeConverter;
import android.arch.persistence.room.TypeConverters;
import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by oscar on 12/10/17.
 */

@Entity(tableName = "usercreditcards")
@TypeConverters({BankNameTypeConverter.class, PaymentTypeConverter.class})
public class Creditcard implements Parcelable {
    @PrimaryKey(autoGenerate = true)
    private int id;
    private String cardNickname;
    private String productName;
    private int cardImageRId;
    private PaymentType paymentType;
    private int paymentTypeLogoRId;
    private BankName bankName;
    private String cardFeatures;
    private String cardNo;
    private String stmtDate;
    private String crediLine;
    private String ccv;
    private String expiredOn;

    public Creditcard()
    {
    }

    protected Creditcard(Parcel in) {
        id = in.readInt();
        cardNickname = in.readString();
        productName = in.readString();
        cardImageRId = in.readInt();
        paymentType = PaymentType.valueOf(in.readString());
        paymentTypeLogoRId = in.readInt();
        bankName = BankName.valueOf(in.readString());
        cardFeatures = in.readString();
        cardNo = in.readString();
        stmtDate = in.readString();
        crediLine = in.readString();
        ccv = in.readString();
        expiredOn = in.readString();
    }

    public static final Creator<Creditcard> CREATOR = new Creator<Creditcard>() {
        @Override
        public Creditcard createFromParcel(Parcel in) {
            return new Creditcard(in);
        }

        @Override
        public Creditcard[] newArray(int size) {
            return new Creditcard[size];
        }
    };

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCardNickname() {
        return cardNickname;
    }

    public void setCardNickname(String cardNickname) {
        this.cardNickname = cardNickname;
    }


    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
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

    public String getCrediLine() {
        return crediLine;
    }

    public void setCrediLine(String crediLine) {
        this.crediLine = crediLine;
    }

    public String getCcv() {
        return ccv;
    }

    public void setCcv(String ccv) {
        this.ccv = ccv;
    }

    public String getExpiredOn() {
        return expiredOn;
    }

    public void setExpiredOn(String expiredOn) {
        this.expiredOn = expiredOn;
    }
    public String getStmtDate() {
        return stmtDate;
    }

    public void setStmtDate(String stmtDate) {
        this.stmtDate = stmtDate;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(cardNickname);
        dest.writeString(productName);
        dest.writeInt(cardImageRId);
        dest.writeString(paymentType.toString());
        dest.writeInt(paymentTypeLogoRId);
        dest.writeString(bankName.toString());
        dest.writeString(cardFeatures);
        dest.writeString(cardNo);
        dest.writeString(stmtDate);
        dest.writeString(crediLine);
        dest.writeString(ccv);
        dest.writeString(expiredOn);
    }


}
