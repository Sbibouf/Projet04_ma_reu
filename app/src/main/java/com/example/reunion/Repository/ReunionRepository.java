package com.example.reunion.Repository;


import com.example.reunion.model.Reunion;
import com.example.reunion.service.FakeReunionApiService;
import com.example.reunion.service.ReunionApiService;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Repository des reunions en Singleton
 */
public class ReunionRepository {

    private ReunionApiService mReunionApiService; // Api service des reunion
    private static ReunionRepository instance = null;// Instance null du repository

    /**
     * Constructeur du repository
     */
    private ReunionRepository() {
        mReunionApiService= new FakeReunionApiService();
    }


    /**
     * retourne une instance du repository si l'instance est null on en créé une
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
     * Recupère la liste des reunion via l'API
     * @return {@link List}
     */
    public List<Reunion> getReunions() {

        return mReunionApiService.getReunions();
    }

    /**
     * Create a reunion
     *
     * @param reunion
     */
    public void createReunion(Reunion reunion) {

        mReunionApiService.createReunion(reunion);
    }

    /**
     * Deletes a reunion
     *
     * @param reunion
     */
    public void deleteReunion(Reunion reunion) {

        mReunionApiService.deleteReunion(reunion);
    }

    /**
     * Get all reunions filtered by date
     *
     * @param date
     * @return {@link ArrayList}
     */
    public ArrayList<Reunion> getFilterReunionByDate(Date date) {
        return mReunionApiService.getReunionFilterByDate(date);
    }

    /**
     * Get all reunions filtered by salle
     *
     * @param salle
     * @return {@link List}
     */

    public List<Reunion> reunionFiltrerParSalle(String salle) {
        return mReunionApiService.reunionFiltrerParSalle(salle);
    }

    /**
     * Get always a new instance on @{@link ReunionApiService}. Useful for tests, so we ensure the context is clean.
     * @return
     */
    public static ReunionApiService getNewInstanceApiService(){

        return new FakeReunionApiService();
    }
}
