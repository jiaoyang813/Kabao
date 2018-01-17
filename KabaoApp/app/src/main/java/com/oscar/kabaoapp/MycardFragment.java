package com.oscar.kabaoapp;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import com.oscar.kabaoapp.ViewModel.AddedCreditCardViewModel;
import com.oscar.kabaoapp.dataObject.Creditcard;
import com.oscar.kabaoapp.listadapter.ExistingCardListAdapter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link MycardFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link MycardFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MycardFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String EXISTING_CARDS = "existingCards";

    private AddedCreditCardViewModel mCardsViewModel;

    private ArrayList<Creditcard> existingCards;
    private ExistingCardListAdapter cardListAdapter;
    private ListView existingCardListView;

    public static HashMap<Integer, Boolean> cardFlipStatus;

    private OnFragmentInteractionListener mListener;

    public MycardFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     * @return A new instance of fragment MycardFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static MycardFragment newInstance(ArrayList<Creditcard> existingCards) {
        MycardFragment fragment = new MycardFragment();
        Bundle args = new Bundle();
        args.putParcelableArrayList(EXISTING_CARDS,existingCards);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            existingCards = getArguments().getParcelableArrayList(EXISTING_CARDS);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_mycard, container, false);

        populateCardFlipStatus();

        cardListAdapter = new ExistingCardListAdapter(getActivity(),existingCards);
        existingCardListView =  view.findViewById(R.id.listview_mycard);
        existingCardListView.setAdapter(cardListAdapter);
        // Inflate the layout for this fragment
        return view;
    }

    private void populateCardFlipStatus()
    {
        if(existingCards == null)
            return;

        cardFlipStatus = new HashMap<>();

        for(Creditcard card : existingCards)
        {
            cardFlipStatus.put(card.getId(), false);
        }
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }



    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }

//    private void loadFakeData()
//    {
//        MockCreditCardDataProvider dataProvider = new MockCreditCardDataProvider();
//        existingCards = dataProvider.getExistingCards();
//    }

}
