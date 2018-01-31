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
        Resources rs = view.getResources();
        String name = rs.getResourceEntryName(R.drawable.chasebank);

        company.setCompanyLogoName(ResourceHelper.GetResName(R.drawable.chasebank, view));
        company.AddProducts(CreditCardStaticDataProvider.GetCompanyCards(company.getCompanyName(), view));
        return company;
    }

    private static CreditcardCompany GetAmex(View view)
    {
        CreditcardCompany company = new CreditcardCompany(BankName.AmericanExpress);
        company.setCompanyLogoName(ResourceHelper.GetResName(R.drawable.americanexpresslogo, view));
        company.AddProducts(CreditCardStaticDataProvider.GetCompanyCards(company.getCompanyName(), view));
        return company;
    }

    private static CreditcardCompany GetCiti(View view)
    {
        CreditcardCompany company = new CreditcardCompany(BankName.CITI);
        company.setCompanyLogoName(ResourceHelper.GetResName(R.drawable.citibank, view));
        company.AddProducts(CreditCardStaticDataProvider.GetCompanyCards(company.getCompanyName(), view));
        return company;
    }
}
