package com.example.reunion;

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
