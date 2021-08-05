package com.example.geekbrainshomeworkfromlesson6;

import android.content.res.Resources;

import androidx.annotation.NonNull;

public class DataProvider {

    public static CardData[] getData(@NonNull Resources resources) {
        return new CardData[]{
                new CardData(
                        resources.getString(R.string.shopping_list)
                ),
                new CardData(
                        resources.getString(R.string.travel)
                ),
                new CardData(
                        resources.getString(R.string.todo)
                ),
                new CardData(
                        resources.getString(R.string.note)
                ),
                new CardData(
                        resources.getString(R.string.note)
                ),
                new CardData(
                        resources.getString(R.string.note)
                ),
                new CardData(
                        resources.getString(R.string.note)
                ),
                new CardData(
                        resources.getString(R.string.note)
                ),
                new CardData(
                        resources.getString(R.string.note)
                ),
                new CardData(
                        resources.getString(R.string.note)
                ),
                new CardData(
                        resources.getString(R.string.note)
                ),
                new CardData(
                        resources.getString(R.string.note)
                ),
                new CardData(
                        resources.getString(R.string.note)
                ),
                new CardData(
                        resources.getString(R.string.note)
                ),
                new CardData(
                        resources.getString(R.string.note)
                ),
                new CardData(
                        resources.getString(R.string.note)
                ),
                new CardData(
                        resources.getString(R.string.note)
                ),
                new CardData(
                        resources.getString(R.string.note)
                ),
                new CardData(
                        resources.getString(R.string.note)
                ),
                new CardData(
                        resources.getString(R.string.note)
                ),
                new CardData(
                        resources.getString(R.string.note)
                ),
                new CardData(
                        resources.getString(R.string.note)
                ),
                new CardData(
                        resources.getString(R.string.note)
                ),
                new CardData(
                        resources.getString(R.string.note)
                ),
                new CardData(
                        resources.getString(R.string.note)
                ),
                new CardData(
                        resources.getString(R.string.note)
                ),
                new CardData(
                        resources.getString(R.string.note)
                )
        };
    }
}
