package com.example.reunion.service;

import com.example.reunion.model.Reunion;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public interface ReunionApiService {


    /**
     * Get all my Reunions
     *
     * @return {@link List}
     */
    List<Reunion> getReunions();


    /**
     * Deletes a reunion
     *
     * @param reunion
     */
    void deleteReunion(Reunion reunion);

    /**
     * Create a reunion
     *
     * @param reunion
     */
    void createReunion(Reunion reunion);

    /**
     * Get all reunions filtered by date
     *
     * @param date
     * @return {@link ArrayList}
     */

    ArrayList<Reunion> getReunionFilterByDate(Date date);

    /**
     * Get all reunions filtered by room
     *
     * @param salle
     * @return {@link List}
     */
    List<Reunion> reunionFiltrerParSalle(String salle);

}
