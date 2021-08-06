package com.example.geekbrainshomeworkfromlesson6;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


public class NotesFragment extends Fragment {

    private boolean isLandscape;
    CardSource cardSource;
    NotesAdapter notesAdapter;
    RecyclerView recyclerView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_notes, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        isLandscape = getResources().getConfiguration().orientation
                == Configuration.ORIENTATION_LANDSCAPE;
        if (isLandscape) {
            showLandDetails(0);
        }
        initList(view);
    }

    private void initList(View view) {
        recyclerView = requireView().findViewById(R.id.recycler_notes);
        cardSource = new CardSourceImpl(this.getContext());
        notesAdapter = new NotesAdapter(cardSource);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(notesAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getContext()));
        notesAdapter.setListener(this::showDetails);
    }

    private void showDetails(int index) {
        if (isLandscape) {
            showLandDetails(index);
        } else {
            showPortDetails(index);
        }
    }

    private void showLandDetails(int index) {
        DetailFragment d = DetailFragment.newInstance(index);
        requireActivity().getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.details, d)
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                .commit();
    }

    private void showPortDetails(int index) {
        DetailFragment d = DetailFragment.newInstance(index);
        requireActivity().getSupportFragmentManager()
                .beginTransaction()
                .addToBackStack(null)
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                .replace(R.id.notes, d)
                .commit();
    }


}



