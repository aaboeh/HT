package com.example.ht;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class InfoViewHolder extends RecyclerView.ViewHolder {
    TextView municipalityName;

    public InfoViewHolder(@NonNull View itemView) {
        super(itemView);
        municipalityName = itemView.findViewById(R.id.textMunicipalityName);
    }
}
