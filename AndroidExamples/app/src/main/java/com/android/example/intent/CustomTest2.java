package com.android.example.intent;

import android.os.Parcel;
import android.os.Parcelable;

public class CustomTest2 implements Parcelable{
    public String name;
    public int age;

    public CustomTest2(){}

    public CustomTest2(Parcel p) {
        readFromParcel(p);
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeInt(age);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    private void readFromParcel(Parcel in ) {
        name = in.readString();
        age = in.readInt();
    }

    public static final Parcelable.Creator CREATOR = new Parcelable.Creator(){
        @Override
        public CustomTest2 createFromParcel(Parcel source) {
            return new CustomTest2(source);
        }

        @Override
        public CustomTest2[] newArray(int size) {
            return new CustomTest2[size];
        }
    };
}