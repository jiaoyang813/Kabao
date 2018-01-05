package com.oscar.kabaoapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.oscar.kabaoapp.Repositories.CreditCardRepository;
import com.oscar.kabaoapp.dataObject.BankName;
import com.oscar.kabaoapp.dataObject.Creditcard;
import com.oscar.kabaoapp.dataObject.PaymentType;

import org.w3c.dom.Text;

public class EditCardActivity extends AppCompatActivity {

    private Button saveButton;
    private Button cancelButton;
    private EditText cardNickname;
    private EditText cardNo;
    private EditText expiredOn;
    private EditText ccv;
    private EditText stmtDate;
    private EditText creditLine;
    private String productName;
    private BankName bankName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_card);

        cardNo = findViewById(R.id.card_number);
        expiredOn = findViewById(R.id.expire_date);
        ccv = findViewById(R.id.ccv_code);
        stmtDate = findViewById(R.id.statement_date);
        creditLine = findViewById(R.id.credit_line);

        Intent intent = getIntent();
        String selectedCardProductName = intent.getStringExtra(AddCardActivity.ProductName);
        String banknameStr = intent.getStringExtra(AddCardActivity.BankName);
        bankName = BankName.valueOf(banknameStr);

        cardNickname = findViewById(R.id.card_alias);
        cardNickname.setText(selectedCardProductName);

        productName = selectedCardProductName;

        saveButton = findViewById(R.id.btn_savecard);
        cancelButton = findViewById(R.id.btn_cancelsavecard);

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Creditcard card = CreateCreditCard();
                CreditCardRepository creditCardRepository = new CreditCardRepository(getApplication());
                creditCardRepository.InsertCard(card);
                finish();
            }
        });
    }



    private Creditcard CreateCreditCard()
    {
        Creditcard card = new Creditcard();
        card.setPaymentType(PaymentType.Visa);
        card.setPaymentTypeLogoRId(R.drawable.new_visa_big);
        card.setProductName(productName);
        card.setCardNo(cardNo.getText().toString());
        card.setBankName(bankName);
        card.setCardImageRId(R.drawable.ic_placeholder);
        card.setCcv(ccv.getText().toString());
        card.setCrediLine(creditLine.getText().toString());
        card.setStmtDate(stmtDate.getText().toString());
        card.setExpiredOn(expiredOn.getText().toString());

        return card;
    }

}
