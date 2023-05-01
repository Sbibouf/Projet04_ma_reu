package com.example.reunion.vue;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.reunion.Repository.ReunionRepository;
import com.example.reunion.adapters.MyReunionAdapter;
import com.example.reunion.databinding.ActivityMainBinding;
import com.example.reunion.model.Reunion;
import com.example.reunion.viewModel.MainViewModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    private MyReunionAdapter adapter;
    private ActivityMainBinding binding;
    private MainViewModel mMainViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        mMainViewModel = new ViewModelProvider(this).get(MainViewModel.class);
        initUI();
        ajouterReunion();


    }

    public void initUI() {

        adapter = new MyReunionAdapter(mMainViewModel.getReunions());
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        binding.recyclerView.addItemDecoration(new DividerItemDecoration(getApplicationContext(), DividerItemDecoration.VERTICAL));
        binding.recyclerView.setAdapter(adapter);
    }


    public void ajouterReunion() {

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
        initUI();
    }
}