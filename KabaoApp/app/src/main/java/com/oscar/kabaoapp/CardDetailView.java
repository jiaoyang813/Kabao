package com.oscar.kabaoapp;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.oscar.kabaoapp.Common.AdHelper;
import com.oscar.kabaoapp.Common.DataFormatter;
import com.oscar.kabaoapp.Common.ImageUtility;
import com.oscar.kabaoapp.Common.StmtDateHelper;
import com.oscar.kabaoapp.OnClickListener.AddNewCardOnClickListener;
import com.oscar.kabaoapp.Repositories.CreditCardRepository;
import com.oscar.kabaoapp.ViewModel.AddedCreditCardViewModel;
import com.oscar.kabaoapp.dataObject.Creditcard;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class CardDetailView extends AppCompatActivity {

    public static final String CardDetail = "com.oscar.kabaoapp.CardId";

    private static final int REQUESTCODE_EDITCARD = 7001;

    private Creditcard card;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card_detail_view);
        setupActionBar();
        View currentView = findViewById(android.R.id.content);
        AdHelper.setupAds(currentView, R.id.adView_detailview);
        Intent intent = getIntent();
        int cardId = intent.getIntExtra(CardDetail, -1);

        if(cardId>0)
        {
            CreditCardRepository creditCardRepository = new CreditCardRepository(this.getApplication());
            creditCardRepository.getCardById(cardId).observe(this, new Observer<Creditcard>() {
                @Override
                public void onChanged(@Nullable Creditcard creditcard) {
                    card = creditcard;
                    setupUI();
                }
            });
        }

    }


    private void setupUI()
    {
        View v = this.findViewById(android.R.id.content);

        ImageView cardImage = findViewById(R.id.carddetail_cardimage);
        cardImage.setBackgroundResource(card.getCardImageRId(v));
        ImageUtility.scaleImage(128, 200, card.getCardImageRId(v), cardImage, this.findViewById(android.R.id.content));

        TextView cardname = findViewById(R.id.carddetailview_cardname);
        cardname.setText(card.getCardNickname());

        TextView cardno = findViewById(R.id.carddetailview_cardno);
        cardno.setText(DataFormatter.addSpaceInCardNumber(card.getCardNo()));

        TextView ccv = findViewById(R.id.carddetailview_ccv);
        ccv.setText(card.getCvv());

        TextView expiredDate = findViewById(R.id.carddetailview_expireddate);
        expiredDate.setText(card.getExpiredOn());

        TextView bank = findViewById(R.id.carddetailview_bank);
        bank.setText(card.getBankName().toString());

        TextView stmtdate = findViewById(R.id.carddetailview_stmtdate);
        int stmtDayOfMonth = Integer.valueOf(card.getStmtDate());
        stmtdate.setText(StmtDateHelper.GetStmtDate(stmtDayOfMonth));

        TextView creditline = findViewById(R.id.carddetailview_creditline);
        creditline.setText(card.getCreditLine());

        TextView features = findViewById(R.id.carddetailview_features);
        features.setText(card.getCardFeatures());
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
                Intent intent = new Intent(v.getContext(), EditExistingCardActivity.class);
                intent.putExtra(EditExistingCardActivity.ExistingCard, card);
                startActivityForResult(intent, REQUESTCODE_EDITCARD);
            }
        });


        TextView done = findViewById(R.id.actionbar_item_carddetailview_done);
        done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        if(requestCode == REQUESTCODE_EDITCARD)
        {
            if(resultCode == EditExistingCardActivity.RESULT_DELETE)
            {
                setupUI();
                finish();
            }

            if(resultCode == EditExistingCardActivity.RESULT_UPDATE)
            {

            }
        }

    }
}
