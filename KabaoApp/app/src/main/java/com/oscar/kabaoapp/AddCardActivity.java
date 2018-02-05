package com.oscar.kabaoapp;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.Toast;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;
import com.oscar.kabaoapp.Common.AdHelper;
import com.oscar.kabaoapp.DataProvider.CompanyStaticDataProvider;
import com.oscar.kabaoapp.DataProvider.MockCreditCardDataProvider;
import com.oscar.kabaoapp.dataObject.BankName;
import com.oscar.kabaoapp.dataObject.CreditCardTemplate;
import com.oscar.kabaoapp.dataObject.Creditcard;
import com.oscar.kabaoapp.dataObject.CreditcardCompany;
import com.oscar.kabaoapp.listadapter.AddCardListAdapter;

import java.util.ArrayList;

public class AddCardActivity extends AppCompatActivity {

    ExpandableListView productListView;
    AddCardListAdapter cardListAdapter;
    ArrayList<CreditcardCompany> creditCardCompanies;

    private InterstitialAd mInterstitialAd;

    public static final String ProductName = "com.oscar.kabaoapp.AddCard.ProductName";
    public static final String CardImageRId = "com.oscar.kabaoapp.AddCard.CardImageRId";
    public static final String PaymentType = "com.oscar.kabaoapp.AddCard.PaymentType";
    public static final String PaymentTypeLogoRId = "com.oscar.kabaoapp.AddCard.PaymentTypeLogoRId";
    public static final String BankName = "com.oscar.kabaoapp.AddCard.BankName";
    public static final String CardFeatures = "com.oscar.kabaoapp.AddCard.CardFeatures";

    public static final String CardTemplate = "com.oscar.kabaoapp.AddCard.CardTemplate";

    private int lastExpandedPosition = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_card);
        setupInterstitialAds();
        productListView = findViewById(R.id.available_card_listview);
        loadStaticData(productListView);
        cardListAdapter = new AddCardListAdapter(AddCardActivity.this, creditCardCompanies);
        productListView.setAdapter(cardListAdapter);

        productListView.setOnChildClickListener(myListItemClicked);
        productListView.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {
            @Override
            public void onGroupExpand(int groupPosition) {
                if (lastExpandedPosition != -1
                        && groupPosition != lastExpandedPosition) {
                    productListView.collapseGroup(lastExpandedPosition);
                }
                lastExpandedPosition = groupPosition;
            }
        });

        View currentView = findViewById(android.R.id.content);

        AdHelper.setupAds(currentView, R.id.addView_addcard);
    }


    private void setupInterstitialAds()
    {
        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId("ca-app-pub-3940256099942544/1033173712");
        mInterstitialAd.loadAd(new AdRequest.Builder().build());
        mInterstitialAd.setAdListener(new AdListener() {
            @Override
            public void onAdLoaded() {
                // Code to be executed when an ad finishes loading.
            }

            @Override
            public void onAdFailedToLoad(int errorCode) {
                // Code to be executed when an ad request fails.
            }

            @Override
            public void onAdOpened() {
                // Code to be executed when the ad is displayed.
            }

            @Override
            public void onAdLeftApplication() {
                // Code to be executed when the user has left the app.
            }

            @Override
            public void onAdClosed() {
                // Load the next interstitial.
                mInterstitialAd.loadAd(new AdRequest.Builder().build());
            }
        });
    }



    private ExpandableListView.OnChildClickListener myListItemClicked =
            new ExpandableListView.OnChildClickListener() {

        public boolean onChildClick(ExpandableListView parent, View v,
                                    int groupPosition, int childPosition, long id) {

            if (mInterstitialAd.isLoaded()) {
                mInterstitialAd.show();
            } else {
                Log.d("TAG", "The interstitial wasn't loaded yet.");
            }

            //get the group header
            CreditcardCompany company = creditCardCompanies.get(groupPosition);
            //get the child info
            CreditCardTemplate creditcard =  company.GetCreditcardProducts().get(childPosition);
            Intent intent = new Intent(AddCardActivity.this, EditCardActivity.class);
            intent.putExtra(CardTemplate, creditcard);

            startActivity(intent);
            setResult(Activity.RESULT_OK);
            finish();
            return false;
        }
    };



    private void collapseAll() {
        int count = cardListAdapter.getGroupCount();
        for (int i = 0; i < count; i++){
            productListView.collapseGroup(i);
        }
    }
    private void expandAll() {
        int count = cardListAdapter.getGroupCount();
        for (int i = 0; i < count; i++){
            productListView.expandGroup(i);
        }
    }

   /* private void loadFakeData()
    {
        MockCreditCardDataProvider dataProvider = new MockCreditCardDataProvider();
        creditCardCompanies = dataProvider.getAllCompanies();
    }*/

    private void loadStaticData(View view)
    {
        creditCardCompanies = CompanyStaticDataProvider.GetAllCompanies(view);
    }
}
