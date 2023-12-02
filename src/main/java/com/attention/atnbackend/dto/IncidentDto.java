package com.attention.atnbackend.dto;

import com.attention.atnbackend.model.SuspiciousPerson;

import java.util.Date;
import java.util.List;

/**
 * @author : manojkumarpanchal
 * @created : 01/11/23, Wednesday
 **/
public class IncidentDto {

    private String title;
    private String type;
    private String description;
    private String dateTime;
    private String severity;
    private SuspiciousPlaceDto suspiciousPlace;
    private List<SuspiciousPerson> suspiciousPeople;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public String getSeverity() {
        return severity;
    }

    public void setSeverity(String severity) {
        this.severity = severity;
    }

    public SuspiciousPlaceDto getSuspiciousPlace() {

        return suspiciousPlace;
    }

    public void setSuspiciousPlace(SuspiciousPlaceDto suspiciousPlace) {
        this.suspiciousPlace = suspiciousPlace;
    }

    public List<SuspiciousPerson> getSuspiciousPeople() {
        return suspiciousPeople;
    }

    public void setSuspiciousPeople(List<SuspiciousPerson> suspiciousPeople) {
        this.suspiciousPeople = suspiciousPeople;
    }
}
