package com.example.reunion.vue;


import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.MultiAutoCompleteTextView;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.example.reunion.R;
import com.example.reunion.databinding.AjouterReunionBinding;
import com.example.reunion.model.Reunion;
import com.example.reunion.viewModel.AjouterReunionViewModel;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Objects;

public class AjouterReunionActivity extends AppCompatActivity {
    AjouterReunionBinding binding; // Binding des éléments graphiques du layout ajouter_reunion

    private int mDate, mMonth, mYear, mHour, mMin; // Date et heure a afficher par defaut dans le date picker

    private int mJourChoisi, mMoisChoisi, mAnneeChoisi, mHeureDebut, mHeureFin, mMinuteDebut, mMinuteFin; // Date et heure de début et de fin de la reunion à créer

    String[] mListeSalle, mListeParticipants; // La liste des salles et des participants à la réunion

    ArrayAdapter<String> adapter; // Le tableau d'adapter pour être afficher

    AjouterReunionViewModel mAjouterReunionViewModel; // ViewModele de l'activité


    /**
     * Activity created
     *
     * @param savedInstanceState
     */
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


    /**
     * Initiating forms and picking date and time of the meeting
     */
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
                        int mois = month + 1;
                        int annee = year - 2000;

                        binding.dateReu.setText((date + "-" + mois + "-" + annee));
                        mJourChoisi = date;
                        mMoisChoisi = month;
                        mAnneeChoisi = year - 1900;

                    }
                }, mYear, mMonth, mDate);
                datePickerDialog.show();
            }
        });

        /**
         * Recuperation de l'heure du début de la réunion
         */

        binding.debutReu.setFocusable(false);
        binding.debutReu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final Calendar cal = Calendar.getInstance();
                mHour = cal.get(Calendar.HOUR);
                mMin = cal.get(Calendar.MINUTE);
                TimePickerDialog timePickerDialog = new TimePickerDialog(AjouterReunionActivity.this, android.R.style.Theme_DeviceDefault_Dialog, new TimePickerDialog.OnTimeSetListener() {
                    @SuppressLint("SetTextI18n")
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {

                        binding.debutReu.setText((hourOfDay + ":" + minute));


                        mHeureDebut = hourOfDay;
                        mMinuteDebut = minute;

                    }
                }, mHour, mMin, true);
                timePickerDialog.show();


            }
        });

        /**
         * Recuperation de l'heure de fin de la réunion
         */

        binding.finReu.setFocusable(false);
        binding.finReu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final Calendar cal = Calendar.getInstance();
                mHour = cal.get(Calendar.HOUR);
                mMin = cal.get(Calendar.MINUTE);
                TimePickerDialog timePickerDialog = new TimePickerDialog(AjouterReunionActivity.this, android.R.style.Theme_DeviceDefault_Dialog, new TimePickerDialog.OnTimeSetListener() {
                    @SuppressLint("SetTextI18n")
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {

                        binding.finReu.setText((hourOfDay + ":" + minute));


                        mHeureFin = hourOfDay;
                        mMinuteFin = minute;
                        verifierDate();

                    }
                }, mHour, mMin, true);
                timePickerDialog.show();


            }
        });


        /**
         * Initialisation de la liste des participants a selectionner
         */
        mListeParticipants = getResources().getStringArray(R.array.mail_participants);
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, mListeParticipants);
        binding.participants.setAdapter(adapter);
        binding.participants.setTokenizer(new MultiAutoCompleteTextView.CommaTokenizer());

    }

    /**
     * Throwing data when click on Sauvegarder
     */
    public void saveReunion() {


        binding.btSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OnSubmit();
            }
        });
    }

    /**
     * Checking picked date to show only available rooms
     */
    public void verifierDate() {

        /**
         * Initialisation de la liste des salles puis on boucle sur la liste de reunions pour n'afficher que les salles disponibles
         */
        mListeSalle = getResources().getStringArray(R.array.Numero_de_salle);
        List<String> listeSalle = new ArrayList<>(Arrays.asList(mListeSalle));
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(getApplicationContext(), R.layout.liste_num_salle, mListeSalle);
        for (Reunion reunion : mAjouterReunionViewModel.getReunions()) {
            GregorianCalendar dateSelectionne = new GregorianCalendar (mAnneeChoisi, mMoisChoisi, mJourChoisi, mHeureDebut, mMinuteDebut);
            GregorianCalendar dateDebutReunion = reunion.getDebutReunion();
            GregorianCalendar dateFinReunion = reunion.getFinReunion();
            if (dateSelectionne.before(dateFinReunion) && dateSelectionne.after(dateDebutReunion) || dateSelectionne.compareTo(dateDebutReunion)==0  ) {

                listeSalle.remove(reunion.getSalleReu());
                String[] listeSalles = new String[listeSalle.size()];
                listeSalle.toArray(listeSalles);
                ArrayAdapter<String> adapterSalle = new ArrayAdapter<>(getApplicationContext(), R.layout.liste_num_salle, listeSalles);
                binding.numeroSalle.setAdapter(adapterSalle);
                break;

            } else {
                binding.numeroSalle.setAdapter(arrayAdapter);
                break;
            }
        }

    }

    /**
     * Creating the meeting with all elements provided by user
     */
    public void OnSubmit() {


        String nom = binding.nomReu.getText().toString();
        String sujet = binding.sujetReu.getText().toString();
        String date = binding.dateReu.getText().toString();
        String debut = binding.debutReu.getText().toString();
        String fin = binding.finReu.getText().toString();
        String salle = binding.numeroSalle.getText().toString();
        String participants = binding.participants.getText().toString();


        /**
         * Showing error message if elements are empty
         */
        if (nom.isEmpty()) {

            binding.etNom.setError("Veuillez entrer un nom");

        }
        if (sujet.isEmpty()) {

            binding.etSujet.setError("Veuillez entrer un sujet");

        }
        if (date.isEmpty()) {

            binding.etDate.setError("Veuillez choisir une date");

        }
        if (debut.isEmpty()) {

            binding.etDebut.setError("Veuillez choisir un début");

        }
        if (salle.isEmpty()) {

            binding.etSalle.setError("Veuillez choisir une salle");

        }
        if (fin.isEmpty()) {

            binding.etFin.setError("Veuillez choisir une fin");
        } else {
            mAjouterReunionViewModel.ajouterReunions(new Reunion(nom, sujet, date,debut, salle, participants, new GregorianCalendar(mAnneeChoisi, mMoisChoisi, mJourChoisi, mHeureDebut, mMinuteDebut), new GregorianCalendar(mAnneeChoisi, mMoisChoisi, mJourChoisi, mHeureFin, mMinuteFin)));
            Toast.makeText(this, "Réunion ajoutée", Toast.LENGTH_SHORT).show();
            finish();
        }


    }


}
