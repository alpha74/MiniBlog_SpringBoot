package com.alpha74.rest.webserver.springrestweb.filtering;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class FilteringController
{
    @GetMapping("/filtering")
    public MappingJacksonValue retrieveCredsBean()
    {
        CredsBean credsBean = new CredsBean("email@g.com", "user2", "d3d02a!d");

        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter
                .filterOutAllExcept("email", "username") ;

        FilterProvider filters = new SimpleFilterProvider()
                .addFilter("CredsBeanFilter", filter) ;

        MappingJacksonValue mapping = new MappingJacksonValue(credsBean) ;
        mapping.setFilters(filters);

        return mapping ;
    }

    @GetMapping("/filtering-list")
    public MappingJacksonValue retrieveCredsBeanList()
    {
        List<CredsBean> listBeans = Arrays.asList(
                new CredsBean("email@g.com", "user2", "d3d02a!d"),
                new CredsBean("email2@g.com", "user3", "p2d02a2d")
        ) ;

        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter
                .filterOutAllExcept("email") ;

        FilterProvider filters = new SimpleFilterProvider()
                .addFilter("CredsBeanFilter", filter) ;

        MappingJacksonValue mapping = new MappingJacksonValue(listBeans) ;
        mapping.setFilters(filters);

        return mapping ;
    }
}
