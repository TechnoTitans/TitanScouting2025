package com.scoutingapp.titanscouting.database;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.recyclerview.widget.RecyclerView;

import com.scoutingapp.titanscouting.R;
import com.scoutingapp.titanscouting.views.logs.SingleMatchView;

public class MatchViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    private final Button matchNumView;
    private MatchViewHolder(View itemView) {
        super(itemView);
        matchNumView = (Button) itemView.findViewById(R.id.match_button);
    }

    public void bind(int text) {
        matchNumView.setText(String.valueOf(text));
    }

    static MatchViewHolder create(ViewGroup parent) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recyclerview_item, parent, false);

        return new MatchViewHolder(view);
    }

    @Override
    public void onClick(View v) {
        Intent i = new Intent(this.itemView.getContext(), SingleMatchView.class);
        i.putExtra("matchNumber", matchNumView.getText().toString());
    }
}
