package com.oscar.kabaoapp.dataObject;

import java.util.ArrayList;

/**
 * Created by oscar on 12/9/17.
 */

public class CreditcardCompany {

    private ArrayList<CreditCardTemplate> creditcardProducts;


    private String companyLogoName;
    private BankName companyName;

    public CreditcardCompany(BankName companyName)
    {
        this.companyName = companyName;
        creditcardProducts = new ArrayList<>();
    }

    public ArrayList<CreditCardTemplate> GetCreditcardProducts()
    {
        return creditcardProducts;
    }


    public String getCompanyLogoName() {
        return companyLogoName;
    }

    public void setCompanyLogoName(String companyLogoName) {
        this.companyLogoName = companyLogoName;
    }

    public BankName getCompanyName() {
        return companyName;
    }

    public void setCompanyName(BankName companyName) {
        this.companyName = companyName;
    }


    public void AddProduct(CreditCardTemplate creditcard)
    {
        creditcardProducts.add(creditcard);
    }

    public void AddProducts(ArrayList<CreditCardTemplate> creditcards)
    {
        for (CreditCardTemplate card: creditcards) {
            AddProduct(card);
        }
    }



}
