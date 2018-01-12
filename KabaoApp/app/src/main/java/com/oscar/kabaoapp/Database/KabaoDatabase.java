package com.oscar.kabaoapp.Database;


/**
 * Created by Oscar on 12/28/2017.
 */

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.TypeConverters;
import android.content.Context;
import android.content.Entity;

import com.oscar.kabaoapp.DAO.CreditCardDao;
import com.oscar.kabaoapp.dataObject.BankNameTypeConverter;
import com.oscar.kabaoapp.dataObject.Creditcard;
import com.oscar.kabaoapp.dataObject.User;

@Database(entities= {Creditcard.class}, version = 1)
@TypeConverters({BankNameTypeConverter.class})
public abstract class KabaoDatabase extends RoomDatabase {
    private static KabaoDatabase INSTANCE;

    private static final String DATABASE_NAME = "kabao-database";

    public abstract CreditCardDao creditCardDao();

    public static KabaoDatabase getKabaoDatabase(Context context)
    {
        if(INSTANCE == null)
        {
            synchronized (KabaoDatabase.class){
                INSTANCE = Room.databaseBuilder(
                        context.getApplicationContext(),
                        KabaoDatabase.class,
                        DATABASE_NAME)
                        .build();
            }
        }

        return INSTANCE;
    }

    public static void destroyInstance()
    {
        INSTANCE = null;
    }
}
