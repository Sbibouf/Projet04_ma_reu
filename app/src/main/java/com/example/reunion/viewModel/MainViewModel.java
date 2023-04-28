package com.example.reunion.viewModel;


import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.reunion.Repository.ReunionRepository;
import com.example.reunion.model.Reunion;
import com.example.reunion.service.FakeReunionApiService;
import com.example.reunion.service.ReunionApiService;

import java.util.ArrayList;
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
}
