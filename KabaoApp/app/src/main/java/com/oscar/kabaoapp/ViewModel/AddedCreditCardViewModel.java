package com.oscar.kabaoapp.ViewModel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import com.oscar.kabaoapp.Repositories.CreditCardRepository;
import com.oscar.kabaoapp.dataObject.Creditcard;

import java.util.List;

/**
 * Created by Oscar on 1/3/2018.
 */

public class AddedCreditCardViewModel extends AndroidViewModel {

    CreditCardRepository creditCardRepository;

    private LiveData<List<Creditcard>> mAllCards;

    public AddedCreditCardViewModel(@NonNull Application application) {
        super(application);
        creditCardRepository = new CreditCardRepository(application);
        mAllCards = creditCardRepository.getMyCards();
    }


    public LiveData<List<Creditcard>> getAllCards(){return mAllCards;}

    public void insert(Creditcard card){ creditCardRepository.InsertCard(card);}

    public void delete(Creditcard card) { creditCardRepository.DeleteCard(card);}

    public void update(Creditcard card) { creditCardRepository.UpdateCard(card);}
}
