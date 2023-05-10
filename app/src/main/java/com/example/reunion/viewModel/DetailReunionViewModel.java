package com.example.reunion.viewModel;


import androidx.lifecycle.ViewModel;

import com.example.reunion.Repository.ReunionRepository;
import com.example.reunion.model.Reunion;

import java.util.List;

public class DetailReunionViewModel extends ViewModel {

    ReunionRepository mReunionRepository; // Repository des reunions

    /**
     * Constructor
     */

    public DetailReunionViewModel() {

        mReunionRepository = ReunionRepository.getInstance();
    }

    /**
     * Recupère la liste des réunions via le repository
     *
     * @return  {@link List}
     */
    public List<Reunion> getReunions(){
        return mReunionRepository.getReunions();
    }
}
