package com.ilem.quasar.api.util;

public enum ApiEnum {
    RETURNAPI("Gracias por usar este recurso, este endpoint esta en mantenimiento"),
    ENDPOINT_TOP_SECRET("/topSecret")
    ;

    private String id;

    private ApiEnum(String id) {
        this.id = id;
    }

    public String getId(){
        return this.id;
    }
    
}