package com.example.reunion.viewModel;


import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.reunion.Repository.ReunionRepository;
import com.example.reunion.model.Reunion;
import com.example.reunion.service.FakeReunionApiService;
import com.example.reunion.service.ReunionApiService;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MainViewModel extends ViewModel {


    ReunionRepository mReunionRepository; // Repository des reunions


    /**
     * Constructor
     *
     */
    public MainViewModel() {
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
    /**
     * Supprime une reunion reçu en paramètre via la methode du repository
     * @param reunion
     */
    public void supprimer_Reunion(Reunion reunion){
        mReunionRepository.deleteReunion(reunion);
    }

    /**
     * Recupère la liste des reunions filtrer par date
     * @param date
     * @return {@link ArrayList}
     */
    public ArrayList<Reunion> getFilterReunionByDate(Date date) {
        return mReunionRepository.getFilterReunionByDate(date);
    }

    /**
     * Recupère la liste des reunions filtrer par salle
     * @param salle
     * @return {@link List}
     */
    public List<Reunion> reunionFiltrerParSalle(String salle) {
        return mReunionRepository.reunionFiltrerParSalle(salle);
    }
}
