package com.example.android.savinginstancestate.views;

import android.os.Bundle;
import android.os.Parcelable;

import java.io.Serializable;

public class ViewStateHelper
{
    private static final String KEY = "state";

    public static Parcelable saveInstanceState(Parcelable superState, Bundle bundle)
    {
        return new SavedState(superState, bundle);
    }

    public static <T extends Serializable> Parcelable saveInstanceState(Parcelable superState, T serializable)
    {
        Bundle bundle = new Bundle();
        bundle.putSerializable(KEY, serializable);

        return saveInstanceState(superState, bundle);
    }

    @SuppressWarnings("unchecked")
    public static <T extends Serializable> T restoreInstanceState(Parcelable state)
    {
        SavedState savedState = (SavedState)state;
        Bundle bundle = savedState.getBundle();

        return (T)bundle.getSerializable(KEY);
    }

    public static Parcelable getSuperState(Parcelable state)
    {
        return ((SavedState)state).getSuperState();
    }
}
