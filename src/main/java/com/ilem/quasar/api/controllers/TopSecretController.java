package com.ilem.quasar.api.controllers;
import static com.ilem.quasar.api.util.ApiEnum.RETURNAPI;

import com.ilem.quasar.api.module.RequestTopSecret;
import com.ilem.quasar.api.module.ResponseTopSecret;
import com.ilem.quasar.api.services.SatelliteService;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class TopSecretController {
    
    @RequestMapping(value = "/topSecret")
    public static ResponseTopSecret topSecret(@RequestBody RequestTopSecret requestTopSecret) {
        return SatelliteService.computar(requestTopSecret);
    }

    @RequestMapping(value = "/*")
    public static String hand() {
        return RETURNAPI.getId();
    }
    
}
