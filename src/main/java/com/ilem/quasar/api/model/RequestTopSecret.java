package com.ilem.quasar.api.model;

import java.util.ArrayList;

public class RequestTopSecret {
    private ArrayList<Satellite> satellites;

    public RequestTopSecret() {
    }

    public RequestTopSecret(ArrayList<Satellite> satellites) {
        this.satellites = satellites;
    }

    public ArrayList<Satellite> getSatellites() {
        return satellites;
    }

    public void setSatellites(ArrayList<Satellite> satellites) {
        this.satellites = satellites;
    }

    @Override
    public String toString() {
        return "RequestTopSecret [satellites=" + satellites + "]";
    }

}
