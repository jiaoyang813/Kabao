package com.oscar.kabaoapp.DataProvider;

import com.oscar.kabaoapp.dataObject.Creditcard;
import com.oscar.kabaoapp.dataObject.CreditcardCompany;
import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by oscar on 12/10/17.
 */

public class MockCreditCardDataProvider {
    public ArrayList<Creditcard> getExistingCards()
    {
        ArrayList<Creditcard> existingCards = new ArrayList<>();
        existingCards.add(new Creditcard(1,"Chase Freedom", "", 1));
        existingCards.add(new Creditcard(2,"Chase Sapphire Preferred", "", 2));
        existingCards.add(new Creditcard(3,"Hyatt is just a very very very long long name to test the width", "", 3));
        existingCards.add(new Creditcard(4,"IHG", "", 4));
        existingCards.add(new Creditcard(5,"Chase Ink", "", 5));
        existingCards.add(new Creditcard(6,"Chase Freedom Unlimited", "", 6));
        existingCards.add(new Creditcard(1,"Amex Blue Cash", "", 1));
        existingCards.add(new Creditcard(2,"Amex Blue Cash Preferred", "", 2));
        existingCards.add(new Creditcard(3,"Amex Delta Gold", "", 3));
        existingCards.add(new Creditcard(4,"Amex Delta Platinum", "", 4));
        existingCards.add(new Creditcard(5,"SPG", "", 5));
        existingCards.add(new Creditcard(6,"Hilton", "", 6));
        existingCards.add(new Creditcard(7,"Amex Blue Cash Everyday", "", 7));
        existingCards.add(new Creditcard(8,"Amex Blue Cash Everyday Preferred", "", 8));
        return existingCards;
    }

    public ArrayList<CreditcardCompany> getAllCompanies()
    {
        ArrayList<CreditcardCompany> creditCardCompanies = new ArrayList<>();

        CreditcardCompany chase = new CreditcardCompany(1, "Chase");
        chase.AddProduct(new Creditcard(1, "Chase Freedom", "", 1));
        chase.AddProduct(new Creditcard(2, "Chase Sapphire Preferred", "", 2));
        chase.AddProduct(new Creditcard(3, "Hyatt", "", 3));
        chase.AddProduct(new Creditcard(4, "IHG", "", 4));
        chase.AddProduct(new Creditcard(5, "Chase Ink", "", 5));
        CreditcardCompany amex = new CreditcardCompany(2, "American Express");
        amex.AddProduct(new Creditcard(1,"Amex Blue Cash", "", 1));
        amex.AddProduct(new Creditcard(2,"Amex Blue Cash Preferred", "", 2));
        amex.AddProduct(new Creditcard(3,"Amex Delta Gold", "", 3));
        amex.AddProduct(new Creditcard(4,"Amex Delta Platinum", "", 4));
        amex.AddProduct(new Creditcard(5,"SPG", "", 5));
        amex.AddProduct(new Creditcard(6,"Hilton", "", 6));
        amex.AddProduct(new Creditcard(7,"Amex Blue Cash Everyday", "", 7));
        amex.AddProduct(new Creditcard(8,"Amex Blue Cash Everyday Preferred", "", 8));

        creditCardCompanies.add(chase);
        creditCardCompanies.add(amex);
        return creditCardCompanies;
    }
}
