package com.example.reunion;

import java.util.List;

public class Reunion {

    private int heures, minutes, date_jour, date_mois, date_annee, num_salle, nb_participants, duree_reunion;
    private String nom_reunion, lieu_reunion;


    private List<String> participants;


    //Constructeur

    public Reunion(String nom, int jour, int mois, int annee, int numero_salle, List<String> participant ) {

        nom_reunion = nom;
        date_jour = jour;
        date_mois = mois;
        date_annee = annee;
        num_salle = numero_salle;
        participants = participant;
    }


    //Getters
    //And
    //Setters


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

    public String getLieu_reunion() {
        return lieu_reunion;
    }

    public void setLieu_reunion(String lieu_reunion) {
        this.lieu_reunion = lieu_reunion;
    }

    public List<String> getParticipants() {
        return participants;
    }

    public void setParticipants(List<String> participants) {
        this.participants = participants;
    }

    public int getNum_salle() { return num_salle; }

    public void setNum_salle(int num_salle) { this.num_salle = num_salle; }

    public int getNb_participants() { return nb_participants; }

    public void setNb_participants(int nb_participants) { this.nb_participants = nb_participants; }

    public int getDuree_reunion() { return duree_reunion; }

    public void setDuree_reunion(int duree_reunion) { this.duree_reunion = duree_reunion; }
}
