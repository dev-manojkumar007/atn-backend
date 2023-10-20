package com.attention.atnbackend.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.UUID;

/**
 * @author : manojkumarpanchal
 * @created : 20/10/23, Friday
 **/
@Document("suspicious_place")
public class SuspiciousPlace {

    @Id
    private UUID id;
    private String title;
    private Address address;
    private String severityIndex;
    private Integer incidentsReported;
    private List<String> vulnerabilities;

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

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getSeverityIndex() {
        return severityIndex;
    }

    public void setSeverityIndex(String severityIndex) {
        this.severityIndex = severityIndex;
    }

    public Integer getIncidentsReported() {
        return incidentsReported;
    }

    public void setIncidentsReported(Integer incidentsReported) {
        this.incidentsReported = incidentsReported;
    }

    public List<String> getVulnerabilities() {
        return vulnerabilities;
    }

    public void setVulnerabilities(List<String> vulnerabilities) {
        this.vulnerabilities = vulnerabilities;
    }
}
