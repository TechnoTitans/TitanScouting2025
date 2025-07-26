package com.scoutingapp.titanscouting.views.logs;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.recyclerview.widget.RecyclerView;

import com.scoutingapp.titanscouting.R;

public class MatchViewHolder extends RecyclerView.ViewHolder{
    private final Button matchNumView;

    private MatchViewHolder(View itemView) {
        super(itemView);
        matchNumView = itemView.findViewById(R.id.match_button);
    }

    public View getButton(){
        return matchNumView;
    }

    public void bind(int text) {
        matchNumView.setText("Match: " + text);
    }


    static MatchViewHolder create(ViewGroup parent) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recyclerview_item, parent, false);

        return new MatchViewHolder(view);
    }
}
