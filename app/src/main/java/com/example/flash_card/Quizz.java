package com.example.flash_card;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

public class Quizz implements Parcelable {
    List <Card> cards;
    int count;
    int ga;

    protected Quizz(Parcel in) {
        cards = in.createTypedArrayList(Card.CREATOR);
        count = in.readInt();
        ga = in.readInt();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeTypedList(cards);
        dest.writeInt(count);
        dest.writeInt(ga);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Quizz> CREATOR = new Creator<Quizz>() {
        @Override
        public Quizz createFromParcel(Parcel in) {
            return new Quizz(in);
        }

        @Override
        public Quizz[] newArray(int size) {
            return new Quizz[size];
        }
    };
}
