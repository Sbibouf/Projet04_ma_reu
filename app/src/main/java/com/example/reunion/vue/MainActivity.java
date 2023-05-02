package com.example.reunion.vue;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.reunion.R;
import com.example.reunion.Repository.ReunionRepository;
import com.example.reunion.adapters.MyReunionAdapter;
import com.example.reunion.databinding.ActivityMainBinding;
import com.example.reunion.model.Reunion;
import com.example.reunion.service.ItemClickSupport;
import com.example.reunion.service.SupprimerReunionService;
import com.example.reunion.viewModel.MainViewModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements SupprimerReunionService {


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
        //supprimerReunion();


    }

    public void initUI() {

        adapter = new MyReunionAdapter(mMainViewModel.getReunions(),this );
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
    public void supprimerReunion(){


        ItemClickSupport.addTo(binding.recyclerView, R.layout.fragment_reunion_)
                .setOnItemClickListener(new ItemClickSupport.OnItemClickListener() {
                    @Override
                    public void onItemClicked(RecyclerView recyclerView, int position, View v) {
                   Reunion reunion = adapter.getReunions(position);
                   mMainViewModel.supprimer_Reunion(reunion);
                    }
                });
    }

    @Override
    protected void onResume() {
        super.onResume();
        initUI();
    }

    @Override
    public void supprimerReunion(Reunion reunion) {
        mMainViewModel.supprimer_Reunion(reunion);
        initUI();
    }
}