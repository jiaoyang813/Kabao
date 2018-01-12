package com.oscar.kabaoapp.OnClickListener;

import android.arch.lifecycle.ViewModelProviders;
import android.view.View;

import com.oscar.kabaoapp.MainActivity;
import com.oscar.kabaoapp.ViewModel.AddedCreditCardViewModel;
import com.oscar.kabaoapp.dataObject.Creditcard;

/**
 * Created by Oscar on 1/5/2018.
 */

public class DeleteCardOnClickListener implements View.OnClickListener {

    private Creditcard cardToDelete;
    private AddedCreditCardViewModel addedCreditCardViewModel;

    public DeleteCardOnClickListener(AddedCreditCardViewModel viewModel, Creditcard card)
    {
        cardToDelete = card;
        addedCreditCardViewModel = viewModel;
    }

    @Override
    public void onClick(View v) {
        if(addedCreditCardViewModel != null)
        {
            addedCreditCardViewModel.delete(cardToDelete);
        }
    }
}
