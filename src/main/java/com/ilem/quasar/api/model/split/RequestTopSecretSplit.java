package com.ilem.quasar.api.model.split;

import java.util.ArrayList;

public class RequestTopSecretSplit {
    private double distance;
    private ArrayList<String> message;

    public RequestTopSecretSplit() {
    }

    public RequestTopSecretSplit(double distance, ArrayList<String> message) {
        this.distance = distance;
        this.message = message;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public ArrayList<String> getMessage() {
        return message;
    }

    public void setMessage(ArrayList<String> message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "RequestTopSecretSplit [distance=" + distance + ", message=" + message + "]";
    }
    

}