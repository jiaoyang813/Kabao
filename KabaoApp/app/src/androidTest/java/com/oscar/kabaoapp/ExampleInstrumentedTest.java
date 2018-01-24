package com.oscar.kabaoapp;


import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Room;
import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import com.oscar.kabaoapp.DAO.CreditCardDao;
import com.oscar.kabaoapp.Database.KabaoDatabase;
import com.oscar.kabaoapp.dataObject.BankName;
import com.oscar.kabaoapp.dataObject.Creditcard;
import com.oscar.kabaoapp.dataObject.PaymentType;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.IOException;
import java.util.List;

import static junit.framework.Assert.assertEquals;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
    private CreditCardDao creditCardDao;
    private KabaoDatabase db;

    @Before
    public void createDb() {
        Context context = InstrumentationRegistry.getTargetContext();
        db = Room.inMemoryDatabaseBuilder(context, KabaoDatabase.class).build();
        creditCardDao = db.creditCardDao();
    }

    @After
    public void closeDb() throws IOException {
        db.close();
    }

    @Test
    public void writeUserAndReadInList() throws Exception {
        Creditcard card = new Creditcard();
        card.setPaymentTypeLogoRId(R.drawable.new_visa_big);
        card.setPaymentType(PaymentType.Visa);
        card.setExpiredOn("02/22");
        card.setCVV("123");
        card.setCrediLine("400");
        card.setCardImageRId(R.drawable.ic_placeholder);
        card.setStmtDate("12");
        card.setCardNo("111111111111111111");
        card.setBankName(BankName.Chase);
        card.setProductName("Chase Freedom");

        creditCardDao.insertCard(card);

    }
}