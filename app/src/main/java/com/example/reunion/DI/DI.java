package com.example.reunion.DI;


import com.example.reunion.service.FakeReunionApiService;
import com.example.reunion.service.ReunionApiService;

public class DI {

    private static ReunionApiService service = new FakeReunionApiService();



    public static ReunionApiService getReunionApiService(){
        return service;
    }
}
