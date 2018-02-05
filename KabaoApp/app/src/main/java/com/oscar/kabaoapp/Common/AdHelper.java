package com.oscar.kabaoapp.Common;

import android.view.View;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.oscar.kabaoapp.R;

/**
 * Created by yang on 2/4/2018.
 */

public class AdHelper {
    public static final String AppID = "ca-app-pub-9690495249654800~4847942125";
    public static final String AdUnitMain = "ca-app-pub-9690495249654800/1172899921";
    public static final String AdUnitTest = "ca-app-pub-3940256099942544/6300978111";
    public static final String AdUnitInterstial = "ca-app-pub-9690495249654800/8778709581";

    public static void setupAds(View view, int AdRid )
    {
        MobileAds.initialize(view.getContext(), AppID);
        AdView mAdView = view.findViewById(AdRid);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
    }

}
