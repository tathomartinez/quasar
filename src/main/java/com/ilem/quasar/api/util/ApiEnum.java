package com.ilem.quasar.api.util;

public enum ApiEnum {
    RETURNAPI("Gracias por usar este recurso, este endpoint esta en mantenimiento"),
    ENDPOINT_TOP_SECRET("/topSecret"),
    QUASAR_EXEPTION("NO SE CUENTA CON LA INFORMACION SUFICIENTE"),
    KENOBI("kenobi"),
    SATO("sato"),
    SKYWALKER("skywalker"),
    RETURN_200("200 ok ; Se Agrego correctamente"),
    RETURN_500("500 error ; No valido"),
    ;

    private String id;

    private ApiEnum(String id) {
        this.id = id;
    }

    public String getId() {
        return this.id;
    }

}
