package com.attention.atnbackend.dto;

import java.util.List;

/**
 * @author : manojkumarpanchal
 * @created : 24/10/23, Tuesday
 **/
public class SuspiciousPlaceVoteDto {

    private String userId;
    private Integer severityIndex;
    private List<String> vulnerabilities;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Integer getSeverityIndex() {
        return severityIndex;
    }

    public void setSeverityIndex(Integer severityIndex) {
        this.severityIndex = severityIndex;
    }

    public List<String> getVulnerabilities() {
        return vulnerabilities;
    }

    public void setVulnerabilities(List<String> vulnerabilities) {
        this.vulnerabilities = vulnerabilities;
    }
}
