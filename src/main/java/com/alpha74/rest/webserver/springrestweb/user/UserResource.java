package com.alpha74.rest.webserver.springrestweb.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
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
        User user = service.findOne(id) ;

        /*
            Throwing Exception here will cause server to return 500 Error code if
              we have not specified 404 error code to be returned explicitly in
              its definition.
         */
        if( user == null )
            throw new UserNotFoundException("id-" + id) ;

        return user ;
    }

    /*
        Create a new user
        - Input: Details of user
        - Output: Return URI of created user

        @RequestBody added on parameter will map the body of request to that param
        Using Status codes
     */
    @PostMapping("/users")
    public ResponseEntity<Object> createUser(@Valid @RequestBody User user)
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
            .created() will cause 201 Created status to be returned.
            The response header 'location' will contain the URI of saved user.
         */
        return ResponseEntity.created(location).build() ;
    }

    /*
        Returns 200 Code when user is deleted.
        Else, it returns 404 code when user is not found.
     */
    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable int id)
    {
        User user = service.deleteById(id) ;

        /*
            Throwing Exception here will cause server to return 500 Error code if
              we have not specified 404 error code to be returned explicitly in
              its definition.
         */
        if( user == null )
            throw new UserNotFoundException("id-" + id) ;
    }
}
