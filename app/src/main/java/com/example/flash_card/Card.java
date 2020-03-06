package com.example.flash_card;

import android.media.Image;
import android.os.Parcelable;
import android.os.Parcel;

import java.util.Map;

public class Card implements Parcelable {

    int image;
    String question;
    String reponse1;
    String reponse2;
    String reponse3;
    String reponse;

    public Card(int image, String question, String reponse1, String reponse2, String reponse3, String reponse) {
        this.image = image;
        this.question = question;
        this.reponse1 = reponse1;
        this.reponse2 = reponse2;
        this.reponse3 = reponse3;
        this.reponse = reponse;
    }

    protected Card(Parcel in) {
        image = in.readInt();
        question = in.readString();
        reponse1 = in.readString();
        reponse2 = in.readString();
        reponse3 = in.readString();
        reponse = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(image);
        dest.writeString(question);
        dest.writeString(reponse1);
        dest.writeString(reponse2);
        dest.writeString(reponse3);
        dest.writeString(reponse);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Card> CREATOR = new Creator<Card>() {
        @Override
        public Card createFromParcel(Parcel in) {
            return new Card(in);
        }

        @Override
        public Card[] newArray(int size) {
            return new Card[size];
        }
    };
}