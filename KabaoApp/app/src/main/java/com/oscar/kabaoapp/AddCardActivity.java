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
    public static final String BankName = "com.oscar.kabaoapp.AddCard.BankName";
    public static final String PaymentType = "com.oscar.kabaoapp.AddCard.PaymentType";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_card);
        //loadFakeData();
        loadStaticData();
        productListView = findViewById(R.id.available_card_listview);
        cardListAdapter = new AddCardListAdapter(AddCardActivity.this, creditCardCompanies);
        productListView.setAdapter(cardListAdapter);

        collapseAll();
        productListView.setOnGroupClickListener(myListGroupClicked);
        productListView.setOnChildClickListener(myListItemClicked);
    }

    //our group listener
    private ExpandableListView.OnGroupClickListener myListGroupClicked =
            new ExpandableListView.OnGroupClickListener() {

        public boolean onGroupClick(ExpandableListView parent, View v,
                                    int groupPosition, long id) {
            //get the group header
            CreditcardCompany company =  creditCardCompanies.get(groupPosition);
            //display it or do something with it
            /*Toast.makeText(getBaseContext(), "Child on Header " + company.GetCompanyName(),
                    Toast.LENGTH_LONG).show();
            if(productListView.isGroupExpanded(groupPosition))
            {
                productListView.collapseGroup(groupPosition);
            }else {
                productListView.expandGroup(groupPosition);
            }*/
            return false;
        }
    };


    private ExpandableListView.OnChildClickListener myListItemClicked =
            new ExpandableListView.OnChildClickListener() {

        public boolean onChildClick(ExpandableListView parent, View v,
                                    int groupPosition, int childPosition, long id) {
            //get the group header
            CreditcardCompany company = creditCardCompanies.get(groupPosition);
            //get the child info
            CreditCardTemplate creditcard =  company.GetCreditcardProducts().get(childPosition);
            Intent intent = new Intent(AddCardActivity.this, EditCardActivity.class);
            intent.putExtra(ProductName, creditcard.getProductName());
            intent.putExtra(BankName, creditcard.getBankName().toString());
            intent.putExtra(PaymentType, creditcard.getPaymentType().toString());

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

    private void loadStaticData()
    {
        creditCardCompanies = CompanyStaticDataProvider.AllCompanies;
    }
}
