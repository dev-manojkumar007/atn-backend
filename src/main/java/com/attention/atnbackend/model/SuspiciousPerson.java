package com.attention.atnbackend.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

/**
 * @author : manojkumarpanchal
 * @created : 20/10/23, Friday
 **/
@Document("suspicious_person")
public class SuspiciousPerson {

    @Id
    private UUID id;
    private String knownName;
    private String appearance;
    private Integer approximateAge;
    private String gender;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getKnownName() {
        return knownName;
    }

    public void setKnownName(String knownName) {
        this.knownName = knownName;
    }

    public String getAppearance() {
        return appearance;
    }

    public void setAppearance(String appearance) {
        this.appearance = appearance;
    }

    public Integer getApproximateAge() {
        return approximateAge;
    }

    public void setApproximateAge(Integer approximateAge) {
        this.approximateAge = approximateAge;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}