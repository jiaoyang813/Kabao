package com.oscar.kabaoapp.Common;

import android.text.Selection;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by yang on 1/21/2018.
 */

public class TextValidator {
    private static final int CARD_NUMBER_LENGTH = 16;
    public static boolean IsCardNoValid(EditText editText)
    {
        String cardNo = editText.getText().toString().trim();

        if(cardNo.isEmpty())
            return true;

        String cardNumberNoSpace = cardNo.replaceAll("\\s","");
        int cardNumberDigits = cardNumberNoSpace.length();

        if(cardNumberDigits > CARD_NUMBER_LENGTH)
        {
            removeInvalidChar(cardNo, editText);
            editText.setError("Exceed maximum allowed digits!");
            return false;
        }

        Character lastChar = cardNumberNoSpace.charAt(cardNumberDigits -1);

        if(!Character.isDigit(lastChar))
        {
            removeInvalidChar(cardNo, editText);
            editText.setError("Please enter numbers(0-9) only");
            return false;
        }

        return true;
    }

    private static void removeInvalidChar(String str, EditText editText)
    {
        String strWithoutLastChar = str.substring(0, str.length() - 1);
        editText.setText(strWithoutLastChar);
        editText.setSelection(strWithoutLastChar.length());
    }

}
