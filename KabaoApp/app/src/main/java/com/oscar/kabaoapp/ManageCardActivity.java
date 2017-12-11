package com.oscar.kabaoapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.oscar.kabaoapp.DataProvider.MockCreditCardDataProvider;
import com.oscar.kabaoapp.dataObject.Creditcard;
import com.oscar.kabaoapp.listadapter.ExistingCardListAdapter;

import java.util.ArrayList;

// manage existing cards
public class ManageCardActivity extends AppCompatActivity {

    private ArrayList<Creditcard> existingCards;
    private ExistingCardListAdapter cardListAdapter;
    private ListView existingCardListView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manage_card);
        loadFakeData();
        cardListAdapter = new ExistingCardListAdapter(ManageCardActivity.this, existingCards);
        existingCardListView = findViewById(R.id.existing_cardlist);
        existingCardListView.setAdapter(cardListAdapter);
    }


    private void loadFakeData()
    {
        MockCreditCardDataProvider dataProvider = new MockCreditCardDataProvider();
        existingCards = dataProvider.getExistingCards();
    }
}
