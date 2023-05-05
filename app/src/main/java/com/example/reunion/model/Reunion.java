package com.example.reunion.model;

import java.io.Serializable;
import java.sql.Time;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.SimpleTimeZone;

/**
 * Objet representant une Reunion
 */
public class Reunion implements Serializable {
    private Date date_reunion;

    /**
     * Nom
     */
    private String nom_reunion;

    /**
     * Sujet
     */
    private String sujet_reunion;

    /**
     * Date
     */
    private String date_reu;

    /**
     * Heure
     */
    private String heure_reu;

    /**
     * Numero de la salle
     */
    private String salle_reu;


    /**
     * Liste des participants
     */
    private String participants;

    /**
     * Constructeur
     *
     * @param nom
     * @param sujet
     * @param date
     * @param heure
     * @param salle
     * @param participant
     */
    public Reunion(String nom, String sujet, String dateStr, String heure, String salle, String participant, Date date ) {

        nom_reunion = nom;
        sujet_reunion = sujet;
        date_reu = dateStr;
        heure_reu = heure;
        salle_reu = salle;
        participants = participant;
        date_reunion= date;

    }


    //Getters
    //And
    //Setters


    public Date getDate_reunion() {
        return date_reunion;
    }

    public void setDate_reunion(Date date_reunion) {
        this.date_reunion = date_reunion;
    }

    public String getDate_reu() {return date_reu;}

    public void setDate_reu(String date_reu) {this.date_reu = date_reu;}

    public String getHeure_reu() {return heure_reu;}

    public void setHeure_reu(String heure_reu) {this.heure_reu = heure_reu;}

    public String getSalle_reu() {return salle_reu;}

    public void setSalle_reu(String salle_reu) {this.salle_reu = salle_reu;}


    public String getNom_reunion() {
        return nom_reunion;
    }

    public void setNom_reunion(String nom_reunion) {
        this.nom_reunion = nom_reunion;
    }

    public String getSujet_reunion() {
        return sujet_reunion;
    }

    public void setSujet_reunion(String lieu_reunion) {
        this.sujet_reunion = lieu_reunion;
    }

    public String getParticipants() {
        return participants;
    }

    public void setParticipants(String participants) {
        this.participants = participants;
    }



}
