package com.oscar.kabaoapp;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.Toast;

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
    }


    private ExpandableListView.OnChildClickListener myListItemClicked =
            new ExpandableListView.OnChildClickListener() {

        public boolean onChildClick(ExpandableListView parent, View v,
                                    int groupPosition, int childPosition, long id) {
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
