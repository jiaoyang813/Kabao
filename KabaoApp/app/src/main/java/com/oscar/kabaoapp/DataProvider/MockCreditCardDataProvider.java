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
        existingCards.add(new Creditcard(1, "Chase Freedom", "", 1));
        existingCards.add(new Creditcard(2, "Chase Sapphire Preferred", "", 2));
        existingCards.add(new Creditcard(3, "Hyatt", "", 3));
        existingCards.add(new Creditcard(4, "IHG", "", 4));
        existingCards.add(new Creditcard(5, "Chase Ink", "", 5));
        existingCards.add(new Creditcard(6, "Chase Freedom Unlimited", "", 6));
        existingCards.add(new Creditcard(1,"Amex Blue Cash", "", 1));
        existingCards.add(new Creditcard(2,"Amex Blue Cash Preferred", "", 2));
        existingCards.add(new Creditcard(3,"Amex Delta Gold", "", 3));
        existingCards.add(new Creditcard(4,"Amex Blue Cash Preferred", "", 4));
        existingCards.add(new Creditcard(5,"Amex Blue Cash", "", 5));
        existingCards.add(new Creditcard(6,"Amex Blue Cash Preferred", "", 6));
        existingCards.add(new Creditcard(7,"Amex Blue Cash", "", 7));
        existingCards.add(new Creditcard(8,"Amex Blue Cash Preferred", "", 8));
        existingCards.add(new Creditcard(9,"Amex Blue Cash", "", 9));
        return existingCards;
    }

    public ArrayList<CreditcardCompany> getAllCompanies()
    {
        ArrayList<CreditcardCompany> creditCardCompanies = new ArrayList<>();

        CreditcardCompany chase = new CreditcardCompany(1, "Chase");
        chase.AddProduct(new Creditcard(1, "Chase Freedom", "", 1));
        chase.AddProduct(new Creditcard(2, "Chase Sapphire Preferred", "", 1));

        CreditcardCompany amex = new CreditcardCompany(2, "American Express");
        amex.AddProduct(new Creditcard(1,"Amex Blue Cash", "", 1));
        amex.AddProduct(new Creditcard(2,"Amex Blue Cash Preferred", "", 1));

        creditCardCompanies.add(chase);
        creditCardCompanies.add(amex);

        return creditCardCompanies;
    }
}
