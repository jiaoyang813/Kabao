package com.oscar.kabaoapp.Common;

import android.content.res.Resources;
import android.view.View;

/**
 * Created by Oscar on 1/30/2018.
 */

public class ResourceHelper {
    public static int GetResId(String name, View v)
    {
        Resources resources = v.getResources();
        return resources.getIdentifier(name, "drawable", "com.oscar.kabaoapp");
    }

    public static String GetResName(int resId, View v)
    {
        Resources resources = v.getResources();
        return resources.getResourceEntryName(resId);
    }
}
