package com.oscar.kabaoapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class CardDetailView extends AppCompatActivity {

    public static final String CardDetail = "com.oscar.kabaoapp.CardDetail";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card_detail_view);
    }
}
