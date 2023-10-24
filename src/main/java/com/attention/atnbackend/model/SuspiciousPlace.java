package com.attention.atnbackend.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Map;

/**
 * @author : manojkumarpanchal
 * @created : 20/10/23, Friday
 **/
@Document("suspicious_place")
public class SuspiciousPlace {

    @Id
    private String id;
    private String title;
    private Address address;
    private Integer severityIndex;
    private Integer incidentsReported;
    private Integer upVotes;
    private Integer downVotes;
    private Map<String, Integer> vulnerabilities;

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

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Integer getSeverityIndex() {
        return severityIndex;
    }

    public void setSeverityIndex(Integer severityIndex) {
        this.severityIndex = severityIndex;
    }

    public Integer getIncidentsReported() {
        return incidentsReported;
    }

    public void setIncidentsReported(Integer incidentsReported) {
        this.incidentsReported = incidentsReported;
    }

    public Integer getUpVotes() {
        return upVotes;
    }

    public void setUpVotes(Integer upVotes) {
        this.upVotes = upVotes;
    }

    public Integer getDownVotes() {
        return downVotes;
    }

    public void setDownVotes(Integer downVotes) {
        this.downVotes = downVotes;
    }

    public Map<String, Integer> getVulnerabilities() {
        return vulnerabilities;
    }

    public void setVulnerabilities(Map<String, Integer> vulnerabilities) {
        this.vulnerabilities = vulnerabilities;
    }
}
