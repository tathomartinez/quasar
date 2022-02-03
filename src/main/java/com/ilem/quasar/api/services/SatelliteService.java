package com.ilem.quasar.api.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.ilem.quasar.api.module.Position;
import com.ilem.quasar.api.module.RequestTopSecret;
import com.ilem.quasar.api.module.ResponseTopSecret;
import com.ilem.quasar.api.module.Satellite;

public class SatelliteService {

    private static Satellite kenobi = new Satellite("Kenobi", new Position(-500, -200));
    private static Satellite skywalker = new Satellite("Skywalker", new Position(100, -100));
    private static Satellite sato = new Satellite("Sato", new Position(500, 100));

    public static ResponseTopSecret computar(RequestTopSecret requestTopSecret) {
        ResponseTopSecret responseTopSecret = new ResponseTopSecret();
        LocalizacionService localizacionService = new LocalizacionService();

        requestTopSecret.getSatellites().get(0).getDistance();
        ArrayList<Satellite> satellites = requestTopSecret.getSatellites();
        String[] mensaje = descifrarStrings(satellites);
        double[] distances = obtenerDistancias(satellites);
        double[][] positions = obtenerPocisiones();
        double[] location = localizacionService.getLocation(positions, distances);

        double x = location[0];
        double y = location[1];

        responseTopSecret.setMessage(Arrays.toString(mensaje));
        responseTopSecret.setPosition(new Position(x, y));

        return responseTopSecret;
    }

    public static double[][] obtenerPocisiones() {

        List<Satellite> satellitesList = new ArrayList<>();
        satellitesList.add(kenobi);
        satellitesList.add(skywalker);
        satellitesList.add(sato);

        double[][] pocisionesDeLosSatelites = new double[3][2];

        int i = 0;
        int j = 0;

        for (Satellite satellite : satellitesList) {
            j = 0;
            pocisionesDeLosSatelites[i][j] = satellite.getPosition().getX();
            j++;
            pocisionesDeLosSatelites[i][j] = satellite.getPosition().getY();
            i++;

        }

        return pocisionesDeLosSatelites;
    }

    private static double[] obtenerDistancias(ArrayList<Satellite> satellites) {
        List<Double> retornoObtenerDistancias = new ArrayList<>();
        for (Satellite satellite : satellites) {
            retornoObtenerDistancias.add(satellite.getDistance());
        }
        return retornoObtenerDistancias.stream().mapToDouble(d -> d).toArray();
    }

    private static String[] descifrarStrings(ArrayList<Satellite> satelliteArrayList) {
        String[] mensaje = new String[4];
        for (Satellite satellite : satelliteArrayList) {
            for (int i = 0; i < mensaje.length; i++) {
                mensaje[i] = descifrar(mensaje, satellite, i);
            }
        }
        return mensaje;
    }

    private static String descifrar(String[] mensaje, Satellite satellite, int i) {
        return satellite.getMessage().get(i) == null || satellite.getMessage().get(i).trim().isEmpty() ? mensaje[i]
                : satellite.getMessage().get(i);
    }

}
