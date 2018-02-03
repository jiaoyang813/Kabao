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
            add(GetChaseFreedomUnlimitedTemplate(view));
            add(GetChaseSlateTemplate(view));
            add(GetChaseSapphireReserveTemplate(view));
            add(GetChaseSouthwestPlusTemplate(view));
            add(GetChaseSouthwestPremierTemplate(view));
            add(GetChaseUnitedMileagePlusExplorerTemplate(view));
            add(GetChaseUnitedTravelBankTemplate(view));
            add(GetChaseUnitedClubTemplate(view));
            add(GetChaseBASignatureTemplate(view));
            add(GetChaseMarriottPremierTemplate(view));
            add(GetChaseDisneyPremierTemplate(view));
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
        cardTemplate.setCardIssuerLogoRId(R.drawable.visa_logo, view);
        cardTemplate.setCardImageRId( R.drawable.chase_freedom, view);
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
        cardTemplate.setCardIssuerLogoRId( R.drawable.visa_logo, view);
        cardTemplate.setCardImageRId( R.drawable.chase_sapphire_preferred, view);
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
        cardTemplate.setCardIssuerLogoRId( R.drawable.visa_logo, view);
        cardTemplate.setCardImageRId( R.drawable.chase_freedom_unlimited, view);
        cardTemplate.setCardFeatures(
                "Earn unlimited 1.5% cash back\n " + "No annual fee\n");

        return cardTemplate;
    }

    private static CreditCardTemplate GetChaseSlateTemplate(View view)
    {
        CreditCardTemplate cardTemplate = new CreditCardTemplate();
        cardTemplate.setBankName(BankName.Chase);
        cardTemplate.setProductName("Chase Slate");
        cardTemplate.setCardIssuer(PaymentType.Visa);
        cardTemplate.setCardIssuerLogoRId( R.drawable.visa_logo, view);
        cardTemplate.setCardImageRId( R.drawable.chase_slate, view);
        cardTemplate.setCardFeatures(
                "Pay no introductory balance transfer fee when you transfer " +
                        "a balance during the first 60 days your account is open\n "
                        + "Free monthly FICO Score\n" + "No annual fee\n" +  "No penalty APR");

        return cardTemplate;
    }

    private static CreditCardTemplate GetChaseSapphireReserveTemplate(View view)
    {
        CreditCardTemplate cardTemplate = new CreditCardTemplate();
        cardTemplate.setBankName(BankName.Chase);
        cardTemplate.setProductName("Chase Sapphire Reserve");
        cardTemplate.setCardIssuer(PaymentType.Visa);
        cardTemplate.setCardIssuerLogoRId( R.drawable.visa_logo, view);
        cardTemplate.setCardImageRId( R.drawable.chase_slate, view);
        cardTemplate.setCardFeatures(
                "50,000 bonus points after you spend $4,000 on purchases in the first 3 months from account opening\n" +
                        "$300 Annual Travel Credit\n "
                        + "3X Points on travel and dining worldwide\n"
                        + "50% more in travel redemption\n"
                        + "$450 annual fee; $75 for each authorized user");

        return cardTemplate;
    }

    private static CreditCardTemplate GetChaseSouthwestPlusTemplate(View view)
    {
        CreditCardTemplate cardTemplate = new CreditCardTemplate();
        cardTemplate.setBankName(BankName.Chase);
        cardTemplate.setProductName("Chase Southwest Rapid Rewards Plus");
        cardTemplate.setCardIssuer(PaymentType.Visa);
        cardTemplate.setCardIssuerLogoRId( R.drawable.visa_logo, view);
        cardTemplate.setCardImageRId( R.drawable.chase_swa_plus, view);
        cardTemplate.setCardFeatures(
                "50,000 bonus points after you spend $2,000 on purchases in the first 3 months from account opening\n"
                        + "2X points on Southwest® purchases\n "
                        + "3,000 bonus points after your cardmember anniversary\n"
                        + "Unlimited points that don't expire as long as your card account is open\n"
                        + "$69 annual fee applied to first billing statement");

        return cardTemplate;
    }

    private static CreditCardTemplate GetChaseSouthwestPremierTemplate(View view)
    {
        CreditCardTemplate cardTemplate = new CreditCardTemplate();
        cardTemplate.setBankName(BankName.Chase);
        cardTemplate.setProductName("Chase Southwest Rapid Rewards Premier");
        cardTemplate.setCardIssuer(PaymentType.Visa);
        cardTemplate.setCardIssuerLogoRId( R.drawable.visa_logo, view);
        cardTemplate.setCardImageRId( R.drawable.chase_swa_premier, view);
        cardTemplate.setCardFeatures(
                "50,000 bonus points after you spend $2,000 on purchases in the first 3 months from account opening\n"
                        + "2X points on Southwest® purchases\n "
                        + "6,000 bonus points after your cardmember anniversary\n"
                        + "Unlimited points that don't expire as long as your card account is open\n"
                        + "$99 annual fee applied to first billing statement");

        return cardTemplate;
    }

    private static CreditCardTemplate GetChaseUnitedMileagePlusExplorerTemplate(View view)
    {
        CreditCardTemplate cardTemplate = new CreditCardTemplate();
        cardTemplate.setBankName(BankName.Chase);
        cardTemplate.setProductName("Chase United MileagePlus Explorer");
        cardTemplate.setCardIssuer(PaymentType.Visa);
        cardTemplate.setCardIssuerLogoRId( R.drawable.visa_logo, view);
        cardTemplate.setCardImageRId( R.drawable.chase_united_mileageplus_explorer, view);
        cardTemplate.setCardFeatures(
                "40,000 bonus points after you spend $2,000 on purchases in the first 3 months from account opening\n"
                        + "2X miles on tickets purchased from United\n "
                        + "Free first checked bag – save up to $100 per roundtrip\n"
                        + "Priority boarding\n"
                        + "$0 intro annual fee for the first year, after that $95");

        return cardTemplate;
    }

    private static CreditCardTemplate GetChaseUnitedTravelBankTemplate(View view)
    {
        CreditCardTemplate cardTemplate = new CreditCardTemplate();
        cardTemplate.setBankName(BankName.Chase);
        cardTemplate.setProductName("Chase United TravelBank");
        cardTemplate.setCardIssuer(PaymentType.Visa);
        cardTemplate.setCardIssuerLogoRId( R.drawable.visa_logo, view);
        cardTemplate.setCardImageRId( R.drawable.chase_united_travelbank, view);
        cardTemplate.setCardFeatures(
                "$150 in United TravelBank cash after you spend $1,000 on purchases in the first 3 months from account opening\n"
                        + "Earn 2% on tickets purchased from United\n "
                        + "Earn 1.5% in TravelBank cash per $1 spent on all other purchases\n"
                        + "Enjoy 25% back as a statement credit on purchases of food and beverages onboard United-operated flights\n"
                        + "$1 in TravelBank cash = $1 when used toward the purchase of a ticket on flights operated by United and United Express\n"
                        + "No annual fee" );

        return cardTemplate;
    }

    private static CreditCardTemplate GetChaseUnitedClubTemplate(View view)
    {
        CreditCardTemplate cardTemplate = new CreditCardTemplate();
        cardTemplate.setBankName(BankName.Chase);
        cardTemplate.setProductName("Chase United MileagePlus Club");
        cardTemplate.setCardIssuer(PaymentType.Visa);
        cardTemplate.setCardIssuerLogoRId( R.drawable.visa_logo, view);
        cardTemplate.setCardImageRId( R.drawable.chase_united_club, view);
        cardTemplate.setCardFeatures(
                "50,000 bonus miles after you spend $3,000 on purchases in the first 3 months from account opening\n"
                        + "United Club membership – up to a $550 value per year\n "
                        + "Earn rewards faster with 1.5 miles per $1 spent on purchases\n"
                        + "Earn 2 miles per $1 spent on tickets purchased from United\n"
                        + "Free first and second checked bags – a savings of up to $240 per roundtrip\n"
                        + "$450 annual fee" );

        return cardTemplate;
    }

    private static CreditCardTemplate GetChaseBASignatureTemplate(View view)
    {
        CreditCardTemplate cardTemplate = new CreditCardTemplate();
        cardTemplate.setBankName(BankName.Chase);
        cardTemplate.setProductName("Chase British Airways Visa Signature");
        cardTemplate.setCardIssuer(PaymentType.Visa);
        cardTemplate.setCardIssuerLogoRId( R.drawable.visa_logo, view);
        cardTemplate.setCardImageRId( R.drawable.chase_ba_sig, view);
        cardTemplate.setCardFeatures(
                "Earn 50,000 bonus Avios after you spend $3,000 on purchases within the first 3 months of account opening" +
                        "Plus earn an additional 25,000 bonus Avios after you spend $10,000 on purchases within your first year of account opening"
                        + "Earn 3 Avios for every dollar spent on British Airways purchases\n "
                        + "Earn 1 Avios for every $1 spent on all other purchases\n"
                        + "Automatic enrollment in the Executive Club for new members\n"
                        + "$95 annual fee" );

        return cardTemplate;
    }

    private static CreditCardTemplate GetChaseMarriottPremierTemplate(View view)
    {
        CreditCardTemplate cardTemplate = new CreditCardTemplate();
        cardTemplate.setBankName(BankName.Chase);
        cardTemplate.setProductName("Chase Marriott Rewards Premier");
        cardTemplate.setCardIssuer(PaymentType.Visa);
        cardTemplate.setCardIssuerLogoRId( R.drawable.visa_logo, view);
        cardTemplate.setCardImageRId( R.drawable.chase_marriott_premier, view);
        cardTemplate.setCardFeatures(
                "75,000 Bonus points after you spend $3,000 on purchases in your first 3 months from your account opening\n"
                        + "$0 intro annual fee for the first year, after that $85\n "
                        + "Earn 5 points for every $1 spent at over 5,700 participating Marriott Rewards® and SPG® hotels\n"
                        + "Earn 2 points for every $1 spent on airline tickets purchased directly with the airline, and at car rental agencies & restaurants\n"
                        + "Earn 1 point for every $1 you spend on all other purchases\n"
                        + "Receive a Free Night Stay in a Category 1-5 hotel each year after your account anniversary");

        return cardTemplate;
    }

    private static CreditCardTemplate GetChaseDisneyPremierTemplate(View view)
    {
        CreditCardTemplate cardTemplate = new CreditCardTemplate();
        cardTemplate.setBankName(BankName.Chase);
        cardTemplate.setProductName("Chase Disney Premier");
        cardTemplate.setCardIssuer(PaymentType.Visa);
        cardTemplate.setCardIssuerLogoRId( R.drawable.visa_logo, view);
        cardTemplate.setCardImageRId( R.drawable.chase_disney_premier, view);
        cardTemplate.setCardFeatures(
                "• $200 Statement Credit after you spend $500 on purchases in the first 3 months from account opening\n" +
                        "2% in Disney Rewards Dollars on select categories\n"
                        + "10% savings on select Disney and Star Wars purchases at Disney Store and DisneyStore.com\n "
                        + "Disney Visa Cardmember-Exclusive photo opportunities with Disney or Star Wars Characters\n"
                        + "$49 annual fee"  );

        return cardTemplate;
    }

    private static CreditCardTemplate GetCitiDoubleCashTemplate(View view)
    {
        CreditCardTemplate cardTemplate = new CreditCardTemplate();
        cardTemplate.setBankName(BankName.CITI);
        cardTemplate.setProductName("CITI Double Cash");
        cardTemplate.setCardIssuer(PaymentType.MasterCard);
        cardTemplate.setCardIssuerLogoRId(R.drawable.mastercard_logo, view);
        cardTemplate.setCardImageRId( R.drawable.citi_doublecash, view);
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
        cardTemplate.setCardIssuerLogoRId( R.drawable.amex_logo, view);
        cardTemplate.setCardImageRId(R.drawable.amex_bluecasheveryday, view);
        cardTemplate.setCardFeatures(
                "3% cash back at U.S. supermarkets, on up to $6,000 per year in purchases (then 1%)\n " +
                "2% cashback at U.S. gas stations & select U.S. department stores\n" +
                "1% cashback on other purchases\n" +
                "No annual fee\n");
        return cardTemplate;
    }
}
