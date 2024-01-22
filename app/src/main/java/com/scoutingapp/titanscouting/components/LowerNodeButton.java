package com.scoutingapp.titanscouting.components;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.Button;

import androidx.core.content.ContextCompat;

import com.scoutingapp.titanscouting.R;

public class LowerNodeButton extends androidx.appcompat.widget.AppCompatButton {
    private int state; // 0 - Not scored, 1 - Scored Cube, 2 - Scored Cone
    private final int gray = ContextCompat.getColor(getContext(), R.color.lightgray);
    private final int purple = ContextCompat.getColor(getContext(), R.color.purple);
    private final int yellow = ContextCompat.getColor(getContext(), R.color.yellow);


    public LowerNodeButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        state = 0;
    }

    @Override
    public boolean performClick() {
        state = (state + 1) % 3;

        switch (state) {
            case 0:
                setBackgroundColor(gray);
                break;
            case 1:
                setBackgroundColor(purple);
                break;
            case 2:
                setBackgroundColor(yellow);
                break;
        }

        return super.performClick();
    }
}