package com.example.ht;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class RecentInputHolder extends RecyclerView.ViewHolder {
    TextView textRecentInput;

    public RecentInputHolder(@NonNull View itemView) {
        super(itemView);
        textRecentInput = itemView.findViewById(R.id.textRecentInput);
    }
}
