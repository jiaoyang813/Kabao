package com.oscar.kabaoapp.dataObject;

import android.arch.persistence.room.TypeConverter;

/**
 * Created by Oscar on 12/28/2017.
 */

public class BankNameTypeConverter {

    @TypeConverter
    public static BankName fromString(String value)
    {
        BankName bankName = BankName.valueOf(value);

        return bankName;
    }

    @TypeConverter
    public static String fromEnum(BankName bankName)
    {
        return bankName.toString();
    }
}
