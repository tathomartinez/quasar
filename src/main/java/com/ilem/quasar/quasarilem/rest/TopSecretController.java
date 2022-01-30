package com.ilem.quasar.quasarilem.rest;
import com.ilem.quasar.quasarilem.model.RequestSatellite;
import com.ilem.quasar.quasarilem.model.ResponseSatellite;
import com.ilem.quasar.quasarilem.services.SatelliteService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class TopSecretController {

    // @GetMapping(value="/topSecret")
    // public Satelite getSatelite(@RequestParam (value = "id", defaultValue = "") String id) {
    //     return new Satelite("skywalker",115.5,new String[]{"este", "", "un", "", ""});
    // }
    @Autowired
    private SatelliteService satelliteService ;

    @PostMapping(value = "/topSecret")
    public ResponseEntity<ResponseSatellite> responseTopSecret(@RequestBody RequestSatellite satelites) {
        System.out.println("llego aca");
        return new ResponseEntity<>(satelliteService.computar(), HttpStatus.OK);
    }
    
    
}
