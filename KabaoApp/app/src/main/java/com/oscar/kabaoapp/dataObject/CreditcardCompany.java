package com.oscar.kabaoapp.dataObject;

import java.util.ArrayList;

/**
 * Created by oscar on 12/9/17.
 */

public class CreditcardCompany {

    private ArrayList<CreditCardTemplate> creditcardProducts;
    private int companyId;
    private int companyLogoRId;
    private BankName companyName;

    public CreditcardCompany(int companyId, BankName companyName)
    {
        this.companyId = companyId;
        this.companyName = companyName;
        creditcardProducts = new ArrayList<>();
    }

    public ArrayList<CreditCardTemplate> GetCreditcardProducts()
    {
        return creditcardProducts;
    }

    public int GetCompanyId()
    {
        return companyId;
    }

    public BankName GetCompanyName()
    {
        return companyName;
    }

    public int getCompanyLogoRId() {
        return companyLogoRId;
    }

    public void setCompanyLogoRId(int companyLogoRId) {
        this.companyLogoRId = companyLogoRId;
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
