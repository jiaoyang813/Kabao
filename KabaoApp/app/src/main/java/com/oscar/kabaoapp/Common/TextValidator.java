package com.oscar.kabaoapp.Common;

import android.text.Selection;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by yang on 1/21/2018.
 */

public class TextValidator {
    private static final int CARD_NUMBER_LENGTH = 19;

    public static boolean IsCreditLineValid(EditText editText)
    {
        String creditLine = editText.getText().toString().trim();

        if(creditLine.isEmpty())
            return true;

        if(creditLine.length() > 9)
        {
            removeInvalidChar(creditLine, editText);
            editText.setError("Reached maximum allowed digits!");
        }

        Character lastChar = creditLine.charAt(creditLine.length() - 1);

        if(!Character.isDigit(lastChar))
        {
            removeInvalidChar(creditLine, editText);
            editText.setError("Please enter numbers(0-9) only");
            return false;
        }

        return true;
    }

    public static boolean IsCVVValid(EditText textView)
    {
        String cvv = textView.getText().toString().trim();

        if(cvv.isEmpty())
            return true;

        if(cvv.length() > 4)
        {
            removeInvalidChar(cvv, textView);
            textView.setError("Reached maximum allowed digits!");
        }

        Character lastChar = cvv.charAt(cvv.length() - 1);

        if(!Character.isDigit(lastChar))
        {
            removeInvalidChar(cvv, textView);
            textView.setError("Please enter numbers(0-9) only");
            return false;
        }

        return true;
    }

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
            editText.setError("Reached maximum allowed digits!");
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
