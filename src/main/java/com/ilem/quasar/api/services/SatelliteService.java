package com.ilem.quasar.api.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ilem.quasar.api.model.Position;
import com.ilem.quasar.api.model.RequestTopSecret;
import com.ilem.quasar.api.model.ResponseTopSecret;
import com.ilem.quasar.api.model.Satellite;
import com.ilem.quasar.api.model.split.RequestTopSecretSplit;
import com.ilem.quasar.api.util.ApiEnum;
import com.ilem.quasar.api.util.SatelitesEnum;
import com.ilem.quasar.api.util.exception.QuasarException;

public class SatelliteService {

    private static Map<String, Satellite> satelitesMap = new HashMap<>();
    private static List<Satellite> satellitesList = Arrays.asList(SatelitesEnum.KENOBY.getSatellite(),
            SatelitesEnum.SKYWALKER.getSatellite(), SatelitesEnum.SATO.getSatellite());

    private SatelliteService() {
        // TODO document why this constructor is empty
    }

    public static ResponseTopSecret topSecret(RequestTopSecret requestTopSecret) {
        ArrayList<Satellite> satellites = requestTopSecret.getSatellites();
        if (isDataEnougth(satellites)) {
            resolverResponseTopSecret(satellites);
            return resolverResponseTopSecret(satellites);
        } else {
            throw new QuasarException(ApiEnum.QUASAR_EXEPTION.getId());
        }
    }

    public static ResponseTopSecret topSecretSplit() {
        if (fulledData()) {

            ArrayList<Satellite> satellites = new ArrayList<>();
            satelitesMap.forEach((name, satellite) -> satellites.add(satellite));
            return resolverResponseTopSecret(satellites);

        } else {
            throw new QuasarException(ApiEnum.QUASAR_EXEPTION.getId());
        }
    }

    private static double[][] obtenerPocisiones() {

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

    private static ResponseTopSecret resolverResponseTopSecret(ArrayList<Satellite> satellites) {
        String[] mensaje = descifrarStrings(satellites);
        double[] distances = obtenerDistancias(satellites);
        double[][] positions = obtenerPocisiones();
        LocalizacionService localizacionService = new LocalizacionService();
        double[] location = localizacionService.getLocation(positions, distances);

        double x = location[0];
        double y = location[1];

        ResponseTopSecret responseTopSecret = new ResponseTopSecret();
        responseTopSecret.setMessage(Arrays.toString(mensaje));
        responseTopSecret.setPosition(new Position(x, y));

        return responseTopSecret;
    }

    private static boolean fulledData() {
        return satelitesMap.containsKey(ApiEnum.KENOBI.getId()) &&
                satelitesMap.containsKey(ApiEnum.SATO.getId()) &&
                satelitesMap.containsKey(ApiEnum.SKYWALKER.getId());
    }

    private static boolean isDataEnougth(ArrayList<Satellite> satellites) {
        return satellites.size() == 3;
    }

    public static String agregarSatelite(String name, RequestTopSecretSplit requestTopSecretSplit) {

        satelitesMap.put(name,
                new Satellite(name, requestTopSecretSplit.getDistance(), requestTopSecretSplit.getMessage()));

        return ApiEnum.RETURN_200.getId();
    }

    public static void reset() {
        satelitesMap.clear();
    }

}
