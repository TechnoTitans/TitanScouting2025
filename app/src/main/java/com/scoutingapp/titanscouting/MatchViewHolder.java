package com.scoutingapp.titanscouting;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class MatchViewHolder extends RecyclerView.ViewHolder {
    private final TextView matchItemView;

    private MatchViewHolder(View itemView) {
        super(itemView);
        matchItemView = itemView.findViewById(R.id.textView);
    }

    public void bind(int text) {
        matchItemView.setText(text + "");
    }

    static MatchViewHolder create(ViewGroup parent) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recyclerview_item, parent, false);
        return new MatchViewHolder(view);
    }
}
