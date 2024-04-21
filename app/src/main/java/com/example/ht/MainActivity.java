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

import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

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
                onFindBtnClick(v);
                /*
                String municipalityName = getMunicipalityName();
                addRecentInput(municipalityName);
                startActivity(new Intent(MainActivity.this, InfoActivity.class));
                 */

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

    public void onFindBtnClick(View view) {
        Log.d("tag", "nappula klikattu");
        Context context = this;

        DataRetriever dr = new DataRetriever();

        ExecutorService service = Executors.newSingleThreadExecutor();

        service.execute(new Runnable() {

            @Override
            public void run() {
                ArrayList<MunicipalityData> populationData = dr.getData(context, "Mikkeli");

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        // tässä voi päivittää mainactivityn näkymää apilla haetun datan avulla
                    }
                });
                Log.d("tag", "data haettu");
            }
        });
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