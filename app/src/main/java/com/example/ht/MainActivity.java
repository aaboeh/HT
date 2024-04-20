package com.example.ht;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Button buttonGetInfo;
    private EditText textMunicipality;
    private ArrayList<String> recentInputs;
    private RecyclerView recyclerView;
    private RecentInputAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textMunicipality = findViewById(R.id.textMunicipality);
        buttonGetInfo = findViewById(R.id.buttonGetInfo);
        recentInputs = new ArrayList<>();
        adapter = new RecentInputAdapter(getApplicationContext(), recentInputs);
        recyclerView = findViewById(R.id.rvRecentInputs);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

        // onClickListener InfoActivity siirtymiseen
        buttonGetInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DataRetriever dataRetriever = new DataRetriever(MainActivity.this);
                dataRetriever.fetchData();
                String municipalityName = getMunicipalityName();
                addRecentInput(municipalityName);
                startActivity(new Intent(MainActivity.this, InfoActivity.class));
            }
        });

    }

    @Override
    public void onResume() {
        super.onResume();
        adapter.notifyDataSetChanged();
    }

    public void switchToInfo(View view) {
        Intent intent = new Intent(this, InfoActivity.class);
        startActivity(intent);
    }

    public String getMunicipalityName() {
        return textMunicipality.getText().toString();
    }

    public void addRecentInput(String input) {
        recentInputs.add(0, input);
        if (recentInputs.size() > 5) {
            recentInputs.remove(5);
        }
    }


}