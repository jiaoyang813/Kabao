package com.oscar.kabaoapp.Repositories;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.content.Context;
import android.os.AsyncTask;

import com.oscar.kabaoapp.DAO.CreditCardDao;
import com.oscar.kabaoapp.Database.KabaoDatabase;
import com.oscar.kabaoapp.dataObject.Creditcard;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Oscar on 12/31/2017.
 */

public class CreditCardRepository {
    private static CreditCardDao creditCardDao;

    private Creditcard[] allcards;
    private LiveData<List<Creditcard>> myCards;

    public CreditCardRepository(Application application) {
        KabaoDatabase db = KabaoDatabase.getKabaoDatabase(application);
        creditCardDao = db.creditCardDao();
        myCards = creditCardDao.loadAllCardsLive();
    }

    public LiveData<List<Creditcard>> getMyCards(){return myCards;}

    public LiveData<Creditcard> getCardById(int id){
        LiveData<Creditcard> card = creditCardDao.loadCardById(id);
        return card;
    }


    public void InsertCard(Creditcard card)
    {
        new InsertCardTask(creditCardDao).execute(card);
    }

    private class InsertCardTask extends AsyncTask<Creditcard, Void, Void> {

        private CreditCardDao mTaskDao;

        InsertCardTask(CreditCardDao creditCardDao)
        {
            this.mTaskDao = creditCardDao;
        }

        @Override
        protected Void doInBackground(Creditcard... creditcard) {
            mTaskDao.insertCard(creditcard);
            return null;
        }
    }

    public void DeleteCard(Creditcard card)
    {
        new DeleteCardTask().execute(card);
    }

    private static class DeleteCardTask extends AsyncTask<Creditcard, Void, Void> {
        @Override
        protected Void doInBackground(Creditcard... creditcard) {
            creditCardDao.deleteCard(creditcard);
            return null;
        }
    }


    public void UpdateCard(Creditcard card) { new UpdateCardTask().execute(card);}
    private static class UpdateCardTask extends AsyncTask<Creditcard, Void, Void> {
        @Override
        protected Void doInBackground(Creditcard... creditcard) {
            creditCardDao.updateCard(creditcard);
            return null;
        }
    }
}
