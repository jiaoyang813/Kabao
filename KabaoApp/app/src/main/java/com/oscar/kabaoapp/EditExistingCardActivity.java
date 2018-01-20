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

public class EditExistingCardActivity extends AppCompatActivity {
    public static final String ExistingCard = "com.oscar.kabaoapp.EditExistingCard";
    public static final int RESULT_UPDATE = 8001;
    public static final int RESULT_DELETE = 8002;

    private EditText cardNickname;
    private EditText cardNo;
    private EditText expiredOn;
    private EditText ccv;
    private EditText stmtDate;
    private EditText creditLine;
    private TextView cardFeature;
    private Button removeCard;

    private Creditcard card;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_card);
        setupActionBar();
        setupRemoveCardButton();

        cardNickname = findViewById(R.id.card_alias);
        cardNo = findViewById(R.id.card_number);
        expiredOn = findViewById(R.id.expire_date);
        ccv = findViewById(R.id.ccv_code);
        stmtDate = findViewById(R.id.statement_date);
        creditLine = findViewById(R.id.credit_line);
        cardFeature = findViewById(R.id.textedit_card_features);

        Intent intent = getIntent();
        card = intent.getParcelableExtra(EditExistingCardActivity.ExistingCard);
        setupUI(card);
    }

    private void setupUI(Creditcard card)
    {
        if(card.getCardNickname().equals(""))
        {
            cardNickname.setText(card.getProductName());
        }
        else {
            cardNickname.setText(card.getCardNickname());
        }

        cardNo.setText(card.getCardNo());
        expiredOn.setText(card.getExpiredOn());
        ccv.setText(card.getCcv());
        stmtDate.setText(card.getStmtDate());
        creditLine.setText(card.getCrediLine());
        cardFeature.setText(card.getCardFeatures());
    }

    private void setupRemoveCardButton()
    {
        removeCard = findViewById(R.id.editcard_removecardButton);
        removeCard.setVisibility(View.VISIBLE);
        removeCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                CreditCardRepository creditCardRepository = new CreditCardRepository(getApplication());
                creditCardRepository.DeleteCard(card);
                setResult(RESULT_DELETE);
                finish();
            }
        });
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

        TextView save = findViewById(R.id.actionbar_item_addcard_save);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateCreditCard();
                CreditCardRepository creditCardRepository = new CreditCardRepository(getApplication());
                creditCardRepository.UpdateCard(card);
                finish();
            }
        });

        TextView cancel = findViewById(R.id.actionbar_item_addcard_cancel);
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void updateCreditCard()
    {
        card.setCardNickname(cardNickname.getText().toString());
        card.setProductName(card.getProductName());
        card.setCardImageRId(card.getCardImageRId());
        card.setPaymentType(card.getPaymentType());
        card.setPaymentTypeLogoRId(card.getPaymentTypeLogoRId());
        card.setBankName(card.getBankName());
        card.setCardFeatures(cardFeature.getText().toString());
        card.setCardNo(cardNo.getText().toString());
        card.setStmtDate(stmtDate.getText().toString());
        card.setCrediLine(creditLine.getText().toString());
        card.setCcv(ccv.getText().toString());
        card.setExpiredOn(expiredOn.getText().toString());
    }
}
