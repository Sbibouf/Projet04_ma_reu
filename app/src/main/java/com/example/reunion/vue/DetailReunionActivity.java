package com.example.reunion.vue;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.graphics.Color;
import android.os.Bundle;

import com.example.reunion.R;
import com.example.reunion.databinding.ActivityDetailReunionBinding;
import com.example.reunion.databinding.ActivityMainBinding;
import com.example.reunion.model.Reunion;
import com.example.reunion.viewModel.DetailReunionViewModel;
import com.example.reunion.viewModel.MainViewModel;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class DetailReunionActivity extends AppCompatActivity {
    ActivityDetailReunionBinding mDetailReunionBinding;
    DetailReunionViewModel mDetailReunionViewModel;
    Reunion mReunion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mDetailReunionBinding = ActivityDetailReunionBinding.inflate(getLayoutInflater());
        setContentView(mDetailReunionBinding.getRoot());
        mDetailReunionViewModel = new ViewModelProvider(this).get(DetailReunionViewModel.class);
        mReunion = (Reunion) getIntent().getSerializableExtra("reunion");
        afficherDetailReunion();
        changerImageReunion();
    }



    public void afficherDetailReunion(){

        if(mReunion != null) {

            mDetailReunionBinding.tvDateReunion.setText(mReunion.getDate_reu() + " "+mReunion.getHeure_reu());
            mDetailReunionBinding.tvNomReunion.setText("Reunion : "+mReunion.getNom_reunion());
            mDetailReunionBinding.tvSujetReunion.setText(mReunion.getSujet_reunion());
            mDetailReunionBinding.tvListeParticipants.setText(mReunion.getParticipants());
            mDetailReunionBinding.ivIconeReunion.setImageDrawable(getDrawable(R.drawable.circle));
        }


    }

    public void changerImageReunion(){
        Date dateDuJour = Calendar.getInstance().getTime();
        Date dateReunion = mReunion.getFin_reunion();

        if(dateDuJour.before(dateReunion)||dateDuJour.compareTo(dateReunion)==0){

            mDetailReunionBinding.ivIconeReunion.setColorFilter(Color.argb(200, 94, 203, 32));
            mDetailReunionBinding.tvStatutReunion.setText("En attente");
            mDetailReunionBinding.tvStatutReunion.setTextColor(Color.green(203));
        }
        else{
            mDetailReunionBinding.ivIconeReunion.setColorFilter(Color.argb(200, 203, 32, 32));
            mDetailReunionBinding.tvStatutReunion.setText("Terminé");
            mDetailReunionBinding.tvStatutReunion.setTextColor(Color.red(203));
        }

    }
}