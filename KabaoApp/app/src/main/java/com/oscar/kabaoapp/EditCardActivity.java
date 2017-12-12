package com.oscar.kabaoapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class EditCardActivity extends AppCompatActivity {

    private Button saveButton;
    private Button cancelButton;
    private EditText cardAlias;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_card);

        Intent intent = getIntent();
        String selectedCardName = intent.getStringExtra(AddCardActivity.SELECTEDCARD);
        cardAlias = findViewById(R.id.card_alias);
        cardAlias.setText(selectedCardName);


    }



}
