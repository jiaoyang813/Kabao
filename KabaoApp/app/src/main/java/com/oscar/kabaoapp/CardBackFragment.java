package com.oscar.kabaoapp;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.oscar.kabaoapp.dataObject.Creditcard;


/**
 * A simple {@link Fragment} subclass.
 */
public class CardBackFragment extends Fragment {

    private static final String CURRENT_CARD = "current_card";

    private Creditcard card;

    public CardBackFragment() {
        // Required empty public constructor
    }
    public static CardBackFragment newInstance(Creditcard card) {
        CardBackFragment fragment = new CardBackFragment();
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
        View view = inflater.inflate(R.layout.fragment_card_back, container, false);


        return view;
    }

}
