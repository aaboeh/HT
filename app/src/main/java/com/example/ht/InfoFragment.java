package com.example.ht;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class InfoFragment extends Fragment {

    private RecyclerView recyclerView;
    private TextView textMunicipalityName;
    private ArrayList<String> municipalityInfo;


    private Context context;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_info, container, false);
        textMunicipalityName = view.findViewById(R.id.textMunicipalityName);
        municipalityInfo = new ArrayList<>();
        String dataText = MainActivity.getRecentInput(0);
        textMunicipalityName.setText(dataText);
        municipalityInfo.add(WeatherData.getName());
        municipalityInfo.add(WeatherData.getMain());
        municipalityInfo.add(WeatherData.getDescription());
        municipalityInfo.add(WeatherData.getTemperature());
        municipalityInfo.add(WeatherData.getWindSpeed());
        recyclerView = view.findViewById(R.id.rvMunicipalityInfo);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        InfoListAdapter adapter = new InfoListAdapter(context, municipalityInfo);
        recyclerView.setAdapter(adapter);
        //adapter.notifyDataSetChanged();
        //String weather = getArguments().getString("dataID");

        if (getArguments() != null) {
            //String weather = getArguments().getString("dataID");
        }

        return view;
    }
}