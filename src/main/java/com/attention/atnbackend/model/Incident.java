package com.attention.atnbackend.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;

/**
 * @author : manojkumarpanchal
 * @created : 20/10/23, Friday
 **/
@Document("incident")
public class Incident {

    @Id
    private String id;
    private String title;
    private String type;
    private String description;
    private Date dateTime;
    private String severity;
    private String suspiciousPlaceId;
    private List<SuspiciousPerson> suspiciousPeople;
    private String reportStatus;
    private String userId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
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

    public String getSuspiciousPlaceId() {
        return suspiciousPlaceId;
    }

    public void setSuspiciousPlaceId(String suspiciousPlaceId) {
        this.suspiciousPlaceId = suspiciousPlaceId;
    }

    public List<SuspiciousPerson> getSuspiciousPeople() {
        return suspiciousPeople;
    }

    public void setSuspiciousPeople(List<SuspiciousPerson> suspiciousPeople) {
        this.suspiciousPeople = suspiciousPeople;
    }

    public String getReportStatus() {
        return reportStatus;
    }

    public void setReportStatus(String reportStatus) {
        this.reportStatus = reportStatus;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
