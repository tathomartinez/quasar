package com.ilem.quasar.quasarilem.model;

public class Satellite {
    private final String name;
    private final Double distancia;
    private final String[] mensage;

    public Satellite(String name, Double distancia, String[] mensage) {
        this.name = name;
        this.distancia = distancia;
        this.mensage = mensage;
    }

    public String getName() {
        return name;
    }

    public Double getDistancia() {
        return distancia;
    }

    public String[] getMensage() {
        return mensage.clone();
    }

    public Integer[] getLocalizacion(Long distancia) {
        Integer[] retornoArray = new Integer[2];
        return retornoArray;
    }

    public String getMessage(String[] mensajes) {
        StringBuilder strReturn = new StringBuilder();
        return strReturn.toString();

    }

}
