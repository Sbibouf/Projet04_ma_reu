package com.example.reunion.viewModel;


import androidx.lifecycle.ViewModel;

import com.example.reunion.Repository.ReunionRepository;
import com.example.reunion.model.Reunion;

import java.util.List;

public class AjouterReunionViewModel extends ViewModel {

    ReunionRepository mReunionRepository;

    /**
     * Constructor
     *
     */
    public AjouterReunionViewModel() {
        mReunionRepository = ReunionRepository.getInstance();

    }

    /**
     * {@inheritDoc}
     */
    public List<Reunion> getReunions(){
        return mReunionRepository.getReunions();
    }
    /**
     *
     * {@inheritDoc}
     */
    public void ajouterReunions(Reunion reunion){
        mReunionRepository.createReunion(reunion);

    }
}
