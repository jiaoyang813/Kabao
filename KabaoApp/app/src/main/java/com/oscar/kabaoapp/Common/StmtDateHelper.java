package com.oscar.kabaoapp.Common;

import java.util.Calendar;

/**
 * Created by Oscar on 1/24/2018.
 */

public class StmtDateHelper {
    public static String GetStmtDate(int stmtDayOfMonth)
    {
        final Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH) + 1;
        int day = c.get(Calendar.DAY_OF_MONTH);
        if(stmtDayOfMonth < day)
        {
            month++;
        }

        return month +"/"+stmtDayOfMonth+"/" + year;
    }
}
