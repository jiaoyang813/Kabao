package com.oscar.kabaoapp.dataObject;

import java.util.ArrayList;

/**
 * Created by oscar on 12/9/17.
 */

public class CreditcardCompany {

    private ArrayList<Creditcard> creditcardProducts;

    private int companyId;

    private String companyName;

    public CreditcardCompany(int companyId, String companyName)
    {
        this.companyId = companyId;
        this.companyName = companyName;
        creditcardProducts = new ArrayList<>();
    }

    public ArrayList<Creditcard> GetCreditcardProducts()
    {
        return creditcardProducts;
    }

    public int GetCompanyId()
    {
        return companyId;
    }

    public String GetCompanyName()
    {
        return companyName;
    }

    public void AddProduct(Creditcard creditcard)
    {
        creditcardProducts.add(creditcard);
    }

}
