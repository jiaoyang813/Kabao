package com.oscar.kabaoapp.DataProvider;

import android.content.res.Resources;
import android.view.View;

import com.oscar.kabaoapp.Common.ResourceHelper;
import com.oscar.kabaoapp.R;
import com.oscar.kabaoapp.dataObject.BankName;
import com.oscar.kabaoapp.dataObject.CreditCardTemplate;
import com.oscar.kabaoapp.dataObject.CreditcardCompany;

import java.util.ArrayList;

/**
 * Created by Oscar on 12/29/2017.
 */

public class CompanyStaticDataProvider {

    public static ArrayList<CreditcardCompany> GetAllCompanies(final View view) {

        return new ArrayList<CreditcardCompany>() {{
            add(GetChaseBank(view));
            add(GetAmex(view));
            add(GetCiti(view));
        }};
    }

    private static CreditcardCompany GetChaseBank(View view)
    {
        CreditcardCompany company = new CreditcardCompany(BankName.Chase);
        company.setCompanyLogoName(ResourceHelper.GetResName(R.drawable.chase_logo, view));
        company.AddProducts(CreditCardStaticDataProvider.GetCompanyCards(company.getCompanyName(), view));
        return company;
    }

    private static CreditcardCompany GetAmex(View view)
    {
        CreditcardCompany company = new CreditcardCompany(BankName.AmericanExpress);
        company.setCompanyLogoName(ResourceHelper.GetResName(R.drawable.amex_logo, view));
        company.AddProducts(CreditCardStaticDataProvider.GetCompanyCards(company.getCompanyName(), view));
        return company;
    }

    private static CreditcardCompany GetCiti(View view)
    {
        CreditcardCompany company = new CreditcardCompany(BankName.CITI);
        company.setCompanyLogoName(ResourceHelper.GetResName(R.drawable.citi_logo, view));
        company.AddProducts(CreditCardStaticDataProvider.GetCompanyCards(company.getCompanyName(), view));
        return company;
    }
}
