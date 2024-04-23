package com.example.ht;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class InfoListAdapter extends RecyclerView.Adapter<InfoViewHolder> {

    private Context context;
    ArrayList<String> municipalityInfo;

    public InfoListAdapter(Context context, ArrayList<String> municipalityInfo) {
        this.context = context;
        this.municipalityInfo = municipalityInfo;
    }

    @NonNull
    @Override
    public InfoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new InfoViewHolder(LayoutInflater.from(context).inflate(R.layout.info_view, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull InfoViewHolder holder, int position) {
        String municipalityPopulation = municipalityInfo.get(position);
        InfoViewHolder.municipalityPopulation.setText(municipalityPopulation);
    }

    @Override
    public int getItemCount() {
        return municipalityInfo.size();
    }
}
