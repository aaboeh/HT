package com.example.ht;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class InfoListAdapter extends RecyclerView.Adapter<InfoViewHolder> {

    private Context context;

    public InfoListAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public InfoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new InfoViewHolder(LayoutInflater.from(context).inflate(R.layout.info_view, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull InfoViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 1;
    }
}
