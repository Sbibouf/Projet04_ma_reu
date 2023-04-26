package com.example.reunion.service;

import com.example.reunion.model.Reunion;

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

}