package com.attention.atnbackend.dto;

import com.attention.atnbackend.model.Address;

import java.util.List;
import java.util.Map;

/**
 * @author : manojkumarpanchal
 * @created : 01/11/23, Wednesday
 **/
public class SuspiciousPlaceDto {

    private String title;
    private Address address;
    private Integer severityIndex;
    private List<String> vulnerabilities;

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

    public List<String> getVulnerabilities() {
        return vulnerabilities;
    }

    public void setVulnerabilities(List<String> vulnerabilities) {
        this.vulnerabilities = vulnerabilities;
    }
}
