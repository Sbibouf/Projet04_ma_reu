package com.example.reunion.service;


import com.example.reunion.model.Reunion;

import java.util.ArrayList;
import java.util.List;

public class FakeReunionApiService implements ReunionApiService {

    private List<Reunion> mReunions = new ArrayList<>();

    @Override
    public List<Reunion> getReunions() {

        List<String> mReunion_test = new ArrayList<>();
        mReunion_test.add("alex@lamzone.fr");
        mReunions.add(new Reunion("Reunion test", 06,05,2023,7,mReunion_test));
        return mReunions;
    }

    @Override
    public void deleteReunion(Reunion reunion) {

    }

    @Override
    public void createReunion(Reunion reunion) {

    }
}
