package com.javabeginnerstutorial.bootdemo.actuator;

import com.fasterxml.jackson.databind.JsonNode;
import com.javabeginnerstutorial.bootdemo.model.ApplicationDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class CustomHealthIndicator implements HealthIndicator {


    private RestTemplate restTemplate;

    private ApplicationDetails applicationDetails;

    @Value("${downstream.app.url}")
    private String downStreamAppUrl;

    @Autowired
    public CustomHealthIndicator(RestTemplate restTemplate, ApplicationDetails applicationDetails) {
        //TODO better way of autowiring
        this.restTemplate = restTemplate;
        this.applicationDetails = applicationDetails;
    }


    @Override
    public Health health() {
        try {
            JsonNode resp = restTemplate.getForObject(downStreamAppUrl, JsonNode.class);
            if (resp.get("status").asText().equalsIgnoreCase("UP")) {
                return  Health.up().withDetail("JAVA VERSION",applicationDetails.getJavaVersion()).build();
            }
        } catch (Exception ex) {
            return Health.down(ex).build();
        }
        return Health.down().build();
    }

}