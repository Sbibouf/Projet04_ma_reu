package com.example.reunion.viewModel;


import androidx.lifecycle.ViewModel;

import com.example.reunion.Repository.ReunionRepository;
import com.example.reunion.model.Reunion;

public class AjouterReunionViewModel extends ViewModel {

    ReunionRepository mReunionRepository;

    public AjouterReunionViewModel() {
        mReunionRepository = ReunionRepository.getInstance();

    }

    public void ajouterReunions(Reunion reunion){
        mReunionRepository.createReunion(reunion);

    }
}
