package com.example.geekbrainshomeworkfromlesson6;

import com.google.firebase.firestore.Exclude;

public class CardData {

    @Exclude
    private String id;
    private String note;
    private String detail;

    public CardData() {
    }

    public CardData(String note, String detail) {
        this.note = note;
        this.detail = detail;
    }

    public String getNote() {
        return note;
    }

    public String getDetail() {
        return detail;
    }
    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }
}
