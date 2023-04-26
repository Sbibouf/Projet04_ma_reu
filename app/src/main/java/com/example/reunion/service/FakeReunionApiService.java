package com.example.reunion.service;


import com.example.reunion.model.Reunion;
import com.example.reunion.model.ReunionGenerator;

import java.util.ArrayList;
import java.util.List;

public class FakeReunionApiService implements ReunionApiService {

    private List<Reunion> mReunions = ReunionGenerator.GenererReunions();

    @Override
    public List<Reunion> getReunions() {

        return mReunions;
    }

    @Override
    public void deleteReunion(Reunion reunion) {
        mReunions.remove(reunion);

    }

    @Override
    public void createReunion(Reunion reunion) {
        mReunions.add(reunion);

    }
}
