package com.ilem.quasar.api.controllers;

import static com.ilem.quasar.api.util.ApiEnum.RETURNAPI;

import com.ilem.quasar.api.model.RequestTopSecret;
import com.ilem.quasar.api.model.ResponseTopSecret;
import com.ilem.quasar.api.model.split.RequestTopSecretSplit;
import com.ilem.quasar.api.services.SatelliteService;
import com.ilem.quasar.api.util.exception.QuasarException;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@ControllerAdvice
public class TopSecretController {

    private TopSecretController() {
    }

    @PostMapping(value = "/topsecret")
    public static ResponseTopSecret topSecret(@RequestBody RequestTopSecret requestTopSecret) throws QuasarException {
        return SatelliteService.topSecret(requestTopSecret);
    }

    @RequestMapping(value = "/topsecret_split")
    @ExceptionHandler(value = { QuasarException.class })
    public ResponseTopSecret topSecretSplit() throws QuasarException {
        return SatelliteService.topSecretSplit();
    }

    @PostMapping(value = "/topsecret_split/{name}")
    public static String topSecretSplit(@RequestBody RequestTopSecretSplit requestTopSecretSplit,
            @PathVariable String name) {
        return SatelliteService.agregarSatelite(name, requestTopSecretSplit);
    }

    @RequestMapping(value = "/reset")
    public void rest() {
        SatelliteService.reset();
    }

    @RequestMapping(value = "/*")
    public static String any() {
        return RETURNAPI.getId();
    }

}
