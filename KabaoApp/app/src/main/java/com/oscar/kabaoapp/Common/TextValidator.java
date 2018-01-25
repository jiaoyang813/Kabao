package com.oscar.kabaoapp.Common;

import android.text.Selection;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by yang on 1/21/2018.
 */

public class TextValidator {
    private static final int CARD_NUMBER_LENGTH = 19;

    public static boolean IsStmtDateValid(EditText editText)
    {
        String stmtDate = editText.getText().toString();
        if(stmtDate.isEmpty())
            return true;

        if(!isLastInputDigit(stmtDate, editText))
        {
            return false;
        }

        int dayOfMonth = Integer.valueOf(stmtDate);

        if(dayOfMonth> 31 || dayOfMonth < 1)
        {
            editText.setError("Please give a proper day of a month!");
            return false;
        }

        return true;
    }

    public static boolean IsCardNicknameValid(EditText editText)
    {
        String name = editText.getText().toString();

        if(name.isEmpty())
            return true;

        if(name.length() > 30) {
            removeInvalidChar(name, editText);
            editText.setError("Reached maximum allowed letters!");
            return false;
        }
        return true;
    }

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

        if(!isLastInputDigit(creditLine, editText))
        {
            return false;
        }

        return true;
    }

    public static boolean IsCVVValid(EditText editText)
    {
        String cvv = editText.getText().toString().trim();

        if(cvv.isEmpty())
            return true;

        if(cvv.length() > 4)
        {
            removeInvalidChar(cvv, editText);
            editText.setError("Reached maximum allowed digits!");
        }

        if(!isLastInputDigit(cvv, editText))
        {
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

        if(!isLastInputDigit(cardNumberNoSpace, editText))
        {
            return false;
        }

        return true;
    }

    private static boolean isLastInputDigit(String input, EditText editText)
    {
        Character lastChar = input.charAt(input.length() - 1);

        if(!Character.isDigit(lastChar))
        {
            removeInvalidChar(input, editText);
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
