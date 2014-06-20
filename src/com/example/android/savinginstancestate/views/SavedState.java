package com.example.android.savinginstancestate.views;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.View;

public class SavedState extends View.BaseSavedState
{
    private Bundle bundle;

    public SavedState(Parcelable superState, Bundle bundle)
    {
        super(superState);
        this.bundle = bundle;
    }

    private SavedState(Parcel in)
    {
        super(in);

        this.bundle = in.readBundle();
    }

    public Bundle getBundle()
    {
        return this.bundle;
    }

    @Override
    public void writeToParcel(Parcel destination, int flags)
    {
        super.writeToParcel(destination, flags);

        destination.writeBundle(this.bundle);
    }

    public static final Creator<SavedState> CREATOR = new Creator<SavedState>()
    {
        public SavedState createFromParcel(Parcel in)
        {
            return new SavedState(in);
        }

        public SavedState[] newArray(int size)
        {
            return new SavedState[size];
        }
    };

}
