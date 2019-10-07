package com.javabeginnerstutorial.bootdemo.actuator;

import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.stereotype.Component;

@Component
@Endpoint(id = "custEndPoint")
public class CustomEndPoint {

    @ReadOperation
    public String getReturn(){
        return "Custom End Point";
    }
}