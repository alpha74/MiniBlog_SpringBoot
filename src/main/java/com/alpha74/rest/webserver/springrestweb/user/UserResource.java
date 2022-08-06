package com.alpha74.rest.webserver.springrestweb.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/*
    RestController will have REST methods defined in it.
 */
@RestController
public class UserResource
{
    /*
        Spring will connect the Component: UserDaoService using Autowired keyword
     */
    @Autowired
    private UserDaoService service ;

    /*
        Get all users
        GET /users
     */
    @GetMapping("/users")
    public List<User> getAllUsers()
    {
        return service.findAll() ;
    }


    /*
        Find one user
        GET users/{id}
     */
    @GetMapping("users/{id}")
    public User getUser(@PathVariable int id)
    {
        return service.findOne(id) ;
    }
}
