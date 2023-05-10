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

/**
 * Point d'entré de ce projet
 *
 * @author adrie
 */
public class MainActivity extends AppCompatActivity implements SupprimerReunionService {


    //************************
    //Variables
    //************************

    private ActivityMainBinding binding; // Binding des elements graphiques du layout activity_main

    private MainViewModel mMainViewModel; // ViewModel lié a l'activité MainActivity

    private List<Reunion> mReunionList; // Liste de reunions a manipuler pour adapter l'affichage

    private MyReunionAdapter adapter; // Adapter de la recyclerview

    /**
     * Activity created
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        mMainViewModel = new ViewModelProvider(this).get(MainViewModel.class);
        initUI();
        ajouterReunion();
        configureOnClickRecyclerView();


    }

    /**
     * Initialisation of the UI
     */
    public void initUI() {
        mReunionList = new ArrayList<>(mMainViewModel.getReunions());
        adapter = new MyReunionAdapter(mReunionList,this );
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        binding.recyclerView.setAdapter(adapter);
    }


    /**
     * Initialisation of the button leading to the other activity
     */
    public void ajouterReunion() {

        binding.fbAjouterReunion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, AjouterReunionActivity.class);
                startActivity(intent);

            }
        });
    }

    /**
     * Reset of the UI when activity resume
     */
    @Override
    protected void onResume() {
        super.onResume();
        initUI();
    }

    /**
     * Overriding the methode for deleting a meeting then reset UI
     * @param reunion
     */
    @Override
    public void supprimerReunion(Reunion reunion) {
        mMainViewModel.supprimer_Reunion(reunion);
        initUI();
    }

    /**
     * Initialisation of the filter menu
     * @param menu
     * @return
     */

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.filtre_menu, menu);
        return true;
    }

    /**
     * Evry action for evry menu items
     * @param item
     * @return
     */
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()){
            case R.id.filtre_date://Affiche les reunions par date
                filtrerDate();
                return true;
            case R.id.i_salle1://Affiche les reunions de la salle 1
                changerList(mMainViewModel.reunionFiltrerParSalle("Salle 1"));
                return true;
            case R.id.i_salle2://Affiche les reunions de la salle 2
                changerList(mMainViewModel.reunionFiltrerParSalle("Salle 2"));
                return true;
            case R.id.i_salle3://Affiche les reunions de la salle 3
                changerList(mMainViewModel.reunionFiltrerParSalle("Salle 3"));
                return true;
            case R.id.i_salle4://Affiche les reunions de la salle 4
                changerList(mMainViewModel.reunionFiltrerParSalle("Salle 4"));
                return true;
            case R.id.i_salle5://Affiche les reunions de la salle 5
                changerList(mMainViewModel.reunionFiltrerParSalle("Salle 5"));
                return true;
            case R.id.i_salle6://Affiche les reunions de la salle 6
                changerList(mMainViewModel.reunionFiltrerParSalle("Salle 6"));
                return true;
            case R.id.i_salle7://Affiche les reunions de la salle 7
                changerList(mMainViewModel.reunionFiltrerParSalle("Salle 7"));
                return true;
            case R.id.i_salle8://Affiche les reunions de la salle 8
                changerList(mMainViewModel.reunionFiltrerParSalle("Salle 8"));
                return true;
            case R.id.i_salle9://Affiche les reunions de la salle 9
                changerList(mMainViewModel.reunionFiltrerParSalle("Salle 9"));
                return true;
            case R.id.i_salle10://Affiche les reunions de la salle 10
                changerList(mMainViewModel.reunionFiltrerParSalle("Salle 10"));
                return true;
            case R.id.filtre_cancel://Affiche toutes les reunions
                changerList(mMainViewModel.getReunions());
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }

    /**
     * Open a calendar to pick a date and call methode getFilterReunionByDate
     */
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

        DatePickerDialog datePickerDialog = new DatePickerDialog(this,android.R.style.Theme_DeviceDefault_Dialog, dateSetListener, selectedYear, selectedMonth, selectedDay);
        datePickerDialog.show();

    }

    /**
     * Change the meeting list to show only desire one
     * @param reunions
     */
    public void changerList(List<Reunion> reunions){
        mReunionList.clear();
        mReunionList.addAll(reunions);
        binding.recyclerView.getAdapter().notifyDataSetChanged();
    }

    /**
     * When we click on an item of the recyclerview we put it in an Extra and send it to the Activity DetailReunionActivity
     */
    private void configureOnClickRecyclerView() {
        ItemClickSupport.addTo(binding.recyclerView, R.layout.fragment_reunion_)
                .setOnItemClickListener(new ItemClickSupport.OnItemClickListener() {
                    @Override
                    public void onItemClicked(RecyclerView recyclerView, int position, View v) {
                        Reunion reunion = adapter.getReunions(position);
                        Intent intent = new Intent(MainActivity.this, DetailReunionActivity.class);
                        Bundle b = new Bundle();
                        b.putSerializable("reunion", reunion);
                        intent.putExtras(b);
                        startActivity(intent);

                    }
                });
    }
}