package com.example.geekbrainshomeworkfromlesson6;

import android.content.Context;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CardSourceImpl implements CardSource {

    private Context context;
    private static List<CardData> cards;

    public CardSourceImpl(Context context) {
        this.context = context;



    }

    @Override
    public CardSource init(CardSourceResponse response) {
        cards = new ArrayList<>(Arrays.asList(
                new CardData(
                        context.getString(R.string.shopping_list_note),
                        context.getString(R.string.shopping_list_detail)
                ),
                new CardData(
                        context.getString(R.string.travel_note),
                        context.getString(R.string.travel_detail)

                ),
                new CardData(
                        context.getString(R.string.todo_note),
                        context.getString(R.string.todo_detail)
                )
        ));

        if (response != null) {
            response.initialized(this);
        }



        return this;
    }

    @Override
    public CardData getCardData(int position) {
        return cards.get(position);
    }

    @Override
    public void deleteCardData(int position) {
        cards.remove(position);
    }

    @Override
    public void updateCardData(int position, CardData cardData) {
        cards.set(position, cardData);
    }

    @Override
    public void addCardData(CardData cardData) {
        cards.add(cardData);
    }

    @Override
    public void clearCardData() {
        cards.clear();
    }

    @Override
    public int size() {
        return cards.size();
    }
}
