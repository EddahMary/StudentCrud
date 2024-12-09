package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Data
//This annotation comes with all the getters and setters
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    @Id
    @GeneratedValue
    private int id;
    private String firstname ;
    private String lastname;
    private String gender;
    private String dateOfBirth;
    private String email;
    private String password;
//    private BigDecimal performance;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public String getFirstname() {return firstname; }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {return lastname; }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
    public String getGender(){
        return gender;
    }
    public void setGender(String Gender){
        this.gender = gender;
}
    public String getDateOfBirth(){
        return dateOfBirth;
    }
    public void setDateOfBirth(String dateOfBirth){
        this.dateOfBirth = dateOfBirth;
    }
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

//    private BigDecimal getPerformance(){ return performance; }

//    public void setPerformance(BigDecimal performance) {
//        this.performance = performance;
//    }
}
