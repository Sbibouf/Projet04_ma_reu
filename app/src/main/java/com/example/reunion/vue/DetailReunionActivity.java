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

import java.util.Date;

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

            mDetailReunionBinding.tvDateReunion.setText((CharSequence) mReunion.getDate_reunion());
            mDetailReunionBinding.tvNomReunion.setText(mReunion.getNom_reunion());
            mDetailReunionBinding.tvSujetReunion.setText(mReunion.getSujet_reunion());
            mDetailReunionBinding.tvListeParticipants.setText(mReunion.getParticipants());
        }


    }

    public void changerImageReunion(){

        if(new Date().before(mReunion.getDate_reunion())){

            mDetailReunionBinding.ivIconeReunion.setColorFilter(Color.argb(200, 94, 203, 32));
        }
        else{
            mDetailReunionBinding.ivIconeReunion.setColorFilter(Color.argb(200, 203, 32, 32));
        }

    }
}