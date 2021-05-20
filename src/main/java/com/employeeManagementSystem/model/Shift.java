package com.employeeManagementSystem.model;

import javax.persistence.*;
import java.util.Date;

// Sql Database entity
@Entity
@Table(name= "shift")
public class Shift {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "first_name")
    private String firstName;
    @Column(name = "second_name")
    private String SecondName;
    @Column(name = "email")
    private String Email;
    @Column(name = "date")
    private Date shiftDate;

    public Shift(){

    }
    public Shift(String firstName, String secondName, String email, Date shiftDate) {

        this.firstName = firstName;
        SecondName = secondName;
        Email = email;
        this.shiftDate = shiftDate;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return SecondName;
    }

    public void setSecondName(String secondName) {
        SecondName = secondName;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public Date getShiftDate() {
        return shiftDate;
    }

    public void setShiftDate(Date shiftDate) {
        this.shiftDate = shiftDate;
    }
}
