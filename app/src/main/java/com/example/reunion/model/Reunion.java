package com.example.reunion.model;

import java.util.List;
import java.util.Objects;

public class Reunion {

    private int heures, minutes, date_jour, date_mois, date_annee, num_salle, nb_participants, duree_reunion;
    private String nom_reunion, sujet_reunion, date_reu, heure_reu, salle_reu, participants;

    //Constructeur

    public Reunion(String nom, String sujet, String date, String heure, String salle, String participant ) {

        nom_reunion = nom;
        sujet_reunion = sujet;
        date_reu = date;
        heure_reu = heure;
        salle_reu = salle;
        participants = participant;
    }


    //Getters
    //And
    //Setters

    public String getDate_reu() {return date_reu;}

    public void setDate_reu(String date_reu) {this.date_reu = date_reu;}

    public String getHeure_reu() {return heure_reu;}

    public void setHeure_reu(String heure_reu) {this.heure_reu = heure_reu;}

    public String getSalle_reu() {return salle_reu;}

    public void setSalle_reu(String salle_reu) {this.salle_reu = salle_reu;}

    public int getHeures() {
        return heures;
    }

    public void setHeures(int heures) {
        this.heures = heures;
    }

    public int getMinutes() {
        return minutes;
    }

    public void setMinutes(int minutes) {
        this.minutes = minutes;
    }

    public int getDate_jour() {
        return date_jour;
    }

    public void setDate_jour(int date_jour) {
        this.date_jour = date_jour;
    }

    public int getDate_mois() {
        return date_mois;
    }

    public void setDate_mois(int date_mois) {
        this.date_mois = date_mois;
    }

    public int getDate_annee() {
        return date_annee;
    }

    public void setDate_annee(int date_annee) {
        this.date_annee = date_annee;
    }

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

    public int getNum_salle() { return num_salle; }

    public void setNum_salle(int num_salle) { this.num_salle = num_salle; }

    public int getNb_participants() { return nb_participants; }

    public void setNb_participants(int nb_participants) { this.nb_participants = nb_participants; }

    public int getDuree_reunion() { return duree_reunion; }

    public void setDuree_reunion(int duree_reunion) { this.duree_reunion = duree_reunion; }


}
