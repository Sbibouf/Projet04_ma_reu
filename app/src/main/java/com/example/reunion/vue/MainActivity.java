package com.example.reunion.vue;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.reunion.adapters.MyReunionAdapter;
import com.example.reunion.databinding.ActivityMainBinding;
import com.example.reunion.model.Reunion;
import com.example.reunion.service.FakeReunionApiService;
import com.example.reunion.service.ReunionApiService;

import java.util.List;

public class MainActivity extends AppCompatActivity {


    private MyReunionAdapter adapter;
    private ActivityMainBinding binding;
    private ReunionApiService mApiService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        InitUI();
        ajouter_reunion();


    }

    public void InitUI() {
        mApiService = new FakeReunionApiService();
        adapter = new MyReunionAdapter(mApiService.getReunions());
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        binding.recyclerView.addItemDecoration(new DividerItemDecoration(getApplicationContext(), DividerItemDecoration.VERTICAL));
        binding.recyclerView.setAdapter(adapter);
    }

    public void refresh(){

        adapter.updateList(mApiService.getReunions());
    }



    public void ajouter_reunion() {

        binding.floatingActionButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    Intent intent = new Intent(MainActivity.this, AjouterReunionActivity.class);
                    startActivity(intent);

            }
        });


    }

    @Override
    protected void onResume() {
        super.onResume();
        InitUI();
    }
}