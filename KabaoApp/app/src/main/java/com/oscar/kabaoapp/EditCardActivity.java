package com.oscar.kabaoapp;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.NumberPicker;
import android.widget.TextView;

import com.oscar.kabaoapp.Common.Constants;
import com.oscar.kabaoapp.Common.CreditCardNoRule;
import com.oscar.kabaoapp.Common.CreditCardNoRuleBuilder;
import com.oscar.kabaoapp.Common.TextValidator;
import com.oscar.kabaoapp.Repositories.CreditCardRepository;
import com.oscar.kabaoapp.dataObject.CreditCardTemplate;
import com.oscar.kabaoapp.dataObject.Creditcard;

import org.w3c.dom.Text;

import java.lang.reflect.Field;
import java.time.Month;
import java.util.Calendar;

// Edit new card.
public class EditCardActivity extends AppCompatActivity {
    private EditText cardNickname;
    private EditText cardNo;
    private EditText expiredOn;
    private EditText cvv;
    private EditText stmtDate;
    private EditText creditLine;
    private TextView cardFeature;

    private CreditCardTemplate cardTemplate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_card);

        Intent intent = getIntent();
        cardTemplate = intent.getParcelableExtra(AddCardActivity.CardTemplate);

        setupActionBar();
        setupCardNumber();
        setupExpireDate();
        setupCreditLine();
        setupCardNickname();
        setupStmtDate();
        setupCVV();
        setupSaveButton();
        setupCancelButton();
        setupCardNotes();
    }

    private void setupCardNotes()
    {
        cardFeature = findViewById(R.id.textedit_card_features);
        cardFeature.setText(cardTemplate.getCardFeatures());
    }

    private void setupCardNickname()
    {
        cardNickname = findViewById(R.id.card_alias);
        cardNickname.setText(cardTemplate.getProductName());

        cardNickname.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                TextValidator.IsCardNicknameValid(cardNickname);
            }
        });

    }

    private void setupCreditLine()
    {
        creditLine = findViewById(R.id.credit_line);
        creditLine.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }
            @Override
            public void afterTextChanged(Editable s) {
                TextValidator.IsCreditLineValid(creditLine);
            }
        });
    }

    private void setupExpireDate()
    {
        expiredOn = findViewById(R.id.expire_date);
        expiredOn.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(hasFocus) {
                    setupCustomMonthYearPicker(v);
                }
            }
        });
    }

    private void setupCustomMonthYearPicker(View v)
    {
        final Calendar c = Calendar.getInstance();
        int y = c.get(Calendar.YEAR);

        final Dialog dialog = new Dialog(v.getContext());
        dialog.setContentView(R.layout.year_month_picker);
        dialog.setCanceledOnTouchOutside(false);

        final NumberPicker monthPicker = dialog.findViewById(R.id.month_picker);
        monthPicker.setMinValue(0);
        monthPicker.setMaxValue(Constants.MONTH.length - 1 );
        monthPicker.setDisplayedValues(Constants.MONTH);
        monthPicker.setWrapSelectorWheel(false);
        monthPicker.setDescendantFocusability(NumberPicker.FOCUS_BLOCK_DESCENDANTS);

        final NumberPicker yearPicker = dialog.findViewById(R.id.year_picker);
        yearPicker.setMinValue(y);
        yearPicker.setMaxValue(y + 12);
        yearPicker.setDescendantFocusability(NumberPicker.FOCUS_BLOCK_DESCENDANTS);
        yearPicker.setWrapSelectorWheel(false);

        Button cancel = dialog.findViewById(R.id.month_year_picker_CancelBtn);
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
                expiredOn.clearFocus();
            }
        });

        Button set = dialog.findViewById(R.id.month_year_picker_SetBtn);
        set.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                expiredOn.setText(monthPicker.getValue() + 1 + "/" + yearPicker.getValue() % 100);
                expiredOn.clearFocus();
                dialog.dismiss();
            }
        });

        dialog.show();
    }


    private void setupStmtDate()
    {
        stmtDate = findViewById(R.id.statement_date);
        stmtDate.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(hasFocus)
                {
                    setupCustomDayOfMonthPicker(v);
                }
            }
        });
    }


    private void setupCustomDayOfMonthPicker(View v)
    {
        final Dialog dialog = new Dialog(v.getContext());
        dialog.setContentView(R.layout.dayofmonth_picker);
        dialog.setCanceledOnTouchOutside(false);

        final NumberPicker dayofmonthPicker = dialog.findViewById(R.id.dayofmonth_picker);
        dayofmonthPicker.setMinValue(1);
        dayofmonthPicker.setMaxValue(31);
        dayofmonthPicker.setWrapSelectorWheel(false);
        dayofmonthPicker.setDescendantFocusability(NumberPicker.FOCUS_BLOCK_DESCENDANTS);
        Button cancel = dialog.findViewById(R.id.dayofmonth_picker_CancelBtn);
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
                stmtDate.clearFocus();
            }
        });

        Button set = dialog.findViewById(R.id.dayofmonth_picker_SetBtn);
        set.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stmtDate.setText(String.valueOf(dayofmonthPicker.getValue()));
                stmtDate.clearFocus();
                dialog.dismiss();
            }
        });

        dialog.show();
    }

    private void setupCVV()
    {
        cvv = findViewById(R.id.ccv_code);

        cvv.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                TextValidator.IsCVVValid(cvv);
            }
        });
    }

    private void setupCancelButton()
    {
        TextView cancel = findViewById(R.id.actionbar_item_addcard_cancel);
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }

    private void setupSaveButton()
    {
        final TextView save = findViewById(R.id.actionbar_item_addcard_save);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Creditcard card = CreateCreditCard();

                if(!CreditCardNoRuleBuilder.IsValidLength(card))
                {
                    cardNo.setError("Hey, check your card number again!");
                    return;
                }

                if(!CreditCardNoRuleBuilder.IsValidStartNum(card))
                {
                    cardNo.setError("Hey, check your card number again!");
                    return;
                }

                if(!CreditCardNoRuleBuilder.IsValidCardNoLuhnAlgo(card))
                {
                    cardNo.setError("Hey, check your card number again!");
                    return;
                }

                CreditCardRepository creditCardRepository = new CreditCardRepository(getApplication());
                creditCardRepository.InsertCard(card);
                finish();
            }
        });

    }

    private void setupCardNumber()
    {
        cardNo = findViewById(R.id.card_number);
        cardNo.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                TextValidator.IsCardNoValid(cardNo);
            }
        });
    }

    private String addSpaceInCardNumber(String cardNo)
    {
        String cardNumberNoSpace = cardNo.replaceAll("\\s", "");

        int part = cardNumberNoSpace.length()/4;

        String cardNumberAjusted = "";

        for (int i = 0; i < part; i++)
        {
            int endIndex = Math.min((i+1)*4, cardNumberNoSpace.length() - 1);
            cardNumberAjusted += cardNumberNoSpace.substring(i * 4, endIndex);
        }

        return cardNumberAjusted;
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
        card.setCardNickname(cardNickname.getText().toString().trim());
        card.setProductName(cardTemplate.getProductName());
        card.setCardImageRId(cardTemplate.getCardImageRId());
        card.setPaymentType(cardTemplate.getPaymentType());
        card.setPaymentTypeLogoRId(cardTemplate.getPaymentTypeLogoRId());
        card.setBankName(cardTemplate.getBankName());
        card.setCardFeatures(cardFeature.getText().toString().trim());
        card.setCardNo(cardNo.getText().toString().trim());
        card.setStmtDate(stmtDate.getText().toString());
        card.setCrediLine(creditLine.getText().toString().trim());
        card.setCvv(cvv.getText().toString().trim());
        card.setExpiredOn(expiredOn.getText().toString());

        return card;
    }

}
