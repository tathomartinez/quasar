package com.ilem.quasar.quasarilem.model;

public class ResponseSatellite {
    private Cordenates position;
    private String message;

    public ResponseSatellite() {
    }

    public ResponseSatellite(Cordenates position, String message) {
        this.position = position;
        this.message = message;
    }

    public Cordenates getPosition() {
        return position;
    }

    public void setPosition(Cordenates position) {
        this.position = position;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}