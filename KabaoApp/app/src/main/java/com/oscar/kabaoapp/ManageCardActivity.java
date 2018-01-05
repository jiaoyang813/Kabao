package com.oscar.kabaoapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
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
        Toolbar myToolbar = findViewById(R.id.action_bar_managecard);
        setSupportActionBar(myToolbar);
        loadFakeData();
        cardListAdapter = new ExistingCardListAdapter(ManageCardActivity.this, existingCards);
        existingCardListView = findViewById(R.id.existing_cardlist);
        existingCardListView.setAdapter(cardListAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.action_bar_managecard, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_add_card:
                Intent intent = new Intent(this, AddCardActivity.class);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void loadFakeData()
    {
        MockCreditCardDataProvider dataProvider = new MockCreditCardDataProvider();
        existingCards = dataProvider.getExistingCards();
    }

}
