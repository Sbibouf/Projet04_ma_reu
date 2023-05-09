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


    ReunionRepository mReunionRepository;


    /**
     * Constructor
     *
     */
    public MainViewModel() {
        mReunionRepository = ReunionRepository.getInstance();

    }

    /**
     *
     * {@inheritDoc}
     */
    public List<Reunion> getReunions(){
        return mReunionRepository.getReunions();

    }
    /**
     *
     * {@inheritDoc}
     */
    public void supprimer_Reunion(Reunion reunion){
        mReunionRepository.deleteReunion(reunion);
    }

    /**
     *
     * {@inheritDoc}
     */
    public ArrayList<Reunion> getFilterReunionByDate(Date date) {
        return mReunionRepository.getFilterReunionByDate(date);
    }
    public List<Reunion> reunionFiltrerParSalle(String salle) {
        return mReunionRepository.reunionFiltrerParSalle(salle);
    }
}
