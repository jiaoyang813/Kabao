package com.oscar.kabaoapp.listadapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.TextView;

import com.oscar.kabaoapp.R;
import com.oscar.kabaoapp.dataObject.Creditcard;

import java.util.ArrayList;

/**
 * Created by oscar on 12/10/17.
 */

public class ExistingCardListAdapter extends BaseAdapter {

    private ArrayList<Creditcard> existingCards;
    private Context context;

    public ExistingCardListAdapter(Context context, ArrayList<Creditcard> existingCards)
    {
        this.context = context;
        this.existingCards = existingCards;
    }

    @Override
    public int getCount() {
        return existingCards.size();
    }

    @Override
    public Object getItem(int i) {
        return existingCards.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater inf = (LayoutInflater)
                context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view = inf.inflate(R.layout.listitem_existingcard, null);
        TextView country = (TextView)view.findViewById(R.id.tv_card_feature_content);
        ImageView icon = (ImageView)view.findViewById(R.id.icon);
        country.setText(existingCards.get(i).getName());
        //icon.setImageResource();
        return view;
    }
}
