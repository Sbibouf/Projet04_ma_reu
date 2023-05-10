package com.example.reunion.model;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Class contenant une liste de fake reunions
 */
public abstract class ReunionGenerator {

    public static List<Reunion> Fake_Reunion = Arrays.asList(
            new Reunion("Commerciale", "Réunion sur les techniques de ventes commerciale", "03-05-2023", "15:00", "Salle 2","Alex@lamzone.fr, Amandine@lamzone.fr", new Date(123,4,3,15,00), new Date(123,4,3,15,45)),
            new Reunion("Technique", "Réunion sur les problèmes techniques en cours", "02-05-2023", "16:00", "Salle 2", "François@lamzone.fr, Alex@lamzone.fr, Amandine@lamzone.fr",new Date(123,4,2,16,00), new Date(123,4,2,16,45)),
            new Reunion("Direction", "Réunion entre les membres de la direction","02-06-2023", "15:00", "Salle 3","Luc@lamzone.fr, Jean@lamzone.fr, Alex@lamzone.fr",new Date(123,5,2,15,00), new Date(123,5,2,15,45)),
            new Reunion("Commerciale", "Réunion sur les techniques de ventes commerciale","03-05-2023", "11:00", "Salle 1", "Luc@lamzone.fr, Jean@lamzone.fr, Alex@lamzone.fr",new Date(123,4,3,11,00), new Date(123,4,3,11,30)),
            new Reunion("Commerciale", "Réunion sur les techniques de ventes commerciale", "03-06-2023", "11:00", "Salle 3","Luc@lamzone.fr, Jean@lamzone.fr, Amandine@lamzone.fr",new Date(123,5,3,11,00), new Date(123,5,3,11,25)),
            new Reunion("Direction", "Réunion entre les membres de la direction","03-06-2023", "14:00", "Salle 4", "Luc@lamzone.fr, Bernard@lamzone.fr, Alex@lamzone.fr",new Date(123,5,3,14,00), new Date(123,5,3,14,45)),
            new Reunion("Technique", "Réunion sur les problèmes techniques en cours","07-04-2023", "12:00", "Salle 1", "Viviane@lamzone.fr, Jean@lamzone.fr, François@lamzone.fr",new Date(123,3,7,12,00), new Date(123,3,7,12,45)),
            new Reunion("Commerciale", "Réunion sur les techniques de ventes commerciale","07-04-2023", "18:00", "Salle 7", "Alex@lamzone.fr, Yves@lamzone.fr, Alex@lamzone.fr, Bernard@lamzone.fr",new Date(123,3,7,18,00), new Date(123,3,7,18,45)),
            new Reunion("Direction", "Réunion entre les membres de la direction", "12-06-2023", "10:00", "Salle 5", "Luc@lamzone.fr, Amandine@lamzone.fr, Viviane@lamzone.fr",new Date(123,5,12,10,00), new Date(123,5,12,10,45)),
            new Reunion("Direction", "Réunion entre les membres de la direction","14-04-2023", "09:00", "Salle 1", "Luc@lamzone.fr, Yves@lamzone.fr",new Date(123,3,14,9,00), new Date(123,3,14,9,40)),
            new Reunion("Technique", "Réunion sur les problèmes techniques en cours","02-06-2023", "15:00", "Salle 2", "Bernard@lamzone, Yves@lamzone.fr, Alex@lamzone.fr, Amandine@lamzone.fr, Viviane@lamzone.fr",new Date(123,5,2,15,00), new Date(2023,5,2,15,30)),
            new Reunion("Direction", "Réunion entre les membres de la direction","02-06-2023", "15:30", "Salle 3", "Luc@lamzone.fr, Jean@lamzone.fr, Alex@lamzone.fr",new Date(123,5,2,15,30), new Date(123,5,2,16,10)),
            new Reunion("Commerciale", "Réunion sur les techniques de ventes commerciale","03-06-2023", "17:00", "Salle 8", "Luc@lamzone.fr, Paul@lamzone.fr, Maxime@lamzone.fr, Bernard@lamzone.fr",new Date(2023,5,3,17,00),new Date(123,5,3,18,00)),
            new Reunion("Direction", "Réunion entre les membres de la direction","04-06-2023", "15:00", "Salle 2", "Viviane@lamzone.fr, Jean@lamzone.fr, Amandine@lamzone.fr",new Date(123,5,4,15,00), new Date(123,5,4,15,45)),
            new Reunion("Technique","Réunion sur les problèmes techniques en cours", "06-05-2023", "15:00", "Salle 2", "Maxime@lamzone.fr, Paul@lamzone.fr, Viviane@lamzone.fr, Yves@lamzone.fr, Fraçois@lamzone.fr",new Date(123,4,6,15,00), new Date(2023,4,6,15,45))

    );

    /**
     * Retourn la liste generer de fake reunion
     * @return
     */

    public static List<Reunion> GenererReunions() {

        return new ArrayList<>(Fake_Reunion);
    }





}
