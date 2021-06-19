package com.noobForce.klasa.model;


import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Student implements Serializable
{
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private long id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private boolean isLoggedIn;
    
    public long getId()
    {
        return id;
    }
    
    public void setId(long id)
    {
        this.id = id;
    }
    
    public String getFirstName()
    {
        return firstName;
    }
    
    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }
    
    public String getLastName()
    {
        return lastName;
    }
    
    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }
    
    public String getEmail()
    {
        return email;
    }
    
    public void setEmail(String email)
    {
        this.email = email;
    }
    
    public String getPassword()
    {
        return password;
    }
    
    public void setPassword(String password)
    {
        this.password = password;
    }
    
    public boolean isLoggedIn()
    {
        return isLoggedIn;
    }
    
    public void setLoggedIn(boolean loggedIn)
    {
        isLoggedIn = loggedIn;
    }
    
    @Override
    public String toString()
    {
        return "Student{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", isLoggedIn=" + isLoggedIn +
                '}';
    }
}
