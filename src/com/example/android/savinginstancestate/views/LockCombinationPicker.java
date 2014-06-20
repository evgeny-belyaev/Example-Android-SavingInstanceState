package com.example.android.savinginstancestate.views;

import android.content.Context;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.NumberPicker;
import com.example.android.savinginstancestate.R;

import java.io.Serializable;

public class LockCombinationPicker extends LinearLayout
{

    private class State implements Serializable
    {
        public int n1;
        public int n2;
        public int n3;
    }

    private NumberPicker numberPicker1;
    private NumberPicker numberPicker2;
    private NumberPicker numberPicker3;

    public LockCombinationPicker(Context context)
    {
        this(context, null);
    }

    public LockCombinationPicker(Context context, AttributeSet attrs)
    {
        this(context, attrs, 0);
    }

    public LockCombinationPicker(Context context, AttributeSet attrs, int defStyle)
    {
        super(context, attrs, defStyle);

        loadViews();
    }

    private void loadViews()
    {
        LayoutInflater.from(getContext()).inflate(R.layout.lock_combination_picker, this, true);

        numberPicker1 = (NumberPicker)findViewById(R.id.number1);
        numberPicker1.setMinValue(0);
        numberPicker1.setMaxValue(10);

        numberPicker2 = (NumberPicker)findViewById(R.id.number2);
        numberPicker2.setMinValue(0);
        numberPicker2.setMaxValue(10);

        numberPicker3 = (NumberPicker)findViewById(R.id.number3);
        numberPicker3.setMinValue(0);
        numberPicker3.setMaxValue(10);
    }

    @Override
    protected Parcelable onSaveInstanceState()
    {
        State s = new State();
        s.n1 = numberPicker1.getValue();
        s.n2 = numberPicker2.getValue();
        s.n3 = numberPicker3.getValue();

        return ViewStateHelper.saveInstanceState(super.onSaveInstanceState(), s);
    }

    @Override
    protected void onRestoreInstanceState(Parcelable state)
    {
        super.onRestoreInstanceState(ViewStateHelper.getSuperState(state));

        State s = ViewStateHelper.restoreInstanceState(state);

        numberPicker1.setValue(s.n1);
        numberPicker2.setValue(s.n2);
        numberPicker3.setValue(s.n3);
    }

    @Override
    protected void dispatchSaveInstanceState(SparseArray<Parcelable> container)
    {
        // As we save our own instance state, ensure our children don't save and restore their state as well.
        super.dispatchFreezeSelfOnly(container);
    }

    @Override
    protected void dispatchRestoreInstanceState(SparseArray<Parcelable> container)
    {
        /** See comment in {@link #dispatchSaveInstanceState(android.util.SparseArray)}  */
        super.dispatchThawSelfOnly(container);
    }

    /**
     * Convenience class to save / restore the lock combination picker state. Looks clumsy
     * but once created is easy to maintain and use.
     */

}

