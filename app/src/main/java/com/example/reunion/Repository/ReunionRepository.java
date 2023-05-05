package com.example.reunion.Repository;


import com.example.reunion.model.Reunion;
import com.example.reunion.service.FakeReunionApiService;
import com.example.reunion.service.ReunionApiService;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ReunionRepository {

    private ReunionApiService mReunionApiService;
    private static ReunionRepository instance = null;

    private ReunionRepository() {
        mReunionApiService= new FakeReunionApiService();
    }


    /**
     * Get an instance on {@link ReunionRepository}
     *
     * @return
     */
    public static ReunionRepository getInstance(){
        if(instance==null){
            synchronized (ReunionRepository.class){
                if(instance==null){
                    instance = new ReunionRepository();
                }
            }

        }
        return instance;
    }

    /**
     *
     * {@inheritDoc}
     */
    public List<Reunion> getReunions() {

        return mReunionApiService.getReunions();
    }

    /**
     *
     * {@inheritDoc}
     */
    public void createReunion(Reunion reunion) {

        mReunionApiService.createReunion(reunion);
    }

    /**
     *
     * {@inheritDoc}
     */
    public void deleteReunion(Reunion reunion) {

        mReunionApiService.deleteReunion(reunion);
    }

    /**
     *
     * {@inheritDoc}
     */
    public ArrayList<Reunion> getFilterReunionByDate(Date date) {
        return mReunionApiService.getReunionFilterByDate(date);
    }
}
