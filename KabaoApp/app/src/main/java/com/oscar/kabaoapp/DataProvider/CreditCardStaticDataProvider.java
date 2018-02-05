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
            add(GetChaseDisneyTemplate(view));
            add(GetChaseRitzCarltonTemplate(view));
            add(GetChaseIHGTemplate(view));
            add(GetChaseHyattTemplate(view));
            add(GetChaseAmazonTemplate(view));
            add(GetChaseAARPTemplate(view));
            add(GetChaseInkPreferredBusinessTemplate(view));
            add(GetChaseInkCashBusinessTemplate(view));
            add(GetChaseSouthwestPremierBusinessTemplate(view));
            add(GetChaseUnitedExplorerBizTemplate(view));
            add(GetChaserMarriottRewardsPremierBizTemplate(view));

            add(GetCitiDoubleCashTemplate(view));
            add(GetCitiSimplicityTemplate(view));
            add(GetCitiSimplicityTemplate(view));
            add(GetCitiAAPlatinumTemplate(view));
            add(GetCitiAAExecutiveTemplate(view));
            add(GetCitiAAPlatinumBizTemplate(view));
            add(GetCitiAAGoldTemplate(view));
            add(GetCitiThankYouPreferredTemplate(view));
            add(GetCitiThankYouPremierTemplate(view));
            add(GetCitiThankYouPrestigeTemplate(view));
            add(GetCitiThankYouPreferredStudentTemplate(view));
            add(GetCitiDiamondTemplate(view));
            add(GetCitiExpediaPlusTemplate(view));
            add(GetCitiExpediaPlusVoaygerTemplate(view));
            add(GetCitiCostcoAnywhereTemplate(view));
            add(GetCitiCostcoAnywhereBizTemplate(view));
            add(GetCitiAttAccessTemplate(view));
            add(GetCitiAttAccessMoreTemplate(view));
            add(GetCitiSecureTemplate(view));


            add(GetAmexBlueCashEverydayTemplate(view));
            add(GetAmexEverydayTemplate(view));
            add(GetAmexHiltonHonorTemplate(view));
            add(GetAmexSPGTemplate(view));
            add(GetAmexBCPTemplate(view));
            add(GetAmexDeltaBlueTemplate(view));
            add(GetAmexGreenTemplate(view));
            add(GetAmexBlueTemplate(view));
            add(GetAmexMBTemplate(view));
            add(GetAmexHiltonHonorsAscendTemplate(view));
            add(GetAmexEverydayPrefTemplate(view));
            add(GetAmexPlatinumTemplate(view));
            add(GetAmexPremierRewardsGoldTemplate(view));
            add(GetAmexGoldDeltaTemplate(view));
            add(GetAmexPlatinumDeltaTemplate(view));
            add(GetAmexDeltaReserveTemplate(view));
            add(GetAmexHiltonAspireTemplate(view));
            add(GetAmexServeTemplate(view));


            add(GetDiscoverItTemplate(view));
            add(GetDiscoverMilesTemplate(view));
            add(GetDiscoverGasRestaurantTemplate(view));
            add(GetDiscoverStudentTemplate(view));
            add(GetDiscoverSecuredTemplate(view));
            add(GetDiscoverStudentChromeTemplate(view));
            add(GetDiscoverNHLTemplate(view));

            add(GetBarclayAABizTemplate(view));
            add(GetBarclayAARedTemplate(view));
            add(GetBarclayArrivalPlusTemplate(view));
            add(GetBarclayAppleTemplate(view));
            add(GetBarclayBarnesTemplate(view));
            add(GetBarclayCarnivalTemplate(view));
            add(GetBarclayChoiceTemplate(view));
            add(GetBarclayDiamondTemplate(view));
            add(GetBarclayFrontierTemplate(view));
            add(GetBarclayHawaiianTemplate(view));
            add(GetBarclayHollandTemplate(view));
            add(GetBarclayJetblueTemplate(view));
            add(GetBarclayRingTemplate(view));
            add(GetBarclayMilesMoreTemplate(view));
            add(GetBarclayNFLTemplate(view));
            add(GetBarclayPricelineTemplate(view));
            add(GetBarclayPrincessTemplate(view));
            add(GetBarclayRCITemplate(view));
            add(GetBarclayUberTemplate(view));
            add(GetBarclayWyndhamTemplate(view));


            add(GetCustomTemplate(view));
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

    //region chase cards(24)

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

    private static CreditCardTemplate GetChaseDisneyTemplate(View view)
    {
        CreditCardTemplate cardTemplate = new CreditCardTemplate();
        cardTemplate.setBankName(BankName.Chase);
        cardTemplate.setProductName("Chase Disney");
        cardTemplate.setCardIssuer(PaymentType.Visa);
        cardTemplate.setCardIssuerLogoRId( R.drawable.visa_logo, view);
        cardTemplate.setCardImageRId( R.drawable.chase_disney, view);
        cardTemplate.setCardFeatures(
                "• $50 Statement Credit after first purchase with a new Disney Visa Card\n" +
                        "1% in Disney Rewards Dollars on all purchases\n"
                        + "10% savings on select Disney and Star Wars purchases at Disney Store and DisneyStore.com\n "
                        + "Disney Visa Cardmember-Exclusive photo opportunities with Disney or Star Wars Characters\n"
                        + "No annual fee"  );

        return cardTemplate;
    }

    private static CreditCardTemplate GetChaseRitzCarltonTemplate(View view)
    {
        CreditCardTemplate cardTemplate = new CreditCardTemplate();
        cardTemplate.setBankName(BankName.Chase);
        cardTemplate.setProductName("Chase Ritz-Carlton Rewards");
        cardTemplate.setCardIssuer(PaymentType.Visa);
        cardTemplate.setCardIssuerLogoRId( R.drawable.visa_logo, view);
        cardTemplate.setCardImageRId( R.drawable.chase_ritz_carlton, view);
        cardTemplate.setCardFeatures(
                "• Two complimentary nights at any participating Tier 1-4 Ritz-Carlton hotel, " +
                        "after you spend $4,000 on purchases in the first 3 months from your account opening\n"
                        + "Earn 5 points per $1 spent at participating Ritz-Carlton Rewards® and SPG® hotels\n"
                        + "Earn 2 points per $1 spent on airline tickets purchased directly with the airline, and at car rental agencies and restaurants\n "
                        + "Earn 1 point per $1 spent on all other card purchases\n"
                        + "Enjoy a $300 annual travel credit to use for baggage fees, seat upgrades, access to your preferred airport lounge and more\n"
                        +"$450 annual fee");

        return cardTemplate;
    }

    private static CreditCardTemplate GetChaseIHGTemplate(View view)
    {
        CreditCardTemplate cardTemplate = new CreditCardTemplate();
        cardTemplate.setBankName(BankName.Chase);
        cardTemplate.setProductName("Chase IHG Rewards Club");
        cardTemplate.setCardIssuer(PaymentType.Visa);
        cardTemplate.setCardIssuerLogoRId( R.drawable.visa_logo, view);
        cardTemplate.setCardImageRId( R.drawable.chase_ihg, view);
        cardTemplate.setCardFeatures(
                "• 60,000 bonus points after you spend $1,000 on purchases in the first 3 months of account opening\n"
                        + "Earn 5 points per $1 spent when you stay at IHG® hotels\n"
                        + "Earn 2 points per $1 spent on purchases at gas stations, grocery stores, and restaurants\n "
                        + "Earn 1 point per $1 spent on all other card purchases\n"
                        + "Enjoy a Free night after each account anniversary year at over 5,000 hotels worldwide\n"
                        +"$0 intro annual fee for the first year, after that $49");

        return cardTemplate;
    }

    private static CreditCardTemplate GetChaseHyattTemplate(View view)
    {
        CreditCardTemplate cardTemplate = new CreditCardTemplate();
        cardTemplate.setBankName(BankName.Chase);
        cardTemplate.setProductName("Chase Hyatt");
        cardTemplate.setCardIssuer(PaymentType.Visa);
        cardTemplate.setCardIssuerLogoRId( R.drawable.visa_logo, view);
        cardTemplate.setCardImageRId( R.drawable.chase_hyatt, view);
        cardTemplate.setCardFeatures(
                "• 40,000 Bonus Points after you spend $2,000 on purchases in the first 3 months from account opening\n"
                        + "Earn 3 Bonus Points per $1 spent on purchases at all Hyatt hotels and resorts\n"
                        + "Earn 2 Bonus Points per $1 spent at restaurants, on airline tickets purchased directly from the airline and at car rental agencies\n "
                        + "Earn 1 point per $1 spent on all other card purchases\n"
                        + "Enjoy a Free night after each account anniversary year\n"
                        +"$75 annual fee");

        return cardTemplate;
    }

    private static CreditCardTemplate GetChaseAmazonTemplate(View view)
    {
        CreditCardTemplate cardTemplate = new CreditCardTemplate();
        cardTemplate.setBankName(BankName.Chase);
        cardTemplate.setProductName("Chase Hyatt");
        cardTemplate.setCardIssuer(PaymentType.Visa);
        cardTemplate.setCardIssuerLogoRId( R.drawable.visa_logo, view);
        cardTemplate.setCardImageRId( R.drawable.chase_hyatt, view);
        cardTemplate.setCardFeatures(
                "• $50 Amazon.com Gift Card will be instantly loaded into your Amazon.com account upon the approval of your credit card application\n"
                        + "Earn 3% Back at Amazon.com\n"
                        + "Earn 2% Back at restaurants, gas stations and drugstores\n "
                        + "Earn 1% Back on all other purchases\n"
                        + "Enjoy a Free night after each account anniversary year\n"
                        + "No foreign transaction fee\n"
                        +"No annual fee");

        return cardTemplate;
    }

    private static CreditCardTemplate GetChaseAARPTemplate(View view)
    {
        CreditCardTemplate cardTemplate = new CreditCardTemplate();
        cardTemplate.setBankName(BankName.Chase);
        cardTemplate.setProductName("AARP");
        cardTemplate.setCardIssuer(PaymentType.Visa);
        cardTemplate.setCardIssuerLogoRId( R.drawable.visa_logo, view);
        cardTemplate.setCardImageRId( R.drawable.chase_aarp, view);
        cardTemplate.setCardFeatures(
                "• $200 Bonus Cash Back after you spend $500 on purchases in the first 3 months from account opening\n"
                        + "Earn 3% Cash Back rewards on purchases at restaurants, from fine dining to fast food\n"
                        + "Earn 3% Cash Back rewards on purchases at gas stations\n "
                        + "Earn 1% Cash Back rewards on all other purchases\n"
                        + "Enjoy a Free night after each account anniversary year\n"
                        +"No annual fee");

        return cardTemplate;
    }

    private static CreditCardTemplate GetChaseInkPreferredBusinessTemplate(View view)
    {
        CreditCardTemplate cardTemplate = new CreditCardTemplate();
        cardTemplate.setBankName(BankName.Chase);
        cardTemplate.setProductName("Chase Ink Business Preferred");
        cardTemplate.setCardIssuer(PaymentType.Visa);
        cardTemplate.setCardIssuerLogoRId( R.drawable.visa_logo, view);
        cardTemplate.setCardImageRId( R.drawable.chase_ink_preferred_business, view);
        cardTemplate.setCardFeatures(
                "• 80,000 bonus points after you spend $5,000 on purchases in the first 3 months after account opening\n"
                        + "Earn 3 points per $1 on the first $150,000 spent in combined purchases on " +
                        "travel, shipping purchases, Internet, cable and phone services, " +
                        "and on advertising purchases made with social media sites and search engines each account anniversary year\n"
                        + "Earn unlimited 1 Point Per $1 spent on all other purchases\n "
                        + "Points are worth 25% more when you redeem for airfare, hotels, car rentals and cruises through Chase Ultimate Rewards\n"
                        + "$95 annual fee");

        return cardTemplate;
    }

    private static CreditCardTemplate GetChaseInkCashBusinessTemplate(View view)
    {
        CreditCardTemplate cardTemplate = new CreditCardTemplate();
        cardTemplate.setBankName(BankName.Chase);
        cardTemplate.setProductName("Chase Ink Business Cash");
        cardTemplate.setCardIssuer(PaymentType.Visa);
        cardTemplate.setCardIssuerLogoRId( R.drawable.visa_logo, view);
        cardTemplate.setCardImageRId( R.drawable.chase_ink_cash, view);
        cardTemplate.setCardFeatures(
                "• 300 bonus cash back after you spend $3,000 on purchases in the first 3 months after account opening\n"
                        + "Earn 5% cash back on the first $25,000 spent in combined purchases at office supply " +
                        "stores and on internet, cable and phone services each account anniversary year\n"
                        + "Earn 2% cash back on the first $25,000 spent in combined purchases at gas stations and restaurants each account anniversary year\n"
                        + "Earn 1% cash back on all other purchases–with no limit to the amount you can earn\n"
                        +"No annual fee");

        return cardTemplate;
    }

    private static CreditCardTemplate GetChaseSouthwestPremierBusinessTemplate(View view)
    {
        CreditCardTemplate cardTemplate = new CreditCardTemplate();
        cardTemplate.setBankName(BankName.Chase);
        cardTemplate.setProductName("Chase Southwest Rapid Rewards® Premier Business");
        cardTemplate.setCardIssuer(PaymentType.Visa);
        cardTemplate.setCardIssuerLogoRId( R.drawable.visa_logo, view);
        cardTemplate.setCardImageRId( R.drawable.chase_swa_premier_biz, view);
        cardTemplate.setCardFeatures(
                "• 60,000 bonus points after you spend $3,000 on purchases in the first 3 months your account is open\n"
                        + "Earn 2x points on Southwest® purchases and 1x points on all other purchases\n"
                        + "6,000 anniversary bonus points\n"
                        + "No foreign transaction fee\n"
                        +"$99 annual fee");

        return cardTemplate;
    }

    private static CreditCardTemplate GetChaseUnitedExplorerBizTemplate(View view)
    {
        CreditCardTemplate cardTemplate = new CreditCardTemplate();
        cardTemplate.setBankName(BankName.Chase);
        cardTemplate.setProductName("Chase United MileagePlus® Explorer Business");
        cardTemplate.setCardIssuer(PaymentType.Visa);
        cardTemplate.setCardIssuerLogoRId( R.drawable.visa_logo, view);
        cardTemplate.setCardImageRId( R.drawable.chase_swa_premier_biz, view);
        cardTemplate.setCardFeatures(
                "• 50,000 bonus miles after you spend $3,000 on purchases in the first 3 months your account is open\n"
                        + "Earn 2 miles per $1 spent on purchases at restaurants, gas stations, and office supply stores\n"
                        + "Earn 2 miles per $1 spent on tickets purchased from United\n"
                        + "Earn 1 mile per $1 spent on all other purchases\n"
                        + "Priority boarding\n"
                        + "No foreign transaction fee\n"
                        + "10,000 bonus miles after you spend $25,000\n"
                        +"$0 intro annual fee for the first year, then $95");

        return cardTemplate;
    }

    private static CreditCardTemplate GetChaserMarriottRewardsPremierBizTemplate(View view)
    {
        CreditCardTemplate cardTemplate = new CreditCardTemplate();
        cardTemplate.setBankName(BankName.Chase);
        cardTemplate.setProductName("Chase Marriott Rewards® Premier Business");
        cardTemplate.setCardIssuer(PaymentType.Visa);
        cardTemplate.setCardIssuerLogoRId( R.drawable.visa_logo, view);
        cardTemplate.setCardImageRId( R.drawable.chase_marriott_premier_biz, view);
        cardTemplate.setCardFeatures(
                "• 75,000 Bonus points after you spend $3,000 on purchases in your first 3 months from your account opening with your Marriott Rewards Premier Business credit card\n"
                        + "Earn 5 points for every $1 spent at over 5,700 participating Marriott Rewards® and SPG® hotels\n"
                        + "Earn 2 points for every $1 spent on airline tickets purchased directly with the airline, and at car rental agencies, restaurants, office supply stores, and for internet, cable and phone services purchases\n"
                        + "Earn 1 point for every $1 you spend on all other purchases and your points don't expire as long as you make purchases on your credit card every 24 months\n"
                        + "Enjoy Marriott Rewards Gold Elite benefits when you spend $50,000 on purchases each account year\n"
                        + "$0 intro annual fee for the first year, after that $99\n");

        return cardTemplate;
    }

    //endregion

    //region citi cards(18)

    private static CreditCardTemplate GetCitiDoubleCashTemplate(View view)
    {
        CreditCardTemplate cardTemplate = new CreditCardTemplate();
        cardTemplate.setBankName(BankName.CITI);
        cardTemplate.setProductName("Citi Double Cash");
        cardTemplate.setCardIssuer(PaymentType.MasterCard);
        cardTemplate.setCardIssuerLogoRId(R.drawable.mastercard_logo, view);
        cardTemplate.setCardImageRId( R.drawable.citi_doublecash, view);
        cardTemplate.setCardFeatures(
                "Unlimited 2% cash back with no caps and no category restrictions\n " +
                "No annual fee\n City Price Rewind");
        return cardTemplate;
    }

    private static CreditCardTemplate GetCitiSimplicityTemplate(View view)
    {
        CreditCardTemplate cardTemplate = new CreditCardTemplate();
        cardTemplate.setBankName(BankName.CITI);
        cardTemplate.setProductName("Citi Simplicity®");
        cardTemplate.setCardIssuer(PaymentType.MasterCard);
        cardTemplate.setCardIssuerLogoRId(R.drawable.mastercard_logo, view);
        cardTemplate.setCardImageRId( R.drawable.citi_simplicity, view);
        return cardTemplate;
    }

    private static CreditCardTemplate GetCitiAAPlatinumTemplate(View view)
    {
        CreditCardTemplate cardTemplate = new CreditCardTemplate();
        cardTemplate.setBankName(BankName.CITI);
        cardTemplate.setProductName("Citi AAdvantage® Platinum Select® World Elite™");
        cardTemplate.setCardIssuer(PaymentType.MasterCard);
        cardTemplate.setCardIssuerLogoRId(R.drawable.mastercard_logo, view);
        cardTemplate.setCardImageRId( R.drawable.citi_aadvantage_platinum_elite, view);
        return cardTemplate;
    }

    private static CreditCardTemplate GetCitiAAExecutiveTemplate(View view)
    {
        CreditCardTemplate cardTemplate = new CreditCardTemplate();
        cardTemplate.setBankName(BankName.CITI);
        cardTemplate.setProductName("Citi AAdvantage® Executive World Elite™");
        cardTemplate.setCardIssuer(PaymentType.MasterCard);
        cardTemplate.setCardIssuerLogoRId(R.drawable.mastercard_logo, view);
        cardTemplate.setCardImageRId( R.drawable.citi_aadvantage_executive, view);
        return cardTemplate;
    }

    private static CreditCardTemplate GetCitiAAPlatinumBizTemplate(View view)
    {
        CreditCardTemplate cardTemplate = new CreditCardTemplate();
        cardTemplate.setBankName(BankName.CITI);
        cardTemplate.setProductName("CitiBusiness AAdvantage® Platinum Select® World Elite™");
        cardTemplate.setCardIssuer(PaymentType.MasterCard);
        cardTemplate.setCardIssuerLogoRId(R.drawable.mastercard_logo, view);
        cardTemplate.setCardImageRId( R.drawable.citi_aadvantage_platinum_biz, view);
        return cardTemplate;
    }

    private static CreditCardTemplate GetCitiAAGoldTemplate(View view)
    {
        CreditCardTemplate cardTemplate = new CreditCardTemplate();
        cardTemplate.setBankName(BankName.CITI);
        cardTemplate.setProductName("Citi AAdvantage® Gold World Elite™");
        cardTemplate.setCardIssuer(PaymentType.MasterCard);
        cardTemplate.setCardIssuerLogoRId(R.drawable.mastercard_logo, view);
        cardTemplate.setCardImageRId( R.drawable.citi_aadvantage_gold, view);
        return cardTemplate;
    }

    private static CreditCardTemplate GetCitiThankYouPreferredTemplate(View view)
    {
        CreditCardTemplate cardTemplate = new CreditCardTemplate();
        cardTemplate.setBankName(BankName.CITI);
        cardTemplate.setProductName("Citi ThankYou® Preferred");
        cardTemplate.setCardIssuer(PaymentType.MasterCard);
        cardTemplate.setCardIssuerLogoRId(R.drawable.mastercard_logo, view);
        cardTemplate.setCardImageRId( R.drawable.citi_thankyou_preferred, view);
        return cardTemplate;
    }

    private static CreditCardTemplate GetCitiThankYouPremierTemplate(View view)
    {
        CreditCardTemplate cardTemplate = new CreditCardTemplate();
        cardTemplate.setBankName(BankName.CITI);
        cardTemplate.setProductName("Citi ThankYou® Premier");
        cardTemplate.setCardIssuer(PaymentType.MasterCard);
        cardTemplate.setCardIssuerLogoRId(R.drawable.mastercard_logo, view);
        cardTemplate.setCardImageRId( R.drawable.citi_thankyou_premier, view);
        return cardTemplate;
    }

    private static CreditCardTemplate GetCitiThankYouPrestigeTemplate(View view)
    {
        CreditCardTemplate cardTemplate = new CreditCardTemplate();
        cardTemplate.setBankName(BankName.CITI);
        cardTemplate.setProductName("Citi ThankYou® Prestige");
        cardTemplate.setCardIssuer(PaymentType.MasterCard);
        cardTemplate.setCardIssuerLogoRId(R.drawable.mastercard_logo, view);
        cardTemplate.setCardImageRId( R.drawable.citi_prestige, view);
        return cardTemplate;
    }

    private static CreditCardTemplate GetCitiThankYouPreferredStudentTemplate(View view)
    {
        CreditCardTemplate cardTemplate = new CreditCardTemplate();
        cardTemplate.setBankName(BankName.CITI);
        cardTemplate.setProductName("Citi ThankYou® Preferred for College Student");
        cardTemplate.setCardIssuer(PaymentType.MasterCard);
        cardTemplate.setCardIssuerLogoRId(R.drawable.mastercard_logo, view);
        cardTemplate.setCardImageRId( R.drawable.citi_thankyou_preferred_students, view);
        return cardTemplate;
    }

    private static CreditCardTemplate GetCitiDiamondTemplate(View view)
    {
        CreditCardTemplate cardTemplate = new CreditCardTemplate();
        cardTemplate.setBankName(BankName.CITI);
        cardTemplate.setProductName("Citi Diamond Preferred®");
        cardTemplate.setCardIssuer(PaymentType.MasterCard);
        cardTemplate.setCardIssuerLogoRId(R.drawable.mastercard_logo, view);
        cardTemplate.setCardImageRId( R.drawable.citi_diamond_preferred, view);
        return cardTemplate;
    }

    private static CreditCardTemplate GetCitiExpediaPlusTemplate(View view)
    {
        CreditCardTemplate cardTemplate = new CreditCardTemplate();
        cardTemplate.setBankName(BankName.CITI);
        cardTemplate.setProductName("Citi EXPEDIA®+");
        cardTemplate.setCardIssuer(PaymentType.MasterCard);
        cardTemplate.setCardIssuerLogoRId(R.drawable.mastercard_logo, view);
        cardTemplate.setCardImageRId( R.drawable.citi_expedia_plus, view);
        return cardTemplate;
    }

    private static CreditCardTemplate GetCitiExpediaPlusVoaygerTemplate(View view)
    {
        CreditCardTemplate cardTemplate = new CreditCardTemplate();
        cardTemplate.setBankName(BankName.CITI);
        cardTemplate.setProductName("Citi EXPEDIA®+ VOYAGER");
        cardTemplate.setCardIssuer(PaymentType.MasterCard);
        cardTemplate.setCardIssuerLogoRId(R.drawable.mastercard_logo, view);
        cardTemplate.setCardImageRId( R.drawable.citi_expedia_plus_voyager, view);
        return cardTemplate;
    }

    private static CreditCardTemplate GetCitiCostcoAnywhereTemplate(View view)
    {
        CreditCardTemplate cardTemplate = new CreditCardTemplate();
        cardTemplate.setBankName(BankName.CITI);
        cardTemplate.setProductName("Citi Costco Anywhere");
        cardTemplate.setCardIssuer(PaymentType.Visa);
        cardTemplate.setCardIssuerLogoRId(R.drawable.visa_logo, view);
        cardTemplate.setCardImageRId( R.drawable.citi_costco_anywhere, view);
        return cardTemplate;
    }

    private static CreditCardTemplate GetCitiCostcoAnywhereBizTemplate(View view)
    {
        CreditCardTemplate cardTemplate = new CreditCardTemplate();
        cardTemplate.setBankName(BankName.CITI);
        cardTemplate.setProductName("Citi Costco Anywhere Business");
        cardTemplate.setCardIssuer(PaymentType.Visa);
        cardTemplate.setCardIssuerLogoRId(R.drawable.visa_logo, view);
        cardTemplate.setCardImageRId( R.drawable.citi_costco_anywhere_biz, view);
        return cardTemplate;
    }

    private static CreditCardTemplate GetCitiAttAccessTemplate(View view)
    {
        CreditCardTemplate cardTemplate = new CreditCardTemplate();
        cardTemplate.setBankName(BankName.CITI);
        cardTemplate.setProductName("Citi AT&T Access");
        cardTemplate.setCardIssuer(PaymentType.MasterCard);
        cardTemplate.setCardIssuerLogoRId(R.drawable.mastercard_logo, view);
        cardTemplate.setCardImageRId( R.drawable.citi_att_access, view);
        return cardTemplate;
    }

    private static CreditCardTemplate GetCitiAttAccessMoreTemplate(View view)
    {
        CreditCardTemplate cardTemplate = new CreditCardTemplate();
        cardTemplate.setBankName(BankName.CITI);
        cardTemplate.setProductName("Citi AT&T Access More");
        cardTemplate.setCardIssuer(PaymentType.MasterCard);
        cardTemplate.setCardIssuerLogoRId(R.drawable.mastercard_logo, view);
        cardTemplate.setCardImageRId( R.drawable.citi_att_access, view);
        return cardTemplate;
    }

    private static CreditCardTemplate GetCitiSecureTemplate(View view)
    {
        CreditCardTemplate cardTemplate = new CreditCardTemplate();
        cardTemplate.setBankName(BankName.CITI);
        cardTemplate.setProductName("Citi Secured");
        cardTemplate.setCardIssuer(PaymentType.MasterCard);
        cardTemplate.setCardIssuerLogoRId(R.drawable.mastercard_logo, view);
        cardTemplate.setCardImageRId( R.drawable.citi_secure, view);
        return cardTemplate;
    }
    //endregion

    //region amex cards(18)
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

    private static CreditCardTemplate GetAmexEverydayTemplate(View view)
    {
        CreditCardTemplate cardTemplate = new CreditCardTemplate();
        cardTemplate.setBankName(BankName.AmericanExpress);
        cardTemplate.setProductName("Amex EveryDay®");
        cardTemplate.setCardIssuer(PaymentType.AmericanExpress);
        cardTemplate.setCardIssuerLogoRId( R.drawable.amex_logo, view);
        cardTemplate.setCardImageRId(R.drawable.amex_everyday, view);
        cardTemplate.setCardFeatures(
                "Make 20 or more purchases with your Card in a billing period and earn 20% more points on those purchases \n " +
                        "2x points at US supermarkets on up to $6,000 per year in purchases\n" +
                        "1% cashback on other purchases\n" +
                        "No annual fee\n");
        return cardTemplate;
    }

    private static CreditCardTemplate GetAmexHiltonHonorTemplate(View view)
    {
        CreditCardTemplate cardTemplate = new CreditCardTemplate();
        cardTemplate.setBankName(BankName.AmericanExpress);
        cardTemplate.setProductName("Amex Hilton Honors");
        cardTemplate.setCardIssuer(PaymentType.AmericanExpress);
        cardTemplate.setCardIssuerLogoRId( R.drawable.amex_logo, view);
        cardTemplate.setCardImageRId(R.drawable.amex_hilton_honors, view);
        cardTemplate.setCardFeatures(
                "EARN 7X HILTON HONORS BONUS POINTS for each dollar of eligible purchases charged " +
                        "on your Card directly with a hotel or resort within the Hilton Portfolio\n " +
                        "EARN 5X HILTON HONORS BONUS POINTS for each dollar of eligible purchases " +
                        "EARN 3X HILTON HONORS BONUS POINTS on all other eligible purchases\n" +
                        "NO FOREIGN TRANSACTION FEE\n" +
                        "Enjoy complimentary Hilton Honors Silver status with your Card." +
                        "‡ Plus, spend $20,000 on eligible purchases on your Card " +
                        "in a calendar year and you can earn an upgrade to " +
                        "Hilton Honors Gold status through the end of the next calendar year\n"
                        +"No annual fee");
        return cardTemplate;
    }

    private static CreditCardTemplate GetAmexSPGTemplate(View view)
    {
        CreditCardTemplate cardTemplate = new CreditCardTemplate();
        cardTemplate.setBankName(BankName.AmericanExpress);
        cardTemplate.setProductName("Amex SPG");
        cardTemplate.setCardIssuer(PaymentType.AmericanExpress);
        cardTemplate.setCardIssuerLogoRId( R.drawable.amex_logo, view);
        cardTemplate.setCardImageRId(R.drawable.amex_spg, view);
        return cardTemplate;
    }

    private static CreditCardTemplate GetAmexBCPTemplate(View view)
    {
        CreditCardTemplate cardTemplate = new CreditCardTemplate();
        cardTemplate.setBankName(BankName.AmericanExpress);
        cardTemplate.setProductName("Amex Blue Cash Preferred");
        cardTemplate.setCardIssuer(PaymentType.AmericanExpress);
        cardTemplate.setCardIssuerLogoRId( R.drawable.amex_logo, view);
        cardTemplate.setCardImageRId(R.drawable.amex_bcp, view);
        return cardTemplate;
    }

    private static CreditCardTemplate GetAmexDeltaBlueTemplate(View view)
    {
        CreditCardTemplate cardTemplate = new CreditCardTemplate();
        cardTemplate.setBankName(BankName.AmericanExpress);
        cardTemplate.setProductName("Amex Blue Delta SkyMiles®");
        cardTemplate.setCardIssuer(PaymentType.AmericanExpress);
        cardTemplate.setCardIssuerLogoRId( R.drawable.amex_logo, view);
        cardTemplate.setCardImageRId(R.drawable.amex_delta_blue, view);
        return cardTemplate;
    }

    private static CreditCardTemplate GetAmexGreenTemplate(View view)
    {
        CreditCardTemplate cardTemplate = new CreditCardTemplate();
        cardTemplate.setBankName(BankName.AmericanExpress);
        cardTemplate.setProductName("Amex Green");
        cardTemplate.setCardIssuer(PaymentType.AmericanExpress);
        cardTemplate.setCardIssuerLogoRId( R.drawable.amex_logo, view);
        cardTemplate.setCardImageRId(R.drawable.amex_green, view);
        return cardTemplate;
    }

    private static CreditCardTemplate GetAmexBlueTemplate(View view)
    {
        CreditCardTemplate cardTemplate = new CreditCardTemplate();
        cardTemplate.setBankName(BankName.AmericanExpress);
        cardTemplate.setProductName("Amex Blue");
        cardTemplate.setCardIssuer(PaymentType.AmericanExpress);
        cardTemplate.setCardIssuerLogoRId( R.drawable.amex_logo, view);
        cardTemplate.setCardImageRId(R.drawable.amex_blue, view);
        return cardTemplate;
    }

    private static CreditCardTemplate GetAmexMBTemplate(View view)
    {
        CreditCardTemplate cardTemplate = new CreditCardTemplate();
        cardTemplate.setBankName(BankName.AmericanExpress);
        cardTemplate.setProductName("Amex Mercedes-Benz");
        cardTemplate.setCardIssuer(PaymentType.AmericanExpress);
        cardTemplate.setCardIssuerLogoRId( R.drawable.amex_logo, view);
        cardTemplate.setCardImageRId(R.drawable.amex_mercedes_benz, view);
        return cardTemplate;
    }

    private static CreditCardTemplate GetAmexHiltonHonorsAscendTemplate(View view)
    {
        CreditCardTemplate cardTemplate = new CreditCardTemplate();
        cardTemplate.setBankName(BankName.AmericanExpress);
        cardTemplate.setProductName("Amex Hilton Honors Ascend");
        cardTemplate.setCardIssuer(PaymentType.AmericanExpress);
        cardTemplate.setCardIssuerLogoRId( R.drawable.amex_logo, view);
        cardTemplate.setCardImageRId(R.drawable.amex_hilton_honors_ascend, view);
        return cardTemplate;
    }

    private static CreditCardTemplate GetAmexEverydayPrefTemplate(View view)
    {
        CreditCardTemplate cardTemplate = new CreditCardTemplate();
        cardTemplate.setBankName(BankName.AmericanExpress);
        cardTemplate.setProductName("Amex EveryDay® Preferred");
        cardTemplate.setCardIssuer(PaymentType.AmericanExpress);
        cardTemplate.setCardIssuerLogoRId( R.drawable.amex_logo, view);
        cardTemplate.setCardImageRId(R.drawable.amex_everyday_preferred, view);
        return cardTemplate;
    }

    private static CreditCardTemplate GetAmexPlatinumTemplate(View view)
    {
        CreditCardTemplate cardTemplate = new CreditCardTemplate();
        cardTemplate.setBankName(BankName.AmericanExpress);
        cardTemplate.setProductName("Amex Platinum");
        cardTemplate.setCardIssuer(PaymentType.AmericanExpress);
        cardTemplate.setCardIssuerLogoRId( R.drawable.amex_logo, view);
        cardTemplate.setCardImageRId(R.drawable.amex_platinum, view);
        return cardTemplate;
    }

    private static CreditCardTemplate GetAmexPremierRewardsGoldTemplate(View view)
    {
        CreditCardTemplate cardTemplate = new CreditCardTemplate();
        cardTemplate.setBankName(BankName.AmericanExpress);
        cardTemplate.setProductName("Amex Premier Rewards Gold");
        cardTemplate.setCardIssuer(PaymentType.AmericanExpress);
        cardTemplate.setCardIssuerLogoRId( R.drawable.amex_logo, view);
        cardTemplate.setCardImageRId(R.drawable.amex_premier_rewards_gold, view);
        return cardTemplate;
    }
    private static CreditCardTemplate GetAmexGoldDeltaTemplate(View view)
    {
        CreditCardTemplate cardTemplate = new CreditCardTemplate();
        cardTemplate.setBankName(BankName.AmericanExpress);
        cardTemplate.setProductName("Amex Gold Delta SkyMiles®");
        cardTemplate.setCardIssuer(PaymentType.AmericanExpress);
        cardTemplate.setCardIssuerLogoRId( R.drawable.amex_logo, view);
        cardTemplate.setCardImageRId(R.drawable.amex_delta_gold, view);
        return cardTemplate;
    }

    private static CreditCardTemplate GetAmexPlatinumDeltaTemplate(View view)
    {
        CreditCardTemplate cardTemplate = new CreditCardTemplate();
        cardTemplate.setBankName(BankName.AmericanExpress);
        cardTemplate.setProductName("Amex Platinum Delta SkyMiles®");
        cardTemplate.setCardIssuer(PaymentType.AmericanExpress);
        cardTemplate.setCardIssuerLogoRId( R.drawable.amex_logo, view);
        cardTemplate.setCardImageRId(R.drawable.amex_platinum_delta_skymiles, view);
        return cardTemplate;
    }

    private static CreditCardTemplate GetAmexDeltaReserveTemplate(View view)
    {
        CreditCardTemplate cardTemplate = new CreditCardTemplate();
        cardTemplate.setBankName(BankName.AmericanExpress);
        cardTemplate.setProductName("Amex Delta Reserve®");
        cardTemplate.setCardIssuer(PaymentType.AmericanExpress);
        cardTemplate.setCardIssuerLogoRId( R.drawable.amex_logo, view);
        cardTemplate.setCardImageRId(R.drawable.amex_delta_reserve, view);
        return cardTemplate;
    }

       private static CreditCardTemplate GetAmexHiltonAspireTemplate(View view)
    {
        CreditCardTemplate cardTemplate = new CreditCardTemplate();
        cardTemplate.setBankName(BankName.AmericanExpress);
        cardTemplate.setProductName("Amex Hilton Honors Aspire");
        cardTemplate.setCardIssuer(PaymentType.AmericanExpress);
        cardTemplate.setCardIssuerLogoRId( R.drawable.amex_logo, view);
        cardTemplate.setCardImageRId(R.drawable.amex_hilton_honors_aspire, view);
        return cardTemplate;
    }

    private static CreditCardTemplate GetAmexServeTemplate(View view)
    {
        CreditCardTemplate cardTemplate = new CreditCardTemplate();
        cardTemplate.setBankName(BankName.AmericanExpress);
        cardTemplate.setProductName("Amex Serve");
        cardTemplate.setCardIssuer(PaymentType.AmericanExpress);
        cardTemplate.setCardIssuerLogoRId( R.drawable.amex_logo, view);
        cardTemplate.setCardImageRId(R.drawable.amex_serve, view);
        return cardTemplate;
    }


    //endregion

    //region discover
    private static CreditCardTemplate GetDiscoverItTemplate(View view)
    {
        CreditCardTemplate cardTemplate = new CreditCardTemplate();
        cardTemplate.setBankName(BankName.Discover);
        cardTemplate.setProductName("Discover it Cash Back");
        cardTemplate.setCardIssuer(PaymentType.Discover);
        cardTemplate.setCardIssuerLogoRId( R.drawable.discover_logo, view);
        cardTemplate.setCardImageRId(R.drawable.discover_it, view);
        return cardTemplate;
    }

    private static CreditCardTemplate GetDiscoverMilesTemplate(View view)
    {
        CreditCardTemplate cardTemplate = new CreditCardTemplate();
        cardTemplate.setBankName(BankName.Discover);
        cardTemplate.setProductName("Discover Miles");
        cardTemplate.setCardIssuer(PaymentType.Discover);
        cardTemplate.setCardIssuerLogoRId( R.drawable.discover_logo, view);
        cardTemplate.setCardImageRId(R.drawable.discover_miles, view);
        return cardTemplate;
    }

    private static CreditCardTemplate GetDiscoverGasRestaurantTemplate(View view)
    {
        CreditCardTemplate cardTemplate = new CreditCardTemplate();
        cardTemplate.setBankName(BankName.Discover);
        cardTemplate.setProductName("Discover it Gas&Restaurant");
        cardTemplate.setCardIssuer(PaymentType.Discover);
        cardTemplate.setCardIssuerLogoRId( R.drawable.discover_logo, view);
        cardTemplate.setCardImageRId(R.drawable.discover_it_gas, view);
        return cardTemplate;
    }
    private static CreditCardTemplate GetDiscoverStudentTemplate(View view)
    {
        CreditCardTemplate cardTemplate = new CreditCardTemplate();
        cardTemplate.setBankName(BankName.Discover);
        cardTemplate.setProductName("Discover IT Gas&Restaurant");
        cardTemplate.setCardIssuer(PaymentType.Discover);
        cardTemplate.setCardIssuerLogoRId( R.drawable.discover_logo, view);
        cardTemplate.setCardImageRId(R.drawable.discover_student, view);
        return cardTemplate;
    }

    private static CreditCardTemplate GetDiscoverSecuredTemplate(View view)
    {
        CreditCardTemplate cardTemplate = new CreditCardTemplate();
        cardTemplate.setBankName(BankName.Discover);
        cardTemplate.setProductName("Discover IT Gas&Restaurant");
        cardTemplate.setCardIssuer(PaymentType.Discover);
        cardTemplate.setCardIssuerLogoRId( R.drawable.discover_logo, view);
        cardTemplate.setCardImageRId(R.drawable.discover_secured, view);
        return cardTemplate;
    }

    private static CreditCardTemplate GetDiscoverStudentChromeTemplate(View view)
    {
        CreditCardTemplate cardTemplate = new CreditCardTemplate();
        cardTemplate.setBankName(BankName.Discover);
        cardTemplate.setProductName("Discover IT Gas&Restaurant");
        cardTemplate.setCardIssuer(PaymentType.Discover);
        cardTemplate.setCardIssuerLogoRId( R.drawable.discover_logo, view);
        cardTemplate.setCardImageRId(R.drawable.discover_student, view);
        return cardTemplate;
    }

    private static CreditCardTemplate GetDiscoverNHLTemplate(View view)
    {
        CreditCardTemplate cardTemplate = new CreditCardTemplate();
        cardTemplate.setBankName(BankName.Discover);
        cardTemplate.setProductName("Discover IT Gas&Restaurant");
        cardTemplate.setCardIssuer(PaymentType.Discover);
        cardTemplate.setCardIssuerLogoRId( R.drawable.discover_logo, view);
        cardTemplate.setCardImageRId(R.drawable.discover_nhl, view);
        return cardTemplate;
    }


    //endregion

    //region barclay(20)
    private static CreditCardTemplate GetBarclayAABizTemplate(View view)
    {
        CreditCardTemplate cardTemplate = new CreditCardTemplate();
        cardTemplate.setBankName(BankName.Barclaycard);
        cardTemplate.setProductName("Barclaycard AAdvantage Aviator Business");
        cardTemplate.setCardIssuer(PaymentType.MasterCard);
        cardTemplate.setCardIssuerLogoRId( R.drawable.mastercard_logo, view);
        cardTemplate.setCardImageRId(R.drawable.barclay_aa_biz, view);
        return cardTemplate;
    }

    private static CreditCardTemplate GetBarclayAARedTemplate(View view)
    {
        CreditCardTemplate cardTemplate = new CreditCardTemplate();
        cardTemplate.setBankName(BankName.Barclaycard);
        cardTemplate.setProductName("Barclaycard AAdvantage Aviator Red");
        cardTemplate.setCardIssuer(PaymentType.MasterCard);
        cardTemplate.setCardIssuerLogoRId( R.drawable.mastercard_logo, view);
        cardTemplate.setCardImageRId(R.drawable.barclay_aa, view);
        return cardTemplate;
    }

    private static CreditCardTemplate GetBarclayArrivalPlusTemplate(View view)
    {
        CreditCardTemplate cardTemplate = new CreditCardTemplate();
        cardTemplate.setBankName(BankName.Barclaycard);
        cardTemplate.setProductName("Barclaycard Arrival Plus");
        cardTemplate.setCardIssuer(PaymentType.MasterCard);
        cardTemplate.setCardIssuerLogoRId( R.drawable.mastercard_logo, view);
        cardTemplate.setCardImageRId(R.drawable.barclay_arrivalplus, view);
        return cardTemplate;
    }


    private static CreditCardTemplate GetBarclayAppleTemplate(View view)
    {
        CreditCardTemplate cardTemplate = new CreditCardTemplate();
        cardTemplate.setBankName(BankName.Barclaycard);
        cardTemplate.setProductName("Barclaycard Apple");
        cardTemplate.setCardIssuer(PaymentType.Visa);
        cardTemplate.setCardIssuerLogoRId( R.drawable.visa_logo, view);
        cardTemplate.setCardImageRId(R.drawable.barclay_apple, view);
        return cardTemplate;
    }

    private static CreditCardTemplate GetBarclayBarnesTemplate(View view)
    {
        CreditCardTemplate cardTemplate = new CreditCardTemplate();
        cardTemplate.setBankName(BankName.Barclaycard);
        cardTemplate.setProductName("Barclaycard Barnes&Noble");
        cardTemplate.setCardIssuer(PaymentType.MasterCard);
        cardTemplate.setCardIssuerLogoRId( R.drawable.mastercard_logo, view);
        cardTemplate.setCardImageRId(R.drawable.barclay_noble, view);
        return cardTemplate;
    }

    private static CreditCardTemplate GetBarclayCarnivalTemplate(View view)
    {
        CreditCardTemplate cardTemplate = new CreditCardTemplate();
        cardTemplate.setBankName(BankName.Barclaycard);
        cardTemplate.setProductName("Barclaycard Carnival World");
        cardTemplate.setCardIssuer(PaymentType.MasterCard);
        cardTemplate.setCardIssuerLogoRId( R.drawable.mastercard_logo, view);
        cardTemplate.setCardImageRId(R.drawable.barclay_carnival, view);
        return cardTemplate;
    }

    private static CreditCardTemplate GetBarclayChoiceTemplate(View view)
    {
        CreditCardTemplate cardTemplate = new CreditCardTemplate();
        cardTemplate.setBankName(BankName.Barclaycard);
        cardTemplate.setProductName("Barclaycard Choice Privileges");
        cardTemplate.setCardIssuer(PaymentType.Visa);
        cardTemplate.setCardIssuerLogoRId( R.drawable.visa_logo, view);
        cardTemplate.setCardImageRId(R.drawable.barclaychoice, view);
        return cardTemplate;
    }

    private static CreditCardTemplate GetBarclayDiamondTemplate(View view)
    {
        CreditCardTemplate cardTemplate = new CreditCardTemplate();
        cardTemplate.setBankName(BankName.Barclaycard);
        cardTemplate.setProductName("Barclaycard Diamond Resorts International");
        cardTemplate.setCardIssuer(PaymentType.MasterCard);
        cardTemplate.setCardIssuerLogoRId( R.drawable.mastercard_logo, view);
        cardTemplate.setCardImageRId(R.drawable.barclay_diamondresortint, view);
        return cardTemplate;
    }

    private static CreditCardTemplate GetBarclayFrontierTemplate(View view)
    {
        CreditCardTemplate cardTemplate = new CreditCardTemplate();
        cardTemplate.setBankName(BankName.Barclaycard);
        cardTemplate.setProductName("Barclaycard Forntier Airlines");
        cardTemplate.setCardIssuer(PaymentType.MasterCard);
        cardTemplate.setCardIssuerLogoRId( R.drawable.mastercard_logo, view);
        cardTemplate.setCardImageRId(R.drawable.barclay_fontier, view);
        return cardTemplate;
    }

    private static CreditCardTemplate GetBarclayHawaiianTemplate(View view)
    {
        CreditCardTemplate cardTemplate = new CreditCardTemplate();
        cardTemplate.setBankName(BankName.Barclaycard);
        cardTemplate.setProductName("Barclaycard Hawaiian Airlines");
        cardTemplate.setCardIssuer(PaymentType.MasterCard);
        cardTemplate.setCardIssuerLogoRId( R.drawable.mastercard_logo, view);
        cardTemplate.setCardImageRId(R.drawable.barclay_hawaiianairlines, view);
        return cardTemplate;
    }

    private static CreditCardTemplate GetBarclayHollandTemplate(View view)
    {
        CreditCardTemplate cardTemplate = new CreditCardTemplate();
        cardTemplate.setBankName(BankName.Barclaycard);
        cardTemplate.setProductName("Barclaycard Holland America Line");
        cardTemplate.setCardIssuer(PaymentType.Visa);
        cardTemplate.setCardIssuerLogoRId( R.drawable.visa_logo, view);
        cardTemplate.setCardImageRId(R.drawable.barclay_holland, view);
        return cardTemplate;
    }

    private static CreditCardTemplate GetBarclayJetblueTemplate(View view)
    {
        CreditCardTemplate cardTemplate = new CreditCardTemplate();
        cardTemplate.setBankName(BankName.Barclaycard);
        cardTemplate.setProductName("Barclaycard JetBlue");
        cardTemplate.setCardIssuer(PaymentType.MasterCard);
        cardTemplate.setCardIssuerLogoRId( R.drawable.mastercard_logo, view);
        cardTemplate.setCardImageRId(R.drawable.barclay_jetblue, view);
        return cardTemplate;
    }

    private static CreditCardTemplate GetBarclayRingTemplate(View view)
    {
        CreditCardTemplate cardTemplate = new CreditCardTemplate();
        cardTemplate.setBankName(BankName.Barclaycard);
        cardTemplate.setProductName("Barclaycard Ring");
        cardTemplate.setCardIssuer(PaymentType.MasterCard);
        cardTemplate.setCardIssuerLogoRId( R.drawable.mastercard_logo, view);
        cardTemplate.setCardImageRId(R.drawable.barclay_ring, view);
        return cardTemplate;
    }

    private static CreditCardTemplate GetBarclayMilesMoreTemplate(View view)
    {
        CreditCardTemplate cardTemplate = new CreditCardTemplate();
        cardTemplate.setBankName(BankName.Barclaycard);
        cardTemplate.setProductName("Barclaycard Miles&More");
        cardTemplate.setCardIssuer(PaymentType.MasterCard);
        cardTemplate.setCardIssuerLogoRId( R.drawable.mastercard_logo, view);
        cardTemplate.setCardImageRId(R.drawable.barclay_milesmore, view);
        return cardTemplate;
    }

    private static CreditCardTemplate GetBarclayNFLTemplate(View view)
    {
        CreditCardTemplate cardTemplate = new CreditCardTemplate();
        cardTemplate.setBankName(BankName.Barclaycard);
        cardTemplate.setProductName("Barclaycard NFL Extra Points");
        cardTemplate.setCardIssuer(PaymentType.Visa);
        cardTemplate.setCardIssuerLogoRId( R.drawable.visa_logo, view);
        cardTemplate.setCardImageRId(R.drawable.barclay_nflextra, view);
        return cardTemplate;
    }

    private static CreditCardTemplate GetBarclayPricelineTemplate(View view)
    {
        CreditCardTemplate cardTemplate = new CreditCardTemplate();
        cardTemplate.setBankName(BankName.Barclaycard);
        cardTemplate.setProductName("Barclaycard Priceline Rewards");
        cardTemplate.setCardIssuer(PaymentType.Visa);
        cardTemplate.setCardIssuerLogoRId( R.drawable.visa_logo, view);
        cardTemplate.setCardImageRId(R.drawable.barclay_priceline, view);
        return cardTemplate;
    }

    private static CreditCardTemplate GetBarclayPrincessTemplate(View view)
    {
        CreditCardTemplate cardTemplate = new CreditCardTemplate();
        cardTemplate.setBankName(BankName.Barclaycard);
        cardTemplate.setProductName("Barclaycard Princess Cruises Rewards");
        cardTemplate.setCardIssuer(PaymentType.Visa);
        cardTemplate.setCardIssuerLogoRId( R.drawable.visa_logo, view);
        cardTemplate.setCardImageRId(R.drawable.barclay_princess, view);
        return cardTemplate;
    }

    private static CreditCardTemplate GetBarclayRCITemplate(View view)
    {
        CreditCardTemplate cardTemplate = new CreditCardTemplate();
        cardTemplate.setBankName(BankName.Barclaycard);
        cardTemplate.setProductName("Barclaycard RCI Elite Rewards");
        cardTemplate.setCardIssuer(PaymentType.MasterCard);
        cardTemplate.setCardIssuerLogoRId( R.drawable.mastercard_logo, view);
        cardTemplate.setCardImageRId(R.drawable.barclay_rci, view);
        return cardTemplate;
    }

    private static CreditCardTemplate GetBarclayUberTemplate(View view)
    {
        CreditCardTemplate cardTemplate = new CreditCardTemplate();
        cardTemplate.setBankName(BankName.Barclaycard);
        cardTemplate.setProductName("Barclaycard Uber");
        cardTemplate.setCardIssuer(PaymentType.Visa);
        cardTemplate.setCardIssuerLogoRId( R.drawable.visa_logo, view);
        cardTemplate.setCardImageRId(R.drawable.barclay_uber, view);
        return cardTemplate;
    }

    private static CreditCardTemplate GetBarclayWyndhamTemplate(View view)
    {
        CreditCardTemplate cardTemplate = new CreditCardTemplate();
        cardTemplate.setBankName(BankName.Barclaycard);
        cardTemplate.setProductName("Barclaycard Wyndham Rewards");
        cardTemplate.setCardIssuer(PaymentType.Visa);
        cardTemplate.setCardIssuerLogoRId( R.drawable.visa_logo, view);
        cardTemplate.setCardImageRId(R.drawable.barclay_wyndham, view);
        return cardTemplate;
    }
    //endregion

    private static CreditCardTemplate GetCustomTemplate(View view)
    {
        CreditCardTemplate cardTemplate = new CreditCardTemplate();
        cardTemplate.setBankName(BankName.Other);
        cardTemplate.setProductName("Custom Card");
        cardTemplate.setCardIssuer(PaymentType.Other);
        cardTemplate.setCardIssuerLogoRId( R.drawable.ic_placeholder, view);
        cardTemplate.setCardImageRId(R.drawable.ic_placeholder, view);
        return cardTemplate;
    }
}
