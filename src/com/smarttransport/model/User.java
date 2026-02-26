package com.smarttransport.model;

import java.io.Serializable;
public class User implements Serializable {
    private String name ; 
    private String id ; 
    public User(String name , String id)
    {
        this.name = name ; 
        this.id = id ; 
    }
    static private User current_user ; 

    String get_id()
    {
        return id ; 
    }
    String get_name()
    {
        return name ; 
    }
    public static void setCurrentUser(User user) {
        current_user = user;
    }

    public static User getCurrentUser() {
        return current_user;
    }
}