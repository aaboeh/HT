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

public class InfoFragment extends Fragment {

    private RecyclerView recyclerView;
    private TextView textMunicipalityName;


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

        if (getArguments() != null) {
            String dataText = getArguments().getString("dataID");
            textMunicipalityName.setText(dataText);
        }


        /*recyclerView = view.findViewById(R.id.rvMunicipalityInfo);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        recyclerView.setAdapter(new InfoListAdapter(context));*/

        return view;
    }
}