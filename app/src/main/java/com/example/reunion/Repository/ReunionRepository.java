package com.example.reunion.Repository;


import com.example.reunion.model.Reunion;
import com.example.reunion.service.ReunionApiService;

import java.util.List;

public class ReunionRepository {

    private final ReunionApiService mReunionApiService;

    public ReunionRepository(ReunionApiService reunionApiService) {
        mReunionApiService = reunionApiService;
    }

    public List<Reunion> getReunions() {

        return mReunionApiService.getReunions();
    }
    public void createReunion(Reunion reunion) {

        mReunionApiService.createReunion(reunion);
    }

    public void deleteReunion(Reunion reunion) {

        mReunionApiService.deleteReunion(reunion);
    }
}
