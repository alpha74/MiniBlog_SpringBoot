package com.alpha74.rest.webserver.springrestweb.filtering;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class FilteringController
{
    @GetMapping("/filtering")
    public CredsBean retrieveCredsBean()
    {
        return new CredsBean("email@g.com", "user2", "d3d02a!d");
    }

    @GetMapping("/filtering-list")
    public List<CredsBean> retrieveCredsBeanList()
    {
        return Arrays.asList(
                new CredsBean("email@g.com", "user2", "d3d02a!d"),
                new CredsBean("email2@g.com", "user3", "p2d02a2d")
        ) ;
    }
}
