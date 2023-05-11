package com.example.reunion.vue;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.graphics.Color;
import android.os.Bundle;

import com.example.reunion.R;
import com.example.reunion.databinding.ActivityDetailReunionBinding;
import com.example.reunion.model.Reunion;
import com.example.reunion.viewModel.DetailReunionViewModel;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DetailReunionActivity extends AppCompatActivity {
    ActivityDetailReunionBinding mDetailReunionBinding; // Binding des éléments graphiques du layout activity_detail_reunion
    DetailReunionViewModel mDetailReunionViewModel; // ViewModel de l'activité
    Reunion mReunion; // La reunion a afficher

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mDetailReunionBinding = ActivityDetailReunionBinding.inflate(getLayoutInflater());
        setContentView(mDetailReunionBinding.getRoot());
        mDetailReunionViewModel = new ViewModelProvider(this).get(DetailReunionViewModel.class);
        mReunion = (Reunion) getIntent().getSerializableExtra("reunion");// On recupère l'extra envoyé par la main activity
        afficherDetailReunion();
        changerImageReunion();
    }


    /**
     * Showing meeting details in layout elements
     */
    public void afficherDetailReunion(){

        if(mReunion != null) {

            mDetailReunionBinding.tvDateReunion.setText(mReunion.getDateReu() + " "+mReunion.getHeureReu());
            mDetailReunionBinding.tvNomReunion.setText("Reunion : "+mReunion.getNomReunion());
            mDetailReunionBinding.tvSujetReunion.setText(mReunion.getSujetReunion());
            mDetailReunionBinding.tvListeParticipants.setText(mReunion.getParticipants());
            mDetailReunionBinding.ivIconeReunion.setImageDrawable(getDrawable(R.drawable.circle));
        }


    }

    /**
     * Changing meeting icon color depending on the date
     */
    public void changerImageReunion(){
        GregorianCalendar dateDuJour = new GregorianCalendar();
        GregorianCalendar dateReunion = mReunion.getFinReunion();

        if(dateDuJour.before(dateReunion)||dateDuJour.compareTo(dateReunion)==0){ // Rouge si elle est finit, vert si non

            mDetailReunionBinding.ivIconeReunion.setColorFilter(Color.argb(200, 94, 203, 32));
            mDetailReunionBinding.tvStatutReunion.setText("(En attente)");
            mDetailReunionBinding.tvStatutReunion.setTextColor(Color.parseColor("#5ECB20"));
        }
        else{
            mDetailReunionBinding.ivIconeReunion.setColorFilter(Color.argb(200, 203, 32, 32));
            mDetailReunionBinding.tvStatutReunion.setText("(Terminé)");
            mDetailReunionBinding.tvStatutReunion.setTextColor(Color.parseColor("#CB2020"));
        }

    }
}