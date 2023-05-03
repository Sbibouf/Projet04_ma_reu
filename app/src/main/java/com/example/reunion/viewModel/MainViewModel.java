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
    MutableLiveData<List<Reunion>> mMutableLiveData;

    public MainViewModel() {
        mReunionRepository = ReunionRepository.getInstance();
        mMutableLiveData = new MutableLiveData<>();
    }

    public MutableLiveData<List<Reunion>> getMutableLiveData(){
        return mMutableLiveData;
    }

    public void fetchReunion(){
        List<Reunion> reunion = mReunionRepository.getReunions();
        mMutableLiveData.setValue(reunion);

    }
    public List<Reunion> getReunions(){
        return mReunionRepository.getReunions();

    }
    public void supprimer_Reunion(Reunion reunion){
        mReunionRepository.deleteReunion(reunion);
    }
    public ArrayList<Reunion> getFilterReunionByDate(Date date) {
        return mReunionRepository.getFilterReunionByDate(date);
    }
}
