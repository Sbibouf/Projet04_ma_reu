package com.example.reunion.viewModel;


import androidx.lifecycle.ViewModel;

import com.example.reunion.Repository.ReunionRepository;
import com.example.reunion.model.Reunion;

import java.util.List;

public class DetailReunionViewModel extends ViewModel {

    ReunionRepository mReunionRepository;

    public DetailReunionViewModel() {

        mReunionRepository = ReunionRepository.getInstance();
    }


    /**
     * {@inheritDoc}
     */
    public List<Reunion> getReunions(){
        return mReunionRepository.getReunions();
    }
}
