package com.attention.atnbackend.service;

import com.attention.atnbackend.dto.IncidentDto;
import com.attention.atnbackend.dto.SuspiciousPlaceDto;
import com.attention.atnbackend.model.Incident;
import com.attention.atnbackend.model.SuspiciousPlace;
import org.springframework.stereotype.Service;

/**
 * @author : manojkumarpanchal
 * @created : 24/10/23, Tuesday
 **/
@Service
public interface ReportService {

    Incident reportIncident(String userId, IncidentDto incidentDto);
    SuspiciousPlace reportSuspiciousPlace(String userId, SuspiciousPlaceDto suspiciousPlaceDto);
    Boolean upVoteSuspiciousPlace(String suspiciousPlaceId);
    Boolean downVoteSuspiciousPlace(String suspiciousPlaceId);
}
