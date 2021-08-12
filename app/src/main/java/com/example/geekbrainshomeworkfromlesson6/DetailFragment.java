package com.example.geekbrainshomeworkfromlesson6;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.Objects;

public class DetailFragment extends Fragment {


    static final String ARG_INDEX = "index";
    private static int index;

    public DetailFragment() {
    }


    public static DetailFragment newInstance(int index) {
        DetailFragment fragment = new DetailFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_INDEX, index);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            index = getArguments().getInt(ARG_INDEX);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_detail, container, false);
        TextView textView = view.findViewById(R.id.text);
        CardSource cardSource = new CardSourceImpl(this.requireContext());
        CardData cardData = cardSource.getCardData(index);
        String detailText = cardData.getDetail();
        textView.setText(detailText);
        textView.setTextSize(20);
        return view;
    }
}