package com.clinton.cozyblog.blog.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;


@Entity
@Table(name = "users")
public class User {
private long userId;
private String firstName;
private String lastName;
private String userRole; //admin or default
private String passWord;
private String country;
//use lombok for the getters, setters, noArgs,AllArgs constructor
    //There is also this one below for the other project, it might just be what might finally work
    /*
@Override
public String toString() {
    return "Users [id=" + userId + ", username=" + userName + ", email=" + email + ", " +
            "password=" + password + ", address=" + address + ", city=" + city  +
            ", country=" + country + "]";
            }
            */
}
