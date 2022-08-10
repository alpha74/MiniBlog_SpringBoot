package com.alpha74.rest.webserver.springrestweb.healthStatus;

import com.alpha74.rest.webserver.springrestweb.healthStatus.HealthStatusBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.Locale;

@RestController
public class HealthStatusController
{
    @Autowired
    /*
        MessageSource is a feature provided by Spring to pick up message bundles.
     */
    private MessageSource messageSource;
    /*
        This method returns a string
     */
    @GetMapping(path="/healthStatus")
    public String healthStatus()
    {
        return "status:OK" ;
    }

    /*
        Implementing Internalization

        - This take Header "Accept-Language" in the request.
        _ Instead of hard-coding, we are using 'messages.properties' file.
     */
    @GetMapping(path="/healthStatus/i18n")
    public String healthStatusi18n(
            @RequestHeader(name="Accept-Language", required = false)
            Locale locale)
    {
        return messageSource.
                getMessage("health.status.message", null, "OK:Default", LocaleContextHolder.getLocale());
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
