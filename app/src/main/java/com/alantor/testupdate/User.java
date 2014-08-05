package com.alantor.testupdate;

/**
 * Created by Alan on 8/1/14.
 */
public class User {

    private String name;
    private String hometown;

    public User(String name, String hometown){
        this.name = name;
        this.hometown = hometown;
    }

    public String getName(){return name;}
    public String getHomeTown(){return hometown;}
}
