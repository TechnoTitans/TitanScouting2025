package com.scoutingapp.titanscouting.views.logs;


import android.app.Activity;
import android.content.Intent;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;

import com.scoutingapp.titanscouting.database.Match;
import com.scoutingapp.titanscouting.views.Summary;
import com.scoutingapp.titanscouting.views.logs.MatchViewHolder;

import android.os.Handler;

public class MatchListAdapter extends ListAdapter<Match, MatchViewHolder> {
    private final Activity parentActivity;

    public MatchListAdapter(@NonNull DiffUtil.ItemCallback<Match> diffCallback, Activity parentActivity) {
        super(diffCallback);
        this.parentActivity = parentActivity;
    }

    @Override
    public MatchViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return MatchViewHolder.create(parent);
    }

    @Override
    public void onBindViewHolder(MatchViewHolder holder, int position) {
        Match current = getItem(position);
        holder.bind(current.getMatchNum());

        holder.getButton().setOnClickListener(v -> {
            Intent i = new Intent(v.getContext(), Summary.class);
            i.putExtra("matchNumber", Integer.parseInt(((Button) (holder.getButton())).getText().toString().split(": ")[1]));
            v.getContext().startActivity(i);
            parentActivity.finish();
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
