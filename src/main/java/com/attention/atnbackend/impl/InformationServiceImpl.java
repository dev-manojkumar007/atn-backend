package com.attention.atnbackend.impl;

import com.attention.atnbackend.model.Address;
import com.attention.atnbackend.model.Incident;
import com.attention.atnbackend.model.SuspiciousPlace;
import com.attention.atnbackend.repository.AddressRepository;
import com.attention.atnbackend.repository.IncidentRepository;
import com.attention.atnbackend.repository.SuspiciousPlaceRepository;
import com.attention.atnbackend.service.InformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author : manojkumarpanchal
 * @created : 25/10/23, Wednesday
 **/
@Component
public class InformationServiceImpl implements InformationService {

    private IncidentRepository incidentRepository;
    private SuspiciousPlaceRepository suspiciousPlaceRepository;
    private AddressRepository addressRepository;

    @Autowired
    public void setIncidentRepository(IncidentRepository incidentRepository) {
        this.incidentRepository = incidentRepository;
    }

    @Autowired
    public void setSuspiciousPlaceRepository(SuspiciousPlaceRepository suspiciousPlaceRepository) {
        this.suspiciousPlaceRepository = suspiciousPlaceRepository;
    }

    @Autowired
    public void setAddressRepository(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    @Override
    public Incident getIncidentById(String incidentId) {
        if(incidentRepository.findById(incidentId).isPresent())
            return incidentRepository.findById(incidentId).get();
        else
            return null;
    }

    @Override
    public SuspiciousPlace getSuspiciousPlaceById(String placeId) {
        if(suspiciousPlaceRepository.findById(placeId).isPresent())
            return suspiciousPlaceRepository.findById(placeId).get();
        else
            return null;
    }

    @Override
    public Address getAddressById(String addressId) {
        if(addressRepository.findById(addressId).isPresent())
            return addressRepository.findById(addressId).get();
        else
            return null;
    }

}
