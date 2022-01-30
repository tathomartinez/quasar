package com.ilem.quasar.quasarilem.rest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import com.ilem.quasar.quasarilem.model.Cordenates;
import com.ilem.quasar.quasarilem.model.RequestSatellite;
import com.ilem.quasar.quasarilem.model.ResponseSatellite;
import com.ilem.quasar.quasarilem.model.Satellite;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
// @WebMvcTest(TopSecretController)
public class TopSecretControllerIntegrationTest {
    @Autowired
    private TestRestTemplate testRestTemplate;
    RequestSatellite inputResponseSatellite;
    // private TopSecretController topSecretController;
    // private TestRestTemplate testRestTemplate;

    // @Before
    public void setup() {

    }

    @Test
    public void getDataPOST() {
        inputResponseSatellite = new RequestSatellite();
        inputResponseSatellite.setSatellites(new ArrayList<Satellite>());
        HttpEntity<RequestSatellite> requestSatellite = new HttpEntity<>(inputResponseSatellite);

        ResponseEntity<ResponseSatellite> outputResponseSatellite = testRestTemplate.postForEntity("/topSecret", requestSatellite,
                ResponseSatellite.class);

        ResponseSatellite expectedResponseSatellite = new ResponseSatellite();

        Cordenates position = new Cordenates(Double.valueOf("-100.0"), Double.valueOf("75.5"));
        expectedResponseSatellite.setPosition(position);
        expectedResponseSatellite.setMessage("este es un mensaje secreto");

        ResponseEntity<ResponseSatellite> actualResponseSatellite = testRestTemplate.postForEntity("/topSecret", requestSatellite,
                ResponseSatellite.class);
        // ResponseEntity<String> outputString = testRestTemplate.getForEntity(url,
        // responseType, urlVariables)

        System.out.println(actualResponseSatellite.getBody().getMessage());
        assertEquals(expectedResponseSatellite, actualResponseSatellite.getBody());
        // assertEquals(expected, actual);

    }
}
