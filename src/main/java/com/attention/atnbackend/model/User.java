package com.attention.atnbackend.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * @author : manojkumarpanchal
 * @created : 20/10/23, Friday
 **/
@Document("user")
public class User {

    @Id
    private UUID id;
    private String name;
    private String gender;
    private Date dateOfBirth;
    private String mobile;
    private String email;
    private String governmentId;
    private List<Incident> incidentsReported;
    private List<SuspiciousPlace> placesReported;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
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
