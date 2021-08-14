package com.example.geekbrainshomeworkfromlesson6;

import android.util.Log;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;



public class CardSourceFirebaseImpl implements CardSource{
    
    private static final String COLLECTION = "CARDS";
    private static final String TAG = "CardSourceFirebaseImpl";

    private FirebaseFirestore db = FirebaseFirestore.getInstance();
    private CollectionReference collection = db.collection(COLLECTION);
    private List<CardData> cards = new ArrayList<>();


    @Override
    public CardSource init(CardSourceResponse response) {
        collection.get()
                .addOnCompleteListener(task -> {
                    if (task.isSuccessful()) {
                        cards = new ArrayList<>();
                        for (QueryDocumentSnapshot document: task.getResult()) {
                            CardData data = document.toObject(CardData.class);
                            data.setId(document.getId());
                            cards.add(data);
                        }
                    }
                })
                .addOnFailureListener(e -> {
                    Log.e(TAG, "failed", e);
                });
        return this;
    }

    @Override
    public CardData getCardData(int position) {
        return cards.get(position);
    }

    @Override
    public void deleteCardData(int position) {
        collection.document(cards.get(position).getId()).delete();
        cards.remove(position);
    }

    @Override
    public void updateCardData(int position, CardData cardData) {
        collection.document(cardData.getId()).set(cardData);
        cards.set(position, cardData);
    }

    @Override
    public void addCardData(CardData cardData) {
        collection.document(cardData.getId()).set(cardData);
        cards.add(cardData);
    }

    @Override
    public void clearCardData() {
        for (CardData cardData : cards) {
            collection.document(cardData.getId()).delete();
        }
        cards.clear();
    }

    @Override
    public int size() {
        return cards.size();
    }
}
