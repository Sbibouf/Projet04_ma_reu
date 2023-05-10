package com.example.reunion.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

/**
 * Object representing a Meeting
 */
public class Reunion implements Serializable {


    /**
     * Start date of the meeting
     */
    private Date mDebutReunion;


    /**
     * End date of the meeting
     */
    private Date mFinReunion;


    /**
     * Name
     */
    private String mNomReunion;

    /**
     * Subject
     */
    private String mSujetReunion;

    /**
     * Date
     */
    private String mDateReu;

    /**
     * Hour
     */
    private String mHeureReu;

    /**
     * Room number
     */
    private String mSalleReu;


    /**
     * List of players
     */
    private String mParticipants;

    /**
     * Constructor
     *
     * @param nom
     * @param sujet
     * @param debut
     * @param fin
     * @param heure
     * @param salle
     * @param participant
     */
    public Reunion(String nom, String sujet, String dateStr, String heure, String salle, String participant, Date debut, Date fin ) {

        mNomReunion = nom;
        mSujetReunion = sujet;
        mDateReu = dateStr;
        mHeureReu = heure;
        mSalleReu = salle;
        mParticipants = participant;
        mDebutReunion = debut;
        mFinReunion = fin;

    }


    //Getters
    //And
    //Setters


    public Date getFinReunion() {
        return mFinReunion;
    }

    public void setFinReunion(Date finReunion) {
        this.mFinReunion = finReunion;
    }

    public Date getDebutReunion() {
        return mDebutReunion;
    }

    public void setDebutReunion(Date date_reunion) {
        this.mDebutReunion = date_reunion;
    }

    public String getDateReu() {return mDateReu;}

    public void setDateReu(String dateReu) {this.mDateReu = dateReu;}

    public String getHeureReu() {return mHeureReu;}

    public void setHeureReu(String heureReu) {this.mHeureReu = heureReu;}

    public String getSalleReu() {return mSalleReu;}

    public void setSalleReu(String salleReu) {this.mSalleReu = salleReu;}


    public String getNomReunion() {
        return mNomReunion;
    }

    public void setNomReunion(String nomReunion) {
        this.mNomReunion = nomReunion;
    }

    public String getSujetReunion() {
        return mSujetReunion;
    }

    public void setSujetReunion(String lieu_reunion) {
        this.mSujetReunion = lieu_reunion;
    }

    public String getParticipants() {
        return mParticipants;
    }

    public void setParticipants(String participants) {
        this.mParticipants = participants;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Reunion reunion = (Reunion) o;
        return mDebutReunion.equals(reunion.mDebutReunion) && mFinReunion.equals(reunion.mFinReunion) && mNomReunion.equals(reunion.mNomReunion) && mSujetReunion.equals(reunion.mSujetReunion) && mDateReu.equals(reunion.mDateReu) && mHeureReu.equals(reunion.mHeureReu) && mSalleReu.equals(reunion.mSalleReu) && mParticipants.equals(reunion.mParticipants);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mDebutReunion, mFinReunion, mNomReunion, mSujetReunion, mDateReu, mHeureReu, mSalleReu, mParticipants);
    }
}
