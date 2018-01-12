package com.oscar.kabaoapp;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.oscar.kabaoapp.Repositories.CreditCardRepository;
import com.oscar.kabaoapp.dataObject.CreditCardTemplate;
import com.oscar.kabaoapp.dataObject.Creditcard;

import org.w3c.dom.Text;

public class EditCardActivity extends AppCompatActivity {

    private Button saveButton;
    private Button deleteCardButton;
    private EditText cardNickname;
    private EditText cardNo;
    private EditText expiredOn;
    private EditText ccv;
    private EditText stmtDate;
    private EditText creditLine;
    private TextView cardFeature;

    private CreditCardTemplate cardTemplate;
    Drawable cardImageRes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_card);

        setupActionBar();

        cardNo = findViewById(R.id.card_number);
        expiredOn = findViewById(R.id.expire_date);
        ccv = findViewById(R.id.ccv_code);
        stmtDate = findViewById(R.id.statement_date);
        creditLine = findViewById(R.id.credit_line);
        cardFeature = findViewById(R.id.textedit_card_features);


        saveButton = findViewById(R.id.btn_savecard);
        deleteCardButton = findViewById(R.id.btn_deletecard);

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Creditcard card = CreateCreditCard();
                CreditCardRepository creditCardRepository = new CreditCardRepository(getApplication());
                creditCardRepository.InsertCard(card);
                finish();
            }
        });

        Intent intent = getIntent();
        cardTemplate = intent.getParcelableExtra(AddCardActivity.CardTemplate);
        cardNickname = findViewById(R.id.card_alias);
        cardNickname.setText(cardTemplate.getProductName());
        cardFeature.setText(cardTemplate.getCardFeatures());
    }

    private void setupActionBar()
    {
        Toolbar myToolbar = findViewById(R.id.action_bar_editcard);
        setSupportActionBar(myToolbar);

        Toolbar.LayoutParams lp1 = new Toolbar.LayoutParams(Toolbar.LayoutParams.MATCH_PARENT, Toolbar.LayoutParams.MATCH_PARENT);
        View customNav = LayoutInflater.from(this).inflate(R.layout.actionbar_item_editcard, null);

        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setDisplayShowCustomEnabled(true);
        getSupportActionBar().setCustomView(customNav, lp1);
    }

    private Creditcard CreateCreditCard()
    {
        Creditcard card = new Creditcard();
        card.setCardNickname(cardNickname.getText().toString());
        card.setProductName(cardTemplate.getProductName());
        card.setCardImageRId(cardTemplate.getCardImageRId());
        card.setPaymentType(cardTemplate.getPaymentType());
        card.setPaymentTypeLogoRId(cardTemplate.getPaymentTypeLogoRId());
        card.setBankName(cardTemplate.getBankName());
        card.setCardFeatures(cardFeature.getText().toString());
        card.setCardNo(cardNo.getText().toString());
        card.setStmtDate(stmtDate.getText().toString());
        card.setCrediLine(creditLine.getText().toString());
        card.setCcv(ccv.getText().toString());
        card.setExpiredOn(expiredOn.getText().toString());

        return card;
    }

}
