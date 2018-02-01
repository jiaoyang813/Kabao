package com.oscar.kabaoapp.DataProvider;

import android.content.res.Resources;
import android.view.View;

import com.oscar.kabaoapp.Common.ResourceHelper;
import com.oscar.kabaoapp.R;
import com.oscar.kabaoapp.dataObject.BankName;
import com.oscar.kabaoapp.dataObject.CreditCardTemplate;
import com.oscar.kabaoapp.dataObject.PaymentType;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Oscar on 12/29/2017.
 */

public class CreditCardStaticDataProvider {

    public static ArrayList<CreditCardTemplate> GetAllCreditCards(final View view){
        return new ArrayList<CreditCardTemplate>(){{
            add(GetChaseFreedomTemplate(view));
            add(GetChaseSapphirePreferredTemplate(view));
            add(GetCitiDoubleCashTemplate(view));
            add(GetAmexBlueCashEverydayTemplate(view));
        }};
    }

    public static ArrayList<CreditCardTemplate> GetCompanyCards(BankName bankName, View view)
    {
        ArrayList<CreditCardTemplate> companyCards = new ArrayList<>();

        for (CreditCardTemplate card : GetAllCreditCards(view)) {
            if(card.getBankName() == bankName)
            {
                companyCards.add(card);
            }
        }
        return companyCards;
    }

    private static CreditCardTemplate GetChaseFreedomTemplate(View view)
    {
        CreditCardTemplate cardTemplate = new CreditCardTemplate();
        cardTemplate.setBankName(BankName.Chase);
        cardTemplate.setProductName("Chase Freedom");
        cardTemplate.setCardIssuer(PaymentType.Visa);
        cardTemplate.setCardIssuerLogoRId(R.drawable.new_visa_big, view);
        cardTemplate.setCardImageRId( R.drawable.freedom_card, view);
        cardTemplate.setCardFeatures("5% ultimate rewards points in bonus categories each quarter(up to 1500)\n " +
                "No annual fee\n");
        return cardTemplate;
    }

    private static CreditCardTemplate GetChaseSapphirePreferredTemplate(View view)
    {
        CreditCardTemplate cardTemplate = new CreditCardTemplate();
        cardTemplate.setBankName(BankName.Chase);
        cardTemplate.setProductName("Chase Sapphire Preferred");
        cardTemplate.setCardIssuer(PaymentType.Visa);
        cardTemplate.setCardIssuerLogoRId( R.drawable.new_visa_big, view);
        cardTemplate.setCardImageRId( R.drawable.sapphire_preferred_card, view);
        cardTemplate.setCardFeatures(
                "2% ultimate rewards points in dining and travel\n " +
                "95 annual fee( first 12 month waived)\n");
        return cardTemplate;
    }


    private static CreditCardTemplate GetChaseFreedomUnlimitedTemplate(View view)
    {
        CreditCardTemplate cardTemplate = new CreditCardTemplate();
        cardTemplate.setBankName(BankName.Chase);
        cardTemplate.setProductName("Chase Freedom Unlimited");
        cardTemplate.setCardIssuer(PaymentType.Visa);
        cardTemplate.setCardIssuerLogoRId( R.drawable.new_visa_big, view);
        cardTemplate.setCardImageRId( R.drawable.sapphire_preferred_card, view);
        cardTemplate.setCardFeatures(
                "Earn unlimited 1.5% cash back\n " + "No annual fee\n");

        return cardTemplate;
    }

    private static CreditCardTemplate GetCitiDoubleCashTemplate(View view)
    {
        CreditCardTemplate cardTemplate = new CreditCardTemplate();
        cardTemplate.setBankName(BankName.CITI);
        cardTemplate.setProductName("CITI Double Cash");
        cardTemplate.setCardIssuer(PaymentType.MasterCard);
        cardTemplate.setCardIssuerLogoRId(R.drawable.mastercard_logo_5, view);
        cardTemplate.setCardImageRId( R.drawable.city_doublecash, view);
        cardTemplate.setCardFeatures(
                "Unlimited 2% cash back with no caps and no category restrictions\n " +
                "No annual fee\n City Price Rewind");
        return cardTemplate;
    }

    private static CreditCardTemplate GetAmexBlueCashEverydayTemplate(View view)
    {
        CreditCardTemplate cardTemplate = new CreditCardTemplate();
        cardTemplate.setBankName(BankName.AmericanExpress);
        cardTemplate.setProductName("Amex Blue Cash Everyday");
        cardTemplate.setCardIssuer(PaymentType.AmericanExpress);
        cardTemplate.setCardIssuerLogoRId( R.drawable.americanexpresslogo, view);
        cardTemplate.setCardImageRId(R.drawable.amex_bluecasheveryday, view);
        cardTemplate.setCardFeatures(
                "3% cash back at U.S. supermarkets, on up to $6,000 per year in purchases (then 1%)\n " +
                "2% cashback at U.S. gas stations & select U.S. department stores\n" +
                "1% cashback on other purchases\n" +
                "No annual fee\n");
        return cardTemplate;
    }
}
