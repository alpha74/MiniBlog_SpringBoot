package com.alpha74.rest.webserver.springrestweb.user;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/*
    Adding Component decorator  will make Spring handle this.
    Component is something which talks to database
 */
@Component
public class UserDaoService
{
    private static List<User> users = new ArrayList<>() ;
    private static int usersCount = 3 ;

    static
    {
        users.add( new User(1, "Jackson", new Date()));
        users.add( new User(1, "Johnson", new Date()));
        users.add( new User(1, "McDonald", new Date()));
    }

    public List<User> findAll()
    {
        return users ;
    }

    public User save(User user)
    {
        if( user.getId() == null )
            user.setId(++usersCount);

        users.add(user) ;
        return user ;
    }

    public User findOne(int id)
    {
        for( User user:users)
        {
            if( user.getId() == id )
                return user ;
        }
        return null ;
    }
}
