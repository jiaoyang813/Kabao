package com.oscar.kabaoapp.listadapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.oscar.kabaoapp.R;
import com.oscar.kabaoapp.dataObject.CreditCardTemplate;
import com.oscar.kabaoapp.dataObject.Creditcard;
import com.oscar.kabaoapp.dataObject.CreditcardCompany;

import java.util.ArrayList;

/**
 * Created by oscar on 12/9/17.
 */

public class AddCardListAdapter extends BaseExpandableListAdapter {
    private Context context;
    private ArrayList<CreditcardCompany> creditcardCompanies;

    public AddCardListAdapter(Context context, ArrayList<CreditcardCompany> companies) {
        this.context = context;
        this.creditcardCompanies = companies;
    }

    @Override
    public int getGroupCount() {
        return creditcardCompanies.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return creditcardCompanies.get(groupPosition).GetCreditcardProducts().size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return creditcardCompanies.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        CreditCardTemplate creditcard =
                ((CreditcardCompany)getGroup(groupPosition)).GetCreditcardProducts().get(childPosition);
        return creditcard;
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        //Creditcard creditcard = (Creditcard) getChild(groupPosition, childPosition);
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return true;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View view, ViewGroup parent) {
        CreditcardCompany creditcardCompany = (CreditcardCompany) getGroup(groupPosition);
        if (view == null) {
            LayoutInflater inf = (LayoutInflater)
                    context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inf.inflate(R.layout.listitem_creditcardcompany, null);
        }

        TextView heading = view.findViewById(R.id.creditcardcompany_name);
        heading.setText(creditcardCompany.GetCompanyName().toString());

        ImageView bankImage = view.findViewById(R.id.expandablelist_group_image);
        bankImage.setBackgroundResource(creditcardCompany.getCompanyLogoRId());

        return view;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        CreditCardTemplate creditcard = (CreditCardTemplate) getChild(groupPosition, childPosition);
        if (convertView == null) {
            LayoutInflater infalInflater = (LayoutInflater)
                    context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = infalInflater.inflate(R.layout.listitem_creditcard, null);
        }

        TextView childItem =  convertView.findViewById(R.id.creditcarditem);
        childItem.setText(creditcard.getProductName().trim());
        ImageView cardImage = convertView.findViewById(R.id.card_image);
        cardImage.setBackgroundResource(creditcard.getCardImageRId());
        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }
}
