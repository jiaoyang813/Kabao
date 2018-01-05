package com.oscar.kabaoapp.dataObject;

import android.arch.persistence.room.TypeConverter;

/**
 * Created by Oscar on 1/2/2018.
 */

public class PaymentTypeConverter {
    @TypeConverter
    public static PaymentType fromString(String value)
    {
        PaymentType paymentType = PaymentType.valueOf(value);

        return paymentType;
    }

    @TypeConverter
    public static String fromEnum(PaymentType paymentType)
    {
        return paymentType.toString();
    }
}
