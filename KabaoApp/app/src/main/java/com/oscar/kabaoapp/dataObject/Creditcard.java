package com.oscar.kabaoapp.dataObject;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.arch.persistence.room.TypeConverter;
import android.arch.persistence.room.TypeConverters;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.View;

import com.oscar.kabaoapp.Common.ResourceHelper;

/**
 * Created by oscar on 12/10/17.
 */

@Entity(tableName = "usercreditcards")
@TypeConverters({BankNameTypeConverter.class, PaymentTypeConverter.class})
public class Creditcard extends CreditCardTemplate implements Parcelable {

    @PrimaryKey(autoGenerate = true)
    private int id;
    private String cardNickname;
    private String cardNo;
    private String stmtDate;
    private String creditLine;
    private String cvv;
    private String expiredOn;

    public Creditcard()
    {
    }

    protected Creditcard(Parcel in) {
        super(in);
        id= in.readInt();
        cardNickname = in.readString();
        cardNo = in.readString();
        stmtDate = in.readString();
        creditLine = in.readString();
        cvv = in.readString();
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

    public String getCreditLine() {
        return creditLine;
    }

    public void setCreditLine(String crediLine) {
        this.creditLine = crediLine;
    }

    public String getCvv() { return cvv; }

    public void setCvv(String cvv) {  this.cvv = cvv; }


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
        super.writeToParcel(dest,flags);
        dest.writeInt(id);
        dest.writeString(cardNickname);
        dest.writeString(cardNo);
        dest.writeString(stmtDate);
        dest.writeString(creditLine);
        dest.writeString(cvv);
        dest.writeString(expiredOn);
    }


}
