package com.attention.atnbackend.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;

/**
 * @author : manojkumarpanchal
 * @created : 20/10/23, Friday
 **/
@Document("user")
public class User {

    @Id
    private String id;
    private String name;
    private String gender;
    private Date dateOfBirth;
    private String mobile;
    private String email;
    private String governmentId;
    private String password;
    private List<Incident> incidentsReported;
    private List<SuspiciousPlace> placesReported;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGovernmentId() {
        return governmentId;
    }

    public void setGovernmentId(String governmentId) {
        this.governmentId = governmentId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Incident> getIncidentsReported() {
        return incidentsReported;
    }

    public void setIncidentsReported(List<Incident> incidentsReported) {
        this.incidentsReported = incidentsReported;
    }

    public List<SuspiciousPlace> getPlacesReported() {
        return placesReported;
    }

    public void setPlacesReported(List<SuspiciousPlace> placesReported) {
        this.placesReported = placesReported;
    }
}
