package com.example.reunion.model;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class ReunionGenerator {

    public static List<Reunion> Fake_Reunion = Arrays.asList(
            new Reunion("ReuA", "blabla", "02-05-2023", "15:00", "Salle 2"),
            new Reunion("ReuB", "blabla", "02-05-2023", "16:00", "Salle 2"),
            new Reunion("ReuC", "blabla","02-05-2023", "15:00", "Salle 3"),
            new Reunion("ReuD", "blabla","03-05-2023", "11:00", "Salle 1"),
            new Reunion("ReuE", "blabla", "03-05-2023", "11:00", "Salle 3"),
            new Reunion("ReuF", "blabla","03-05-2023", "14:00", "Salle 4"),
            new Reunion("ReuG", "blabla","07-05-2023", "12:00", "Salle 1"),
            new Reunion("ReuH", "blabla","07-05-2023", "18:00", "Salle 7"),
            new Reunion("ReuI", "blabla", "12-05-2023", "10:00", "Salle 5"),
            new Reunion("ReuJ", "blabla","14-05-2023", "09:00", "Salle 1"),
            new Reunion("ReuK", "blabla","02-06-2023", "15:00", "Salle 2"),
            new Reunion("ReuL", "blabla","02-06-2023", "15:30", "Salle 3"),
            new Reunion("ReuM", "blabla","03-06-2023", "17:00", "Salle 8"),
            new Reunion("ReuN", "blabla","04-06-2023", "15:00", "Salle 2"),
            new Reunion("ReuO","blabla", "06-05-2023", "15:00", "Salle 2")

    );

    public static List<Reunion> GenererReunions() {

        return new ArrayList<>(Fake_Reunion);
    }





}
