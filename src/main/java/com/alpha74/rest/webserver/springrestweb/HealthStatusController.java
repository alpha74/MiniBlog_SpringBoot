package com.alpha74.rest.webserver.springrestweb;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthStatusController
{
    @GetMapping(path="/healthStatus")
    public String healthStatus()
    {
        return "Health:OK" ;
    }
}
