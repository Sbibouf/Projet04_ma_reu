package com.example.reunion.service;


import com.example.reunion.model.Reunion;
import com.example.reunion.model.ReunionGenerator;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class FakeReunionApiService implements ReunionApiService {

    private List<Reunion> mReunions = ReunionGenerator.GenererReunions();

    @Override
    public List<Reunion> getReunions() {

        return mReunions;
    }

    @Override
    public void deleteReunion(Reunion reunion) {
        mReunions.remove(reunion);

    }

    @Override
    public void createReunion(Reunion reunion) {
        mReunions.add(reunion);

    }

    @Override
    public ArrayList<Reunion> getReunionFilterByDate(Date date) {
       ArrayList<Reunion> listeFiltrerParDate = new ArrayList<>();
        SimpleDateFormat dateSimple = new SimpleDateFormat("dd-MM-yyyy", new Locale("fr"));
        Calendar dateSelectionne = Calendar.getInstance();
        dateSelectionne.setTime(date);
        Date dateRaccourcis = dateSelectionne.getTime();
        String dateSelectionneString = dateSimple.format(dateRaccourcis);
        for(int i = 0; i< mReunions.size(); i++){
            boolean sameDate = dateSelectionneString.equals(mReunions.get(i).getDate_reu());
            if(sameDate) listeFiltrerParDate.add(mReunions.get(i));
        }
        return listeFiltrerParDate;
    }
}
