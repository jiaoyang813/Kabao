package com.oscar.kabaoapp;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.oscar.kabaoapp.Common.ImageUtility;
import com.oscar.kabaoapp.dataObject.Creditcard;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class CardFrontFragment extends Fragment {

    private static final String CURRENT_CARD = "current_card";

    private Creditcard card;

    public CardFrontFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     * @return A new instance of fragment MycardFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static CardFrontFragment newInstance(Creditcard card) {
        CardFrontFragment fragment = new CardFrontFragment();
        Bundle args = new Bundle();
        args.putParcelable(CURRENT_CARD, card);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            card = getArguments().getParcelable(CURRENT_CARD);
        }
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_card_front, container, false);
        ImageView cardImage = view.findViewById(R.id.card_image);
        cardImage.setBackgroundResource(card.getCardImageRId());
        ImageUtility.scaleImage(128, 200, card.getCardImageRId(), cardImage, view);
        return view;
    }

}
