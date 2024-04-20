package com.example.ht;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecentInputAdapter extends RecyclerView.Adapter<RecentInputHolder> {
    private Context context;
    private ArrayList<String> recentInputs = new ArrayList<>();

    public RecentInputAdapter(Context context, ArrayList<String> recentInputs) {
        this.context = context;
        this.recentInputs = recentInputs;
    }

    @NonNull
    @Override
    public RecentInputHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new RecentInputHolder(LayoutInflater.from(context).inflate(R.layout.recent_input_view, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull RecentInputHolder holder, int position) {
        holder.textRecentInput.setText(String.valueOf((recentInputs.get(position))));
    }

    public int getItemCount() {
        return recentInputs.size();
    }
}
