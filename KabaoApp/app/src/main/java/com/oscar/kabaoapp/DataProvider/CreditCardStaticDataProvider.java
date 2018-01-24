package com.oscar.kabaoapp.DataProvider;

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
    private static int CardID = 1;

    public static ArrayList<CreditCardTemplate> AllCreditCards = new ArrayList<CreditCardTemplate>(){{
        add(GetChaseFreedomTemplate());
        add(GetChaseSapphirePreferredTemplate());
        add(GetCitiDoubleCashTemplate());
        add(GetAmexBlueCashEverydayTemplate());
    }};

    public static ArrayList<CreditCardTemplate> GetCompanyCards(BankName bankName)
    {
        ArrayList<CreditCardTemplate> companyCards = new ArrayList<>();

        for (CreditCardTemplate card : AllCreditCards) {
            if(card.getBankName() == bankName)
            {
                companyCards.add(card);
            }
        }
        return companyCards;
    }

    private static CreditCardTemplate GetChaseFreedomTemplate()
    {
        CreditCardTemplate cardTemplate = new CreditCardTemplate();
        //cardTemplate.setId(CardID++);
        cardTemplate.setBankName(BankName.Chase);
        cardTemplate.setProductName("Chase Freedom");
        cardTemplate.setPaymentType(PaymentType.Visa);
        cardTemplate.setPaymentTypeLogoRId(R.drawable.new_visa_big);
        cardTemplate.setCardImageRId(R.drawable.freedom_card);
        cardTemplate.setCardFeatures("5% ultimate rewards points in bonus categories each quarter(up to 1500)\n " +
                "No annual fee\n");
        return cardTemplate;
    }

    private static CreditCardTemplate GetChaseSapphirePreferredTemplate()
    {
        CreditCardTemplate cardTemplate = new CreditCardTemplate();
        //cardTemplate.setId(CardID++);
        cardTemplate.setBankName(BankName.Chase);
        cardTemplate.setProductName("Chase Sapphire Preferred");
        cardTemplate.setPaymentType(PaymentType.Visa);
        cardTemplate.setPaymentTypeLogoRId(R.drawable.new_visa_big);
        cardTemplate.setCardImageRId(R.drawable.sapphire_preferred_card);
        cardTemplate.setCardFeatures("2% ultimate rewards points in dining and travel\n " +
                "95 annual fee( first 12 month waived)\n");
        return cardTemplate;
    }


    private static CreditCardTemplate GetCitiDoubleCashTemplate()
    {
        CreditCardTemplate cardTemplate = new CreditCardTemplate();
        //cardTemplate.setId(CardID++);
        cardTemplate.setBankName(BankName.CITI);
        cardTemplate.setProductName("CITI Double Cash");
        cardTemplate.setPaymentType(PaymentType.MasterCard);
        cardTemplate.setPaymentTypeLogoRId(R.drawable.mastercard_logo_5);
        cardTemplate.setCardImageRId(R.drawable.city_doublecash);
        cardTemplate.setCardFeatures("Unlimited 2% cash back with no caps and no category restrictions\n " +
                "No annual fee\n City Price Rewind");
        return cardTemplate;
    }

    private static CreditCardTemplate GetAmexBlueCashEverydayTemplate()
    {
        CreditCardTemplate cardTemplate = new CreditCardTemplate();
        //cardTemplate.setId(CardID++);
        cardTemplate.setBankName(BankName.AmericanExpress);
        cardTemplate.setProductName("Amex Blue Cash Everyday");
        cardTemplate.setPaymentType(PaymentType.AmericanExpress);
        cardTemplate.setPaymentTypeLogoRId(R.drawable.americanexpresslogo);
        cardTemplate.setCardImageRId(R.drawable.amex_bluecasheveryday);
        cardTemplate.setCardFeatures("3% cash back at U.S. supermarkets, on up to $6,000 per year in purchases (then 1%)\n " +
                "2% cashback at U.S. gas stations & select U.S. department stores\n" +
                "1% cashback on other purchases\n" +
                "No annual fee\n");
        return cardTemplate;
    }
}
