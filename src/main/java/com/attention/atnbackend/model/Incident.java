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
@Document("incident")
public class Incident {

    @Id
    private UUID id;
    private String title;
    private String type;
    private String description;
    private Date dateTime;
    private String severity;
    private SuspiciousPlace suspiciousPlace;
    private List<SuspiciousPerson> suspiciousPeople;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

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

    public SuspiciousPlace getSuspiciousPlace() {
        return suspiciousPlace;
    }

    public void setSuspiciousPlace(SuspiciousPlace suspiciousPlace) {
        this.suspiciousPlace = suspiciousPlace;
    }

    public List<SuspiciousPerson> getSuspiciousPeople() {
        return suspiciousPeople;
    }

    public void setSuspiciousPeople(List<SuspiciousPerson> suspiciousPeople) {
        this.suspiciousPeople = suspiciousPeople;
    }
}
