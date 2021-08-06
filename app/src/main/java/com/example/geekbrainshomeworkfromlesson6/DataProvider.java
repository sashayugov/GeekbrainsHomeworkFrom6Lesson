package com.example.geekbrainshomeworkfromlesson6;

import android.content.res.Resources;

import androidx.annotation.NonNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DataProvider {

    public static List<CardData> getData(@NonNull Resources resources) {
        return new ArrayList<>(Arrays.asList(
                new CardData(
                        resources.getString(R.string.shopping_list_note),
                        resources.getString(R.string.shopping_list_detail)
                ),
                new CardData(
                        resources.getString(R.string.travel_note),
                        resources.getString(R.string.travel_detail)

                ),
                new CardData(
                        resources.getString(R.string.todo_note),
                        resources.getString(R.string.todo_detail)
                )
        ));
    }
}
