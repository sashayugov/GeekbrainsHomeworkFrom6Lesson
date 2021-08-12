package com.example.geekbrainshomeworkfromlesson6;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.UUID;


public class NotesFragment extends Fragment {

    private boolean isLandscape;
    private CardSource cardSource;
    private NotesAdapter notesAdapter;
    private RecyclerView recyclerView;
    private int currentPosition = -1;

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
        view.showContextMenu();
        registerForContextMenu(recyclerView);
    }

    private void initList(View view) {
        recyclerView = requireView().findViewById(R.id.recycler_notes);
        cardSource = new CardSourceFirebaseImpl();
        cardSource.init(cardSource -> notesAdapter.notifyDataSetChanged());
        notesAdapter = new NotesAdapter(cardSource);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(notesAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getContext()));
        notesAdapter.setLongListener(position -> currentPosition = position);
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

    @Override
    public void onCreateContextMenu(@NonNull ContextMenu menu, @NonNull View v,
                                    @Nullable ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater mInflater = requireActivity().getMenuInflater();
        mInflater.inflate(R.menu.card_menu, menu);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_update:
                CardData cardData = new CardData("Note", "Details");
                cardData.setId(cardSource.getCardData(currentPosition).getId());
                cardSource.updateCardData(currentPosition, cardData);
                notesAdapter.notifyItemChanged(currentPosition);
                return true;
            case R.id.action_delete:
                cardSource.deleteCardData(currentPosition);
                notesAdapter.notifyItemRemoved(currentPosition);
                return true;
        }

        return super.onContextItemSelected(item);
    }

    public void addNote() {
        CardData cardData = new CardData("note", "details");
        cardData.setId(UUID.randomUUID().toString());
        cardSource.addCardData(cardData);
        notesAdapter.notifyItemInserted(cardSource.size() - 1);
        recyclerView.scrollToPosition(cardSource.size() - 1);
    }

    public void clearAllNotes() {
        cardSource.clearCardData();
        notesAdapter.notifyDataSetChanged();
    }

}

