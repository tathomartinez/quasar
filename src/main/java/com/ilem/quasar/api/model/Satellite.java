package com.ilem.quasar.api.model;

import java.util.ArrayList;

public class Satellite {
    private String name;
    private double distance;
    private ArrayList<String> message;
    private Position position;

    public Satellite() {
    }

    public Satellite(String name, Position position) {
        this.name = name;
        this.position = position;
    }

    public Satellite(String name, double distance, ArrayList<String> message) {
        this.name = name;
        this.distance = distance;
        this.message = message;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    @Override
    public String toString() {
        return "Satellite [distance=" + distance + ", message=" + message + ", name=" + name + ", position=" + position
                + "]";
    }

    

}
