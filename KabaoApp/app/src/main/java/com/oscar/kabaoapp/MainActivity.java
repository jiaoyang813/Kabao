package com.oscar.kabaoapp;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.oscar.kabaoapp.Common.AdHelper;
import com.oscar.kabaoapp.Database.AppDatabase;
import com.oscar.kabaoapp.Database.KabaoDatabase;
import com.oscar.kabaoapp.OnClickListener.AddNewCardOnClickListener;
import com.oscar.kabaoapp.ViewModel.AddedCreditCardViewModel;
import com.oscar.kabaoapp.dataObject.BankName;
import com.oscar.kabaoapp.dataObject.Creditcard;
import com.oscar.kabaoapp.dataObject.PaymentType;
import com.oscar.kabaoapp.dataObject.User;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    AddedCreditCardViewModel addedCreditCardViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        View currentView = findViewById(android.R.id.content);
        AdHelper.setupAds(currentView, R.id.adView_main);
        setupActionBar();

        pushFragment(new MycardFragment());
        addedCreditCardViewModel = ViewModelProviders.of(this).get(AddedCreditCardViewModel.class);
        addedCreditCardViewModel.getAllCards().observe(this, new Observer<List<Creditcard>>() {
            @Override
            public void onChanged(@Nullable List<Creditcard> creditcards) {
                MycardFragment mycardFragment = MycardFragment.newInstance(new ArrayList(creditcards));
                pushFragment(mycardFragment);
            }
        });

    }

    private void setupActionBar()
    {
        Toolbar myToolbar = findViewById(R.id.action_bar_main);
        setSupportActionBar(myToolbar);

        Toolbar.LayoutParams lp1 = new Toolbar.LayoutParams(Toolbar.LayoutParams.MATCH_PARENT, Toolbar.LayoutParams.MATCH_PARENT);
        View customNav = LayoutInflater.from(this).inflate(R.layout.actionbar_item_main, null);

        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setDisplayShowCustomEnabled(true);
        getSupportActionBar().setCustomView(customNav, lp1);

        // action bar menu option click listener
        TextView addCard = findViewById(R.id.actionbar_main_add);
        addCard.setOnClickListener(new AddNewCardOnClickListener());

    }


   /* @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.action_bar_managecard, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_add_card:
                Intent intent = new Intent(this, AddCardActivity.class);
                startActivityForResult(intent, AddCardCode);
                return true;
            default:
                return super.onOptionsItemSelected(item);

        }
    }*/

  /*  @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        super.onActivityResult(requestCode, resultCode, data);
        if ((requestCode == 10000) && (resultCode == Activity.RESULT_OK))
            // recreate your fragment here
        {
            pushFragment(new MycardFragment());
        }
    }*/

  /*  private void setupNavigationView() {
        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottom_navigation);
        if (bottomNavigationView != null) {

            // Select first menu item by default and show Fragment accordingly.
            Menu menu = bottomNavigationView.getMenu();
            selectFragment(menu.getItem(0));

            // Set action to perform when any menu-item is selected.
            bottomNavigationView.setOnNavigationItemSelectedListener(
                    new BottomNavigationView.OnNavigationItemSelectedListener() {
                        @Override
                        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                            selectFragment(item);
                            return false;
                        }
                    });
        }
    }*/

    /**
     * Perform action when any item is selected.
     *
     * @param item Item that is selected.
     */
    /*protected void selectFragment(MenuItem item) {

        item.setChecked(true);

        switch (item.getItemId()) {
            case R.id.action_home:
                // Action to perform when Home Menu item is selected.
                pushFragment(new HomeFragment());
                break;
            case R.id.action_mycard:
                // Action to perform when Bag Menu item is selected.
                pushFragment(new MycardFragment());
                break;
            case R.id.action_expense:
                // Action to perform when Account Menu item is selected.
                pushFragment(new ExpenseFragment());
                break;
        }
    }*/

    /**
     * Method to push any fragment into given id.
     *
     * @param fragment An instance of Fragment to show into the given id.
     */
    protected void pushFragment(Fragment fragment) {
        if (fragment == null)
            return;

        android.support.v4.app.FragmentManager fragmentManager = getSupportFragmentManager();
        if (fragmentManager != null) {
            android.support.v4.app.FragmentTransaction ft = fragmentManager.beginTransaction();
            if (ft != null) {
                ft.replace(R.id.main_fragment_container, fragment);
                ft.commit();
            }
        }
    }
}
