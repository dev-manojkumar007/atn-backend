package com.attention.atnbackend.impl;

import com.attention.atnbackend.model.Incident;
import com.attention.atnbackend.model.SuspiciousPlace;
import com.attention.atnbackend.repository.IncidentRepository;
import com.attention.atnbackend.repository.SuspiciousPlaceRepository;
import com.attention.atnbackend.service.InformationService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : manojkumarpanchal
 * @created : 25/10/23, Wednesday
 **/
public class InformationServiceImpl implements InformationService {

    private IncidentRepository incidentRepository;
    private SuspiciousPlaceRepository suspiciousPlaceRepository;

    @Autowired
    public void setIncidentRepository(IncidentRepository incidentRepository) {
        this.incidentRepository = incidentRepository;
    }

    @Autowired
    public void setSuspiciousPlaceRepository(SuspiciousPlaceRepository suspiciousPlaceRepository) {
        this.suspiciousPlaceRepository = suspiciousPlaceRepository;
    }

    @Override
    public Incident getIncidentById(String incidentId) {
        return incidentRepository.findById(incidentId).get();
    }

    @Override
    public SuspiciousPlace getSuspiciousPlaceById(String placeId) {
        return suspiciousPlaceRepository.findById(placeId).get();
    }
}
