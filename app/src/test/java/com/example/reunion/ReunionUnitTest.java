package com.example.reunion;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

import com.example.reunion.Repository.ReunionRepository;
import com.example.reunion.model.Reunion;
import com.example.reunion.model.ReunionGenerator;
import com.example.reunion.service.FakeReunionApiService;
import com.example.reunion.service.ReunionApiService;

import java.util.List;

/**
 * Test unitaire locale verifiant la récupération et la suppression d'une réunion
 */
public class ReunionUnitTest {

    private ReunionApiService service; // Api des reunions

    @Before
    public void setup() { service = ReunionRepository.getNewInstanceApiService();
    }

    @Test
    public void getReunionsWithSucess(){
        List<Reunion> reunions = service.getReunions();
        List<Reunion> expectedReunions = ReunionGenerator.Fake_Reunion;
        assertEquals(reunions, expectedReunions);
    }

    @Test
    public void deleteReunionWithSucess(){
        Reunion reunionToDelete = service.getReunions().get(0);
        service.deleteReunion(reunionToDelete);
        assertFalse(service.getReunions().contains(reunionToDelete));
    }
}