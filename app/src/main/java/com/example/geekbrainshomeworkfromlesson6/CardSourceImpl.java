package com.example.geekbrainshomeworkfromlesson6;

import android.content.Context;

public class CardSourceImpl implements CardSource {

    private Context context;

    public CardSourceImpl(Context context) {
        this.context = context;
    }

    @Override
    public CardData getCardData(int position) {
        return DataProvider.getData(context.getResources())[position];
    }

    @Override
    public int size() {
        return DataProvider.getData(context.getResources()).length;
    }
}
