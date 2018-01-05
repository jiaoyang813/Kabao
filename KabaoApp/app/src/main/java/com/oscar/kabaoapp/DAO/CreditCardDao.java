package com.oscar.kabaoapp.DAO;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;
import android.arch.lifecycle.LiveData;
import com.oscar.kabaoapp.dataObject.Creditcard;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Oscar on 12/28/2017.
 */
@Dao
public interface CreditCardDao {

    @Query("SELECT * FROM usercreditcards")
    LiveData<List<Creditcard>> loadAllCardsLive();

    @Query("SELECT * FROM usercreditcards")
    Creditcard[] loadAllCard();


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertCard(Creditcard... card);

    @Update
    void updateCard(Creditcard... card);

    @Delete
    void deleteCard(Creditcard... card);
}
