package com.clinton.cozyblog.blog.models;

import jakarta.persistence.*;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;


@Entity
@Table(name = "users")
public class User {
 public User(long userId, String firstName, String lastName, String userRole, String passWord, String country) {
  this.userId = userId;
  this.firstName = firstName;
  this.lastName = lastName;
  this.userRole = userRole;
  this.passWord = passWord;
  this.country = country;
 }
 public long getUserId() {
  return userId;
 }

 public void setUserId(long userId) {
  this.userId = userId;
 }

 public String getFirstName() {
  return firstName;
 }

 public void setFirstName(String firstName) {
  this.firstName = firstName;
 }

 public String getLastName() {
  return lastName;
 }

 public void setLastName(String lastName) {
  this.lastName = lastName;
 }

 public String getUserRole() {
  return userRole;
 }

 public void setUserRole(String userRole) {
  this.userRole = userRole;
 }

 public String getPassWord() {
  return passWord;
 }

 public void setPassWord(String passWord) {
  this.passWord = passWord;
 }

 public String getCountry() {
  return country;
 }

 public void setCountry(String country) {
  this.country = country;
 }
 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 private long userId;
 @Column(name = "first_name", nullable = false)
 private String firstName;
 @Column(name = "last_name", nullable = false)
private String lastName;
 @Column(name = "user_role", nullable = false)
private String userRole; //admin or default
 @Column(name = "password", nullable = false, unique = true)
private String passWord;
 @Column(name = "country")
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
 @Override
 public String toString() {
  return "Users [id=" + userId + ", firstName=" + firstName + ", lastName=" + lastName + ", " + "userRole=" + userRole + ", " + "passWord=" + passWord + ", " + "country=" + country + "]";
 }
}
