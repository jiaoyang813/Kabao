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
            add(GetBankProduct(view, BankName.Chase, R.drawable.chase_logo));
            add(GetBankProduct(view, BankName.AmericanExpress, R.drawable.amex_logo));
            add(GetBankProduct(view, BankName.CITI, R.drawable.citi_logo));
            add(GetBankProduct(view, BankName.Discover, R.drawable.discover_logo));
            add(GetBankProduct(view, BankName.Barclaycard, R.drawable.barclaycard_logo));
        }};
    }


    private static CreditcardCompany GetBankProduct(View view, BankName bankName, int logoRid)
    {
        CreditcardCompany company = new CreditcardCompany(bankName);
        company.setCompanyLogoName(ResourceHelper.GetResName(logoRid, view));
        company.AddProducts(CreditCardStaticDataProvider.GetCompanyCards(company.getCompanyName(), view));
        return company;
    }


}
