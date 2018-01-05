package com.oscar.kabaoapp.DataProvider;

import com.oscar.kabaoapp.R;
import com.oscar.kabaoapp.dataObject.BankName;
import com.oscar.kabaoapp.dataObject.CreditCardTemplate;
import com.oscar.kabaoapp.dataObject.CreditcardCompany;

import java.util.ArrayList;

/**
 * Created by Oscar on 12/29/2017.
 */

public class CompanyStaticDataProvider {
    private static int CompanyID = 1;

    public static ArrayList<CreditcardCompany> AllCompanies = new ArrayList<CreditcardCompany>(){{
        add(GetChaseBank());
        add(GetAmex());
        add(GetCiti());
    }};


    private static CreditcardCompany GetChaseBank()
    {
        CreditcardCompany company = new CreditcardCompany(CompanyID++, BankName.Chase);
        company.setCompanyLogoRId(R.drawable.chasebank);
        company.AddProducts(CreditCardStaticDataProvider.GetCompanyCards(company.GetCompanyName()));
        return company;
    }

    private static CreditcardCompany GetAmex()
    {
        CreditcardCompany company = new CreditcardCompany(CompanyID++, BankName.AmericanExpress);
        company.setCompanyLogoRId(R.drawable.americanexpresslogo);
        company.AddProducts(CreditCardStaticDataProvider.GetCompanyCards(company.GetCompanyName()));
        return company;
    }

    private static CreditcardCompany GetCiti()
    {
        CreditcardCompany company = new CreditcardCompany(CompanyID++, BankName.CITI);
        company.setCompanyLogoRId(R.drawable.citibank);
        company.AddProducts(CreditCardStaticDataProvider.GetCompanyCards(company.GetCompanyName()));
        return company;
    }
}
