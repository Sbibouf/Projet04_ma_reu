package com.example.reunion.vue;


import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.reunion.R;
import com.example.reunion.Repository.ReunionRepository;
import com.example.reunion.databinding.AjouterReunionBinding;
import com.example.reunion.model.Reunion;
import com.example.reunion.service.FakeReunionApiService;
import com.example.reunion.service.ReunionApiService;

import java.util.Calendar;
import java.util.Objects;

public class AjouterReunionActivity extends AppCompatActivity {
    AjouterReunionBinding binding;
    private int mDate, mMonth, mYear, mHour, mMin;
    String[] liste;
    ArrayAdapter<String> adapter;
    private ReunionRepository mReunionRepository;
    String[] listecheck = {"Alex@lamzone.fr","Dennis@lamzone.fr", "Patrick@lamzone.fr", "François@lamzone.fr", "Emilie@lamzone.fr", "Rachel@lamzone.fr", "Marie@lamzone.fr"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = AjouterReunionBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Nouvelle Réunion");
        mReunionRepository = ReunionRepository.getInstance();
        initFormulaire();
        saveReunion();

    }


    public void initFormulaire() {

        liste = getResources().getStringArray(R.array.Numero_de_salle);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(getApplicationContext(), R.layout.liste_num_salle, liste);
        binding.numeroSalle.setAdapter(arrayAdapter);

        //* Recuperation de la date

        binding.dateReu.setFocusable(false);
        binding.dateReu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final Calendar cal = Calendar.getInstance();
                mDate = cal.get(Calendar.DATE);
                mMonth = cal.get(Calendar.MONTH);
                mYear = cal.get(Calendar.YEAR);
                DatePickerDialog datePickerDialog = new DatePickerDialog(AjouterReunionActivity.this, android.R.style.Theme_DeviceDefault_Dialog, new DatePickerDialog.OnDateSetListener() {
                    @SuppressLint("SetTextI18n")
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int date) {

                        binding.dateReu.setText((date + "-" + month + "-" + year));
                    }
                }, mYear, mMonth, mDate);
                datePickerDialog.show();
            }
        });

        //* Recuperation de l'heure

        binding.heureReu.setFocusable(false);
        binding.heureReu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final Calendar cal = Calendar.getInstance();
                mHour = cal.get(Calendar.HOUR);
                mMin = cal.get(Calendar.MINUTE);
                TimePickerDialog timePickerDialog = new TimePickerDialog(AjouterReunionActivity.this, android.R.style.Theme_DeviceDefault_Dialog, new TimePickerDialog.OnTimeSetListener() {
                    @SuppressLint("SetTextI18n")
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        binding.heureReu.setText((hourOfDay + ":" + minute));
                    }
                }, mHour, mMin, true);
                timePickerDialog.show();


            }
        });

        //* Affichage de la liste des participants a selectionner

        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_multiple_choice, listecheck);
        binding.participants.setAdapter(adapter);

    }

    public void saveReunion() {


        binding.btSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OnSubmit();
            }
        });


    }

    public void OnSubmit() {


        String nom = binding.nomReu.getText().toString();
        String sujet = binding.sujetReu.getText().toString();
        String date = binding.dateReu.getText().toString();
        String heure = binding.heureReu.getText().toString();
        String salle = binding.numeroSalle.getText().toString();


        if (nom.isEmpty()) {

            binding.etNom.setError("Veuillez entrer un nom");
            return;
        }
        if (sujet.isEmpty()) {

            binding.etSujet.setError("Veuillez entrer un sujet");
            return;
        }
        if (date.isEmpty()) {

            binding.etDate.setError("Veuillez choisir une date");
            return;
        }
        if (heure.isEmpty()) {

            binding.etHeure.setError("Veuillez choisir une heure");
            return;
        }
        if (salle.isEmpty()) {

            binding.etSalle.setError("Veuillez choisir une salle");
            return;
        }

        mReunionRepository.createReunion(new Reunion(nom, sujet, date, heure, salle));
       // mApiService.createReunion(new Reunion(nom, sujet, date, heure, salle));
        Toast.makeText(this, "Réunion ajoutée", Toast.LENGTH_SHORT).show();
        finish();
    }


}
