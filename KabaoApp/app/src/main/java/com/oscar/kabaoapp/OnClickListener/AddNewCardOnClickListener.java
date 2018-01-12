package com.oscar.kabaoapp.OnClickListener;

import android.content.Intent;
import android.view.View;

import com.oscar.kabaoapp.AddCardActivity;

/**
 * Created by Oscar on 1/11/2018.
 */

public class AddNewCardOnClickListener implements View.OnClickListener {
    @Override
    public void onClick(View v) {
        Intent intent = new Intent(v.getContext(), AddCardActivity.class);
        v.getContext().startActivity(intent);
    }
}
