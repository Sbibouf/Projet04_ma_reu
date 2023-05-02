package com.example.reunion.model;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class ReunionGenerator {

    public static List<Reunion> Fake_Reunion = Arrays.asList(
            new Reunion("ReuA", "blabla", "02-05-2023", "15:00", "Salle 2","Alex@lamzone.fr, Amandine@lamzone.fr"),
            new Reunion("ReuB", "blabla", "02-05-2023", "16:00", "Salle 2", "François@lamzone.fr, Alex@lamzone.fr, Amandine@lamzone.fr"),
            new Reunion("ReuC", "blabla","02-05-2023", "15:00", "Salle 3","Luc@lamzone.fr, Jean@lamzone.fr, Alex@lamzone.fr"),
            new Reunion("ReuD", "blabla","03-05-2023", "11:00", "Salle 1", "Luc@lamzone.fr, Jean@lamzone.fr, Alex@lamzone.fr"),
            new Reunion("ReuE", "blabla", "03-05-2023", "11:00", "Salle 3","Luc@lamzone.fr, Jean@lamzone.fr, Amandine@lamzone.fr"),
            new Reunion("ReuF", "blabla","03-05-2023", "14:00", "Salle 4", "Luc@lamzone.fr, Bernard@lamzone.fr, Alex@lamzone.fr"),
            new Reunion("ReuG", "blabla","07-05-2023", "12:00", "Salle 1", "Viviane@lamzone.fr, Jean@lamzone.fr, François@lamzone.fr"),
            new Reunion("ReuH", "blabla","07-05-2023", "18:00", "Salle 7", "Alex@lamzone.fr, Yves@lamzone.fr, Alex@lamzone.fr, Bernard@lamzone.fr"),
            new Reunion("ReuI", "blabla", "12-05-2023", "10:00", "Salle 5", "Luc@lamzone.fr, Amandine@lamzone.fr, Viviane@lamzone.fr"),
            new Reunion("ReuJ", "blabla","14-05-2023", "09:00", "Salle 1", "Luc@lamzone.fr, Yves@lamzone.fr"),
            new Reunion("ReuK", "blabla","02-06-2023", "15:00", "Salle 2", "Bernard@lamzone, Yves@lamzone.fr, Alex@lamzone.fr, Amandine@lamzone.fr, Viviane@lamzone.fr"),
            new Reunion("ReuL", "blabla","02-06-2023", "15:30", "Salle 3", "Luc@lamzone.fr, Jean@lamzone.fr, Alex@lamzone.fr"),
            new Reunion("ReuM", "blabla","03-06-2023", "17:00", "Salle 8", "Luc@lamzone.fr, Paul@lamzone.fr, Maxime@lamzone.fr, Bernard@lamzone.fr"),
            new Reunion("ReuN", "blabla","04-06-2023", "15:00", "Salle 2", "Viviane@lamzone.fr, Jean@lamzone.fr, Amandine@lamzone.fr"),
            new Reunion("ReuO","blabla", "06-05-2023", "15:00", "Salle 2", "Maxime@lamzone.fr, Paul@lamzone.fr, Viviane@lamzone.fr, Yves@lamzone.fr, Fraçois@lamzone.fr")

    );

    public static List<Reunion> GenererReunions() {

        return new ArrayList<>(Fake_Reunion);
    }





}
