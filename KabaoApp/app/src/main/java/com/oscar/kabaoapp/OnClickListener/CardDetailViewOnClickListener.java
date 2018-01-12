package com.oscar.kabaoapp.OnClickListener;

import android.content.Intent;
import android.view.View;

import com.oscar.kabaoapp.CardDetailView;
import com.oscar.kabaoapp.ViewModel.AddedCreditCardViewModel;
import com.oscar.kabaoapp.dataObject.Creditcard;

/**
 * Created by Oscar on 1/8/2018.
 */

public class CardDetailViewOnClickListener implements View.OnClickListener {

    private Creditcard cardToDisplay;

    public CardDetailViewOnClickListener(Creditcard card)
    {
        cardToDisplay = card;
    }


    @Override
    public void onClick(View v) {

        Intent intent = new Intent(v.getContext(), CardDetailView.class);
        intent.putExtra(CardDetailView.CardDetail, cardToDisplay);
        v.getContext().startActivity(intent);
    }
}
