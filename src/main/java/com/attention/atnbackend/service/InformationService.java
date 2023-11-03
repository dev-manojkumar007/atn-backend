package com.attention.atnbackend.service;

import com.attention.atnbackend.model.Incident;
import com.attention.atnbackend.model.SuspiciousPlace;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author : manojkumarpanchal
 * @created : 24/10/23, Tuesday
 **/
@Service
public interface InformationService {

    Incident getIncidentById(String incidentId);
    SuspiciousPlace getSuspiciousPlaceById(String placeId);
}
