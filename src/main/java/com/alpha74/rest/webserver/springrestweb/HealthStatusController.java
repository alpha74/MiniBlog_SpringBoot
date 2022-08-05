package com.alpha74.rest.webserver.springrestweb;

import org.springframework.web.bind.annotation.*;

@RestController
public class HealthStatusController
{
    /*
        This method returns a string
     */
    @GetMapping(path="/healthStatus")
    public String healthStatus()
    {
        return "status:OK" ;
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

    /*
        Usage of Path Variables
     */
    @GetMapping(path="/healthStatusBean/{flag}")
    public HealthStatusBean healthStatusBeanVar(@PathVariable String flag)
    {
        return new HealthStatusBean(String.format("OK:%s", flag)) ;
    }
}
