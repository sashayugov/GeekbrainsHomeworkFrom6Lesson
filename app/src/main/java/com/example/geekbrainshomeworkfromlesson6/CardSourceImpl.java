package com.example.geekbrainshomeworkfromlesson6;

import android.content.Context;

public class CardSourceImpl implements CardSource {

    private Context context;

    public CardSourceImpl(Context context) {
        this.context = context;
    }

    @Override
    public CardData getCardData(int position) {
        return DataProvider.getData(context.getResources()).get(position);
    }

    @Override
    public void deleteCardData(int position) {
        DataProvider.getData(context.getResources()).remove(position);
    }

    @Override
    public void updateCardData(int position, CardData cardData) {
        DataProvider.getData(context.getResources()).set(position, cardData);
    }

    @Override
    public void addCardData(CardData cardData) {
        DataProvider.getData(context.getResources()).add(cardData);
    }

    @Override
    public void clearCardData() {
        DataProvider.getData(context.getResources()).clear();
    }

    @Override
    public int size() {
        return DataProvider.getData(context.getResources()).size();
    }
}
