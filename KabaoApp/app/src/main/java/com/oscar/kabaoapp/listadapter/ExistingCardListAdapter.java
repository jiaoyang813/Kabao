package com.oscar.kabaoapp.listadapter;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.oscar.kabaoapp.Common.DataFormatter;
import com.oscar.kabaoapp.Common.ImageUtility;
import com.oscar.kabaoapp.Common.StmtDateHelper;
import com.oscar.kabaoapp.MainActivity;
import com.oscar.kabaoapp.OnClickListener.CardDetailViewOnClickListener;
import com.oscar.kabaoapp.OnClickListener.DeleteCardOnClickListener;
import com.oscar.kabaoapp.R;
import com.oscar.kabaoapp.ViewModel.AddedCreditCardViewModel;
import com.oscar.kabaoapp.dataObject.Creditcard;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by oscar on 12/10/17.
 */

public class ExistingCardListAdapter extends BaseAdapter {

    private ArrayList<Creditcard> existingCards;
    private Context context;

    private MainActivity mainActivity;

    public ExistingCardListAdapter(Context context, ArrayList<Creditcard> existingCards)
    {
        this.context = context;
        if(context instanceof MainActivity)
        {
            this.mainActivity = (MainActivity) context;
        }

        this.existingCards = existingCards;
    }

    @Override
    public int getCount() {
        if(existingCards == null)
            return  0;
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

        Creditcard card = existingCards.get(i);

        setupCardQuickView(view, card);

        TextView cardName = view.findViewById(R.id.tv_card_name);
        String cardNo = card.getCardNo();
        String last4DigitsCardNo = "";
        if(cardNo.length() > 4)
        {
           last4DigitsCardNo = cardNo.substring(cardNo.length()-4, cardNo.length());
        }
        cardName.setText(card.getProductName() + "(..." +last4DigitsCardNo+")");

        TextView stmtDate = view.findViewById(R.id.card_stmt_dt);
        int stmtDayOfMonth = Integer.valueOf(card.getStmtDate());
        stmtDate.setText("Statement Date: " + StmtDateHelper.GetStmtDate(stmtDayOfMonth));


        ImageView detailIcon = view.findViewById(R.id.show_detail);
        detailIcon.setOnClickListener(new CardDetailViewOnClickListener(card.getId()));
        return view;

    }

    private void setupCardQuickView(View view, Creditcard card)
    {
        final ImageView cardImage = view.findViewById(R.id.card_image);
        cardImage.setBackgroundResource(card.getCardImageRId(view));
        int[] heightAndwidthAjusted = ImageUtility.scaleImage(128, 200, card.getCardImageRId(view), cardImage, view);

        final RelativeLayout cardbackview = view.findViewById(R.id.cardquickview);
        ViewGroup.LayoutParams params = cardbackview.getLayoutParams();
         // Changes the height and width to the specified *pixels*
        params.height = heightAndwidthAjusted[0];
        params.width =  heightAndwidthAjusted[1];
        cardbackview.setLayoutParams(params);

        ImageView quickview_paymenttypeimage = view.findViewById(R.id.quickview_paymenttypeimage);
        quickview_paymenttypeimage.setBackgroundResource(card.getCardIssuerLogoRId(view));
        ImageUtility.scaleImage(40, 40,
                card.getCardIssuerLogoRId(view), quickview_paymenttypeimage, view);

        TextView quickview_cardnumber = view.findViewById(R.id.quickview_cardnumber);
        quickview_cardnumber.setText(DataFormatter.addSpaceInCardNumber(card.getCardNo()));

        TextView quickview_expiredate = view.findViewById( R.id.quickview_expiredate);
        quickview_expiredate.setText("Expire " + card.getExpiredOn());

        TextView quickview_cvv = view.findViewById(R.id.quickview_cvv);
        quickview_cvv.setText(card.getCvv());

        cardbackview.setVisibility(View.GONE);


        cardImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cardImage.setVisibility(View.GONE);
                cardbackview.setVisibility(View.VISIBLE);
            }
        });

        cardbackview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cardImage.setVisibility(View.VISIBLE);
                cardbackview.setVisibility(View.GONE);
            }
        });

    }


}
