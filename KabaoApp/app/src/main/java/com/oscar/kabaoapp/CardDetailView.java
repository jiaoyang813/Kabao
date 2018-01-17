package com.oscar.kabaoapp;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.oscar.kabaoapp.Common.ImageUtility;
import com.oscar.kabaoapp.OnClickListener.AddNewCardOnClickListener;
import com.oscar.kabaoapp.dataObject.Creditcard;

public class CardDetailView extends AppCompatActivity {

    public static final String CardDetail = "com.oscar.kabaoapp.CardDetail";

    private Creditcard card;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card_detail_view);
        setupActionBar();
        Intent intent = getIntent();
        card = intent.getParcelableExtra(CardDetailView.CardDetail);

        ImageView cardImage = findViewById(R.id.carddetail_cardimage);
        cardImage.setBackgroundResource(card.getCardImageRId());
        ImageUtility.scaleImage(128, 200, card.getCardImageRId(), cardImage, this.findViewById(android.R.id.content));

    }


    private void setupActionBar()
    {
        Toolbar myToolbar = findViewById(R.id.action_bar_carddetailview);
        setSupportActionBar(myToolbar);

        Toolbar.LayoutParams lp1 = new Toolbar.LayoutParams(Toolbar.LayoutParams.MATCH_PARENT, Toolbar.LayoutParams.MATCH_PARENT);
        View customNav = LayoutInflater.from(this).inflate(R.layout.actionbar_item_carddetailview, null);

        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setDisplayShowCustomEnabled(true);
        getSupportActionBar().setCustomView(customNav, lp1);


        // action bar menu option click listener
        TextView editCard = findViewById(R.id.actionbar_item_carddetailview_edit);
        editCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }
}
