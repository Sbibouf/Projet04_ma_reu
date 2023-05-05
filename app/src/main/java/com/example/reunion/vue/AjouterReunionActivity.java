package com.example.reunion.vue;


import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.MultiAutoCompleteTextView;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.example.reunion.R;
import com.example.reunion.Repository.ReunionRepository;
import com.example.reunion.databinding.AjouterReunionBinding;
import com.example.reunion.model.Reunion;
import com.example.reunion.service.FakeReunionApiService;
import com.example.reunion.service.ReunionApiService;
import com.example.reunion.viewModel.AjouterReunionViewModel;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Objects;

public class AjouterReunionActivity extends AppCompatActivity {
    AjouterReunionBinding binding;
    private int mDate, mMonth, mYear, mHour, mMin, mJourChoisi, mMoisChoisi, mAnneeChoisi, mHeureChoisi, mMinuteChoisi;
    String[] liste_salle, liste_participants;
    ArrayAdapter<String> adapter;
    AjouterReunionViewModel mAjouterReunionViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = AjouterReunionBinding.inflate(getLayoutInflater());
        mAjouterReunionViewModel = new ViewModelProvider(this).get(AjouterReunionViewModel.class);
        setContentView(binding.getRoot());
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Nouvelle Réunion");
        initFormulaire();
        saveReunion();

    }


    public void initFormulaire() {


        /**
         * Recuperation de la date
         */

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

                        if(date<10){
                            binding.dateReu.setText(("0"+date + "-" + month + "-" + year));
                        }
                        if(month<10){
                            binding.dateReu.setText((date + "-" + "0"+month + "-" + year));
                        }

                        if(month<10&&date<10){
                            binding.dateReu.setText(("0"+date + "-" + "0"+month + "-" + year));
                        }
                        else {
                            binding.dateReu.setText((date + "-" + month + "-" + year));
                        }
                        mJourChoisi = date;
                        mMoisChoisi = month;
                        mAnneeChoisi = year;

                    }
                }, mYear, mMonth, mDate);
                datePickerDialog.show();
            }
        });

        /**
         * Recuperation de l'heure
         */

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
                        if(minute<10){
                            binding.heureReu.setText((hourOfDay + ":" +0+ minute));
                        }
                        else{
                            binding.heureReu.setText((hourOfDay + ":" + minute));
                        }

                        mHeureChoisi = hourOfDay;
                        mMinuteChoisi = minute;
                        verifierDate();

                    }
                }, mHour, mMin, true);
                timePickerDialog.show();


            }
        });


        /**
         * Initialisation de la liste des participants a selectionner
         */
        liste_participants = getResources().getStringArray(R.array.mail_participants);
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, liste_participants);
        binding.participants.setAdapter(adapter);
        binding.participants.setTokenizer(new MultiAutoCompleteTextView.CommaTokenizer());

    }

    public void saveReunion() {


        binding.btSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OnSubmit();
            }
        });
    }

    public void verifierDate() {

        /**
         * Initialisation de la liste des salles puis on boucle sur la liste de reunions pour n'afficher que les salles disponibles
         */
        liste_salle = getResources().getStringArray(R.array.Numero_de_salle);
        List<String> listeSalle = Arrays.asList(liste_salle);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(getApplicationContext(), R.layout.liste_num_salle, liste_salle);
        for (Reunion reunion: mAjouterReunionViewModel.getReunions()) {
            Date timeC = new Date(mAnneeChoisi,mMoisChoisi,mJourChoisi,mHeureChoisi,mMinuteChoisi);
            Date timeR = reunion.getDate_reunion();
            if(timeC.compareTo(timeR)!=0){
                binding.numeroSalle.setAdapter(adapter);

            }
            else {
                binding.numeroSalle.setAdapter(arrayAdapter);
            }
        }

    }

    public void OnSubmit() {


        String nom = binding.nomReu.getText().toString();
        String sujet = binding.sujetReu.getText().toString();
        String date = binding.dateReu.getText().toString();
        String heure = binding.heureReu.getText().toString();
        String salle = binding.numeroSalle.getText().toString();
        String participants = binding.participants.getText().toString();


        if (nom.isEmpty()) {

            binding.etNom.setError("Veuillez entrer un nom");

        }
        if (sujet.isEmpty()) {

            binding.etSujet.setError("Veuillez entrer un sujet");

        }
        if (date.isEmpty()) {

            binding.etDate.setError("Veuillez choisir une date");

        }
        if (heure.isEmpty()) {

            binding.etHeure.setError("Veuillez choisir une heure");

        }
        if (salle.isEmpty()) {

            binding.etSalle.setError("Veuillez choisir une salle");

        }
        else {
            mAjouterReunionViewModel.ajouterReunions(new Reunion(nom, sujet, date, heure, salle, participants,new Date(mAnneeChoisi,mMoisChoisi,mJourChoisi,mHeureChoisi,mMinuteChoisi)));
            Toast.makeText(this, "Réunion ajoutée", Toast.LENGTH_SHORT).show();
            finish();
        }


    }


}
