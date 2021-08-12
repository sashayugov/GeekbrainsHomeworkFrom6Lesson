package com.example.geekbrainshomeworkfromlesson6;

public interface CardSource {

    CardSource init(CardSourceResponse response);
    CardData getCardData(int position);
    void deleteCardData(int position);
    void updateCardData(int position, CardData cardData);
    void addCardData(CardData cardData);
    void clearCardData();
    int size();
}
