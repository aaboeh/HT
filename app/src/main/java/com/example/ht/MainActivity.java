package com.example.ht;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainActivity extends AppCompatActivity implements Serializable {

    private Button buttonGetInfo;
    private EditText editTextMunicipality;
    private ArrayList<String> recentInputs;
    private RecyclerView recyclerView;
    private RecentInputAdapter adapter;
    private TextView textMunicipalityPopulation;

//kommentoitu jotain kohtia pois

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextMunicipality = findViewById(R.id.textMunicipality);
        buttonGetInfo = findViewById(R.id.buttonGetInfo);
        recentInputs = new ArrayList<>();
        adapter = new RecentInputAdapter(getApplicationContext(), recentInputs);
        recyclerView = findViewById(R.id.rvRecentInputs);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
        Context context = this;
        textMunicipalityPopulation = findViewById(R.id.textMunicipalityPopulation);

        // onClickListener InfoActivity siirtymiseen
        buttonGetInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                DataRetriever dataRetriever = new DataRetriever(MainActivity.this);
                WeatherDataRetriever wr = new WeatherDataRetriever();
                String municipality = editTextMunicipality.getText().toString();
                //dataRetriever.fetchData();

                ExecutorService service = Executors.newSingleThreadExecutor();
                service.execute(new Runnable() {
                    @Override
                    public void run() {
                        ArrayList<MunicipalityData> populationData = dataRetriever.getMunicipalityData(context, municipality);
                        WeatherData weatherData = wr.getWeatherData(municipality);

                        if (populationData == null) {
                            return;
                        }
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                String s = "";
                                for (MunicipalityData data : populationData) {
                                    s = s + data.getYear() + ": " + data.getPopulation() + "\n";
                                }
                                //s = s + populationData.get(populationData.size()-1).getYear() + ": " + populationData.get(populationData.size()-1).getPopulation() + "\n";
                                textMunicipalityPopulation.setText(s);
                            }
                        });
                        //Log.d("LUT", "Data haettu");
                    }
                });

                String municipalityName = getMunicipalityName();
                addRecentInput(municipalityName);
                Log.d("Lut", "Nappula toimii");
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
        return editTextMunicipality.getText().toString();
    }

    public void addRecentInput(String input) {
        recentInputs.add(0, input);
        if (recentInputs.size() > 5) {
            recentInputs.remove(5);
        }
    }



}