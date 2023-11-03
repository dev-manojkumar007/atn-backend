package com.attention.atnbackend.dto;

import com.attention.atnbackend.model.SuspiciousPerson;
import com.attention.atnbackend.model.SuspiciousPlace;

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
    private Date dateTime;
    private String severity;
    private SuspiciousPlaceDto suspiciousPlaceDto;
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

    public Date getDateTime() {
        return dateTime;
    }

    public void setDateTime(Date dateTime) {
        this.dateTime = dateTime;
    }

    public String getSeverity() {
        return severity;
    }

    public void setSeverity(String severity) {
        this.severity = severity;
    }

    public SuspiciousPlaceDto getSuspiciousPlaceDto() {
        return suspiciousPlaceDto;
    }

    public void setSuspiciousPlaceDto(SuspiciousPlaceDto suspiciousPlaceDto) {
        this.suspiciousPlaceDto = suspiciousPlaceDto;
    }

    public List<SuspiciousPerson> getSuspiciousPeople() {
        return suspiciousPeople;
    }

    public void setSuspiciousPeople(List<SuspiciousPerson> suspiciousPeople) {
        this.suspiciousPeople = suspiciousPeople;
    }
}
