package com.example.ht;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class InfoViewHolder extends RecyclerView.ViewHolder {
    TextView municipalityPopulation;

    public InfoViewHolder(@NonNull View itemView) {
        super(itemView);
        municipalityPopulation = itemView.findViewById(R.id.textPopulation);
    }
}
