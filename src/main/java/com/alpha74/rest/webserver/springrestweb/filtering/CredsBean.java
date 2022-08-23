package com.alpha74.rest.webserver.springrestweb.filtering;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import net.minidev.json.annotate.JsonIgnore;

/*
    Methods to do "Static Filtering" :

    - "Static Filtering" always ignores all fields added.
    - "Dynamic Filtering" can exclude fields conditionally.

    1. Using @JsonIgnore on a data member will make the code to not send it.
        Eg:
        @JsonIgnore
        private String password


    2. @JsonIgnoreProperties : Added before class.
        Takes "values" which are to be excluded
        When using this, we are hardcoding the values which are to be excluded.

 */

@JsonIgnoreProperties(value={"password"})
public class CredsBean
{
    private String email ;
    private String username ;
    private String password ;

    public CredsBean(String email, String username, String password)
    {
        super() ;
        this.email = email;
        this.username = username;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
