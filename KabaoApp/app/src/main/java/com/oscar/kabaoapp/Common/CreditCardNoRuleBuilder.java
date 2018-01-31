package com.oscar.kabaoapp.Common;

import com.oscar.kabaoapp.dataObject.Creditcard;
import com.oscar.kabaoapp.dataObject.PaymentType;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Oscar on 1/22/2018.
 */

public class CreditCardNoRuleBuilder {

    private static HashMap<PaymentType, CreditCardNoRule> CardNoRules = new HashMap(){
        {
            put(PaymentType.AmericanExpress, GetAmexCardNoRule());
            put(PaymentType.Visa, GetVisaCardNoRule());
            put(PaymentType.MasterCard, GetMasterCardNoRule());
            put(PaymentType.Discover, GetDiscoverCardNoRule());
        }
    };


    private static CreditCardNoRule GetAmexCardNoRule()
    {
        CreditCardNoRule rule = new CreditCardNoRule();
        rule.CardIssuer = PaymentType.AmericanExpress;
        rule.NumOfDigits = new ArrayList(){{add(15);}};
        rule.StartWith = new ArrayList(){{add(34); add(37);}};
        return rule;
    }

    private static CreditCardNoRule GetVisaCardNoRule()
    {
        CreditCardNoRule rule = new CreditCardNoRule();
        rule.CardIssuer = PaymentType.Visa;
        rule.NumOfDigits = new ArrayList(){{add(13);add(16);add(19);}};
        rule.StartWith = new ArrayList(){{add(4);}};
        return rule;
    }

    private static CreditCardNoRule GetMasterCardNoRule()
    {
        CreditCardNoRule rule = new CreditCardNoRule();
        rule.CardIssuer = PaymentType.MasterCard;
        rule.NumOfDigits = new ArrayList(){{add(16);}};
        rule.StartWith = new ArrayList(){{add(51);add(52);add(53);add(54);add(55);
                add(22);add(23);add(24); add(25); add(26);add(27);}};
        return rule;
    }

    private static CreditCardNoRule GetDiscoverCardNoRule()
    {
        CreditCardNoRule rule = new CreditCardNoRule();
        rule.CardIssuer = PaymentType.Discover;
        rule.NumOfDigits = new ArrayList(){{add(13);add(16);add(19);}};
        rule.StartWith = new ArrayList(){{add(6011);add(622);add(644);add(645);add(646);
            add(647);add(648);add(649); add(65);}};
        return rule;
    }

    public static boolean IsValidStartNum(Creditcard card)
    {
        CreditCardNoRule cardNumRule = CardNoRules.get(card.getCardIssuer());
        Boolean matchedStartnum = false;

        for (Integer startNum: cardNumRule.StartWith) {
            int count = startNum.toString().length();
            String startStr = card.getCardNo().substring(0, count );

            if(startStr.equals(startNum.toString()))
            {
                matchedStartnum = true;
                break;
            }
        }

        if(!matchedStartnum)
        {
            return false;
        }

        return true;

    }

    public static  boolean IsValidLength(Creditcard card)
    {
        CreditCardNoRule cardNumRule = CardNoRules.get(card.getCardIssuer());

        if(!cardNumRule.NumOfDigits.contains(card.getCardNo().length()))
        {
            return false;
        }

        return true;
    }


    // Validate based on Luhn Algorithm
    public static boolean IsValidCardNoLuhnAlgo(Creditcard card)
    {
        String cardNo = card.getCardNo();

        String cardNoWithoutLastChar = cardNo.substring(0, cardNo.length() -1 );

        String lastChar = cardNo.substring(cardNo.length() - 1);

        String reversed = new StringBuilder(cardNoWithoutLastChar).reverse().toString();

        int sum = 0;
        int count = 0;
        for (Character digit: reversed.toCharArray()) {
            int number = Integer.valueOf(digit.toString());

            if(count%2 == 0)
            {
                number = number * 2;
                if(number > 9)
                {
                    number -= 9;
                }
            }
            sum += number;
            count++;
        }

        if(sum % 10 ==  Integer.valueOf(lastChar.toString()))
        {
            return true;
        }

        return false;
    }

}
