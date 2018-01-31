package com.oscar.kabaoapp.Common;

/**
 * Created by Oscar on 1/29/2018.
 */

public class DataFormatter {
    public static String addSpaceInCardNumber(String cardNo)
    {
        String cardNumberNoSpace = cardNo.replaceAll("\\s", "");

        int part = cardNumberNoSpace.length()/4;

        String cardNumberAjusted = "";

        for (int i = 0; i <= part; i++)
        {
            int endIndex = Math.min((i+1)*4, cardNumberNoSpace.length());
            cardNumberAjusted += cardNumberNoSpace.substring(i * 4, endIndex) + " ";
        }

        return cardNumberAjusted.trim();
    }
}
