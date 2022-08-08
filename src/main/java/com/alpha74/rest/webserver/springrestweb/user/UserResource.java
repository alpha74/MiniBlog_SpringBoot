package com.alpha74.rest.webserver.springrestweb.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
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
        Get all users from list of users
        GET /users
     */
    @GetMapping("/users")
    public List<User> getAllUsers()
    {
        return service.findAll() ;
    }


    /*
        Find one user from list of users
        GET users/{id}
     */
    @GetMapping("/users/{id}")
    public User getUser(@PathVariable int id)
    {
        return service.findOne(id) ;
    }

    /*
        Create a new user
        - Input: Details of user
        - Output: Return URI of created user

        @RequestBody added on parameter will map the body of request to that param
        Using Status codes
     */
    @PostMapping("/users")
    public ResponseEntity<Object> createUser(@RequestBody User user)
    {
        User savedUser = service.save(user) ;

        /*
            This method takes the path of current request.
            We are then appending the Id of the saved user to the path and returning its URI
         */
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedUser.getId()).toUri() ;

        /*
            This will cause 201 Created status to be returned.
            The response header 'location' will contain the URI of saved user.
         */
        return ResponseEntity.created(location).build() ;
    }
}
