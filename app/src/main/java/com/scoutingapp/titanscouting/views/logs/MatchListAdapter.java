package com.scoutingapp.titanscouting.views.logs;


import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;

import com.scoutingapp.titanscouting.database.Match;
import com.scoutingapp.titanscouting.views.logs.MatchViewHolder;


public class MatchListAdapter extends ListAdapter<Match, MatchViewHolder> {
    public MatchListAdapter(@NonNull DiffUtil.ItemCallback<Match> diffCallback) {
        super(diffCallback);
    }

    @Override
    public MatchViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return MatchViewHolder.create(parent);
    }

    @Override
    public void onBindViewHolder(MatchViewHolder holder, int position) {
        Match current = getItem(position);
        holder.bind(current.getMatchNum());

        holder.getButton().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(v.getContext(), SingleMatchView.class);
                i.putExtra("matchNumber", ((Button) (holder.getButton())).getText().toString().split(": ")[1]);
                v.getContext().startActivity(i);
            }
        });

    }


    public static class MatchDiff extends DiffUtil.ItemCallback<Match> {
        @Override
        public boolean areItemsTheSame(@NonNull Match oldItem, @NonNull Match newItem) {
            return oldItem == newItem;
        }

        @Override
        public boolean areContentsTheSame(@NonNull Match oldItem, @NonNull Match newItem) {
            return oldItem.getMatchNum() == newItem.getMatchNum();
        }
    }
}
