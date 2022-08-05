package com.alpha74.rest.webserver.springrestweb;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthStatusController
{
    /*
        This method returns a string
     */
    @GetMapping(path="/healthStatus")
    public String healthStatus()
    {
        return "Health:OK" ;
    }

    /*
        This method returns a Bean
        This Bean is automatically converted to JSON
     */
    @GetMapping(path="/healthStatusBean")
    public HealthStatusBean healthStatusBean()
    {
        return new HealthStatusBean("OK") ;
    }
}
