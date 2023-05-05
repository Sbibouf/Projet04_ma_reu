package com.example.reunion.model;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * Class générant une fausse liste de reunions
 */
public abstract class ReunionGenerator {

    public static List<Reunion> Fake_Reunion = Arrays.asList(
            new Reunion("Commerciale", "blabla", "03-05-2023", "15:00", "Salle 2","Alex@lamzone.fr, Amandine@lamzone.fr", new Date(2023,4,3,15,00)),
            new Reunion("Technique", "blabla", "02-05-2023", "16:00", "Salle 2", "François@lamzone.fr, Alex@lamzone.fr, Amandine@lamzone.fr",new Date(2023,4,2,16,00)),
            new Reunion("Direction", "blabla","02-06-2023", "15:00", "Salle 3","Luc@lamzone.fr, Jean@lamzone.fr, Alex@lamzone.fr",new Date(2023,5,2,15,00)),
            new Reunion("Commerciale", "blabla","03-05-2023", "11:00", "Salle 1", "Luc@lamzone.fr, Jean@lamzone.fr, Alex@lamzone.fr",new Date(2023,4,3,11,00)),
            new Reunion("Commerciale", "blabla", "03-06-2023", "11:00", "Salle 3","Luc@lamzone.fr, Jean@lamzone.fr, Amandine@lamzone.fr",new Date(2023,5,3,11,00)),
            new Reunion("Direction", "blabla","03-06-2023", "14:00", "Salle 4", "Luc@lamzone.fr, Bernard@lamzone.fr, Alex@lamzone.fr",new Date(2023,5,3,14,00)),
            new Reunion("Technique", "blabla","07-04-2023", "12:00", "Salle 1", "Viviane@lamzone.fr, Jean@lamzone.fr, François@lamzone.fr",new Date(2023,3,7,12,00)),
            new Reunion("Commerciale", "blabla","07-04-2023", "18:00", "Salle 7", "Alex@lamzone.fr, Yves@lamzone.fr, Alex@lamzone.fr, Bernard@lamzone.fr",new Date(2023,3,7,18,00)),
            new Reunion("Direction", "blabla", "12-06-2023", "10:00", "Salle 5", "Luc@lamzone.fr, Amandine@lamzone.fr, Viviane@lamzone.fr",new Date(2023,5,12,10,00)),
            new Reunion("Direction", "blabla","14-04-2023", "09:00", "Salle 1", "Luc@lamzone.fr, Yves@lamzone.fr",new Date(2023,3,14,9,00)),
            new Reunion("Technique", "blabla","02-06-2023", "15:00", "Salle 2", "Bernard@lamzone, Yves@lamzone.fr, Alex@lamzone.fr, Amandine@lamzone.fr, Viviane@lamzone.fr",new Date(2023,5,2,15,00)),
            new Reunion("Direction", "blabla","02-06-2023", "15:30", "Salle 3", "Luc@lamzone.fr, Jean@lamzone.fr, Alex@lamzone.fr",new Date(2023,5,2,15,30)),
            new Reunion("Commerciale", "blabla","03-06-2023", "17:00", "Salle 8", "Luc@lamzone.fr, Paul@lamzone.fr, Maxime@lamzone.fr, Bernard@lamzone.fr",new Date(2023,5,3,17,00)),
            new Reunion("Direction", "blabla","04-06-2023", "15:00", "Salle 2", "Viviane@lamzone.fr, Jean@lamzone.fr, Amandine@lamzone.fr",new Date(2023,5,4,15,00)),
            new Reunion("Technique","blabla", "06-05-2023", "15:00", "Salle 2", "Maxime@lamzone.fr, Paul@lamzone.fr, Viviane@lamzone.fr, Yves@lamzone.fr, Fraçois@lamzone.fr",new Date(2023,4,6,15,00))

    );

    public static List<Reunion> GenererReunions() {

        return new ArrayList<>(Fake_Reunion);
    }





}
