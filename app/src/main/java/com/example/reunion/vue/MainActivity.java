package com.example.reunion.vue;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.DatePicker;
import android.widget.Toolbar;

import androidx.annotation.NonNull;
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

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Objects;

public class MainActivity extends AppCompatActivity implements SupprimerReunionService {



    private ActivityMainBinding binding;
    private MainViewModel mMainViewModel;
    private List<Reunion> mReunionList;

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
        MyReunionAdapter adapter;
        mReunionList = new ArrayList<>(mMainViewModel.getReunions());
        adapter = new MyReunionAdapter(mReunionList,this );
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        //binding.recyclerView.addItemDecoration(new DividerItemDecoration(getApplicationContext(), DividerItemDecoration.VERTICAL));
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

    @Override
    public void supprimerReunion(Reunion reunion) {
        mMainViewModel.supprimer_Reunion(reunion);
        initUI();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.filtre_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()){
            case R.id.filtre_date:
                filtrerDate();
                return true;
            case R.id.i_salle1:
                filtrerParSalle("Salle 1");
                return true;
            case R.id.i_salle2:
                filtrerParSalle("Salle 2");
                return true;
            case R.id.i_salle3:
                filtrerParSalle("Salle 3");
                return true;
            case R.id.i_salle4:
                filtrerParSalle("Salle 4");
                return true;
            case R.id.i_salle5:
                filtrerParSalle("Salle 5");
                return true;
            case R.id.i_salle6:
                filtrerParSalle("Salle 6");
                return true;
            case R.id.i_salle7:
                filtrerParSalle("Salle 7");
                return true;
            case R.id.i_salle8:
                filtrerParSalle("Salle 8");
                return true;
            case R.id.i_salle9:
                filtrerParSalle("Salle 9");
                return true;
            case R.id.i_salle10:
                filtrerParSalle("Salle 10");
                return true;
            case R.id.filtre_cancel:
                changerList(mMainViewModel.getReunions());
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }

    public void filtrerParSalle(String salle){
        List<Reunion> listeFiltrerParSalle = new ArrayList<>();
        for (Reunion reunion: mReunionList ) {
            if(Objects.equals(reunion.getSalle_reu(), salle)){
                listeFiltrerParSalle.add(reunion);
            }
        }
       changerList(listeFiltrerParSalle);

    }
    public void filtrerDate(){
        int selectedYear = 2023;
        int selectedMonth = 4;
        int selectedDay = 03;

        DatePickerDialog.OnDateSetListener dateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                Calendar dateSelectionne = Calendar.getInstance();
                dateSelectionne.set(year, month, dayOfMonth);
                changerList(mMainViewModel.getFilterReunionByDate(dateSelectionne.getTime()));
            }
        };

        DatePickerDialog datePickerDialog = new DatePickerDialog(this, dateSetListener, selectedYear, selectedMonth, selectedDay);
        datePickerDialog.show();

    }
    public void changerList(List<Reunion> reunions){
        mReunionList.clear();
        mReunionList.addAll(reunions);
        binding.recyclerView.getAdapter().notifyDataSetChanged();
    }
}