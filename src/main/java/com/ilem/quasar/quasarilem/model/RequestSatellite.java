package com.ilem.quasar.quasarilem.model;

import java.util.ArrayList;

public class RequestSatellite {

    private ArrayList<Satellite> satellites;

    public RequestSatellite() {
    }

    public RequestSatellite(ArrayList<Satellite> satellites) {
        this.satellites = satellites;

    }

    public ArrayList<Satellite> getSatellites() {
        return satellites;
    }

    public void setSatellites(ArrayList<Satellite> satellites) {
        this.satellites = satellites;
    }

}
