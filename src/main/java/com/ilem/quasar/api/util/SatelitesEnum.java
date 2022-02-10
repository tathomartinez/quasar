package com.ilem.quasar.api.util;

import com.ilem.quasar.api.model.Position;
import com.ilem.quasar.api.model.Satellite;

public enum SatelitesEnum {

    KENOBY(new Satellite("Kenobi", new Position(-500, -200))),
    SATO(new Satellite("Sato", new Position(500, 100))),
    SKYWALKER(new Satellite("Skywalker", new Position(100, -100)))

    ;

    private Satellite satellite;

    private SatelitesEnum(Satellite satellite) {
        this.satellite = satellite;
    }

    public Satellite getSatellite() {
        return this.satellite;
    }

}
