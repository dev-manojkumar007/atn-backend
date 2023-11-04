package com.attention.atnbackend.impl;

import com.attention.atnbackend.dto.IncidentDto;
import com.attention.atnbackend.dto.SuspiciousPlaceDto;
import com.attention.atnbackend.exception.IncidentOperationException;
import com.attention.atnbackend.exception.SuspiciousPlaceOperationException;
import com.attention.atnbackend.model.Address;
import com.attention.atnbackend.model.Incident;
import com.attention.atnbackend.model.ReportStatus;
import com.attention.atnbackend.model.SuspiciousPerson;
import com.attention.atnbackend.model.SuspiciousPlace;
import com.attention.atnbackend.model.User;
import com.attention.atnbackend.repository.AddressRepository;
import com.attention.atnbackend.repository.IncidentRepository;
import com.attention.atnbackend.repository.SuspiciousPlaceRepository;
import com.attention.atnbackend.repository.UserRepository;
import com.attention.atnbackend.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * @author : manojkumarpanchal
 * @created : 01/11/23, Wednesday
 **/
public class ReportServiceImpl implements ReportService {

    private IncidentRepository incidentRepository;
    private SuspiciousPlaceRepository suspiciousPlaceRepository;
    private UserRepository userRepository;
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
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Autowired
    public void setAddressRepository(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    @Override
    public Incident reportIncident(String userId, IncidentDto incidentDto) {

        Incident incident = new Incident();
        try {

            SuspiciousPlace suspiciousPlace = null;
            try {

                // Adding/Updating Suspicious Place
                if(addressRepository.findById(incidentDto.getSuspiciousPlaceDto().getAddress().getId()).get() != null) {

                    // If place already reported, just update the suspicious place.
                    suspiciousPlace = suspiciousPlaceRepository.findSuspiciousPlaceByAddressId(incidentDto.getSuspiciousPlaceDto().getAddress().getId());
                    suspiciousPlace.setNumberOfIncidentsReported(suspiciousPlace.getNumberOfIncidentsReported()+1);
                    suspiciousPlace.setSeverityIndex(calculateAverageSeverityIndex(suspiciousPlace, incidentDto.getSuspiciousPlaceDto().getSeverityIndex()));

                } else {

                    // Else add new place
                    suspiciousPlace = new SuspiciousPlace();

                    String addressId = UUID.randomUUID().toString();
                    Address address = incidentDto.getSuspiciousPlaceDto().getAddress();
                    address.setId(addressId);
                    addressRepository.save(address);

                    String suspiciousPlaceId = UUID.randomUUID().toString();
                    suspiciousPlace.setId(suspiciousPlaceId);
                    suspiciousPlace.setTitle(incidentDto.getSuspiciousPlaceDto().getTitle());
                    suspiciousPlace.setAddressId(addressId);
                    suspiciousPlace.setDownVotes(0);
                    suspiciousPlace.setUpVotes(0);
                    suspiciousPlace.setSeverityIndex(incidentDto.getSuspiciousPlaceDto().getSeverityIndex());
                    suspiciousPlace.setNumberOfIncidentsReported(1);
                    suspiciousPlace.setNumberOfReportsByUser(0);
                }

                suspiciousPlace.setVulnerabilities(updateVulnerabilitiesData(suspiciousPlace, incidentDto.getSuspiciousPlaceDto().getVulnerabilities()));
                suspiciousPlaceRepository.save(suspiciousPlace);
            } catch (Exception e) {
                throw new SuspiciousPlaceOperationException("Error saving/updating Suspicious Place", e);
            }

            // Adding suspicious person, if any
            if(incidentDto.getSuspiciousPeople() != null && !incidentDto.getSuspiciousPeople().isEmpty()) {
                List<SuspiciousPerson> suspiciousPeople = new ArrayList<>();
                for(SuspiciousPerson suspiciousPerson : incidentDto.getSuspiciousPeople()) {
                    String personId = UUID.randomUUID().toString();
                    suspiciousPerson.setId(personId);
                    suspiciousPeople.add(suspiciousPerson);
                }
                incident.setSuspiciousPeople(suspiciousPeople);
            }

            // Adding new incident
            String incidentId = UUID.randomUUID().toString();
            incident.setId(incidentId);
            incident.setTitle(incidentDto.getTitle());
            incident.setReportStatus(ReportStatus.SUBMITTED.toString());
            incident.setDateTime(incidentDto.getDateTime());
            incident.setDescription(incidentDto.getDescription());
            incident.setSeverity(incidentDto.getSeverity());
            incident.setType(incidentDto.getType());
            incident.setSuspiciousPlaceId(suspiciousPlace.getId());
            incident.setUserId(userId);
            incidentRepository.save(incident);

        } catch (Exception e) {
            throw new IncidentOperationException("Error saving new Incident Data", e);
        }
        return incident;
    }

    @Override
    public SuspiciousPlace reportSuspiciousPlace(String userId, SuspiciousPlaceDto suspiciousPlaceDto) {
        SuspiciousPlace suspiciousPlace = null;

        try{
            // Check if place already reported, then update the place data else save the new place
            if(addressRepository.findById(suspiciousPlaceDto.getAddress().getId()) != null) {

                suspiciousPlace = suspiciousPlaceRepository.findSuspiciousPlaceByAddressId(suspiciousPlaceDto.getAddress().getId());
                suspiciousPlace.setSeverityIndex(calculateAverageSeverityIndex(suspiciousPlace, suspiciousPlaceDto.getSeverityIndex()));
                suspiciousPlace.setNumberOfReportsByUser(suspiciousPlace.getNumberOfReportsByUser() + 1);

            } else {
                suspiciousPlace = new SuspiciousPlace();

                String addressId = UUID.randomUUID().toString();
                Address address = suspiciousPlaceDto.getAddress();
                address.setId(addressId);
                addressRepository.save(address);

                String suspiciousPlaceId = UUID.randomUUID().toString();
                suspiciousPlace.setId(suspiciousPlaceId);
                suspiciousPlace.setTitle(suspiciousPlaceDto.getTitle());
                suspiciousPlace.setAddressId(addressId);
                suspiciousPlace.setDownVotes(0);
                suspiciousPlace.setUpVotes(0);
                suspiciousPlace.setSeverityIndex(suspiciousPlaceDto.getSeverityIndex());
                suspiciousPlace.setNumberOfIncidentsReported(0);
                suspiciousPlace.setNumberOfReportsByUser(1);
            }

            suspiciousPlace.setVulnerabilities(updateVulnerabilitiesData(suspiciousPlace, suspiciousPlaceDto.getVulnerabilities()));
            suspiciousPlaceRepository.save(suspiciousPlace);

            User user = userRepository.findById(userId).get();
            List<String> reportedPlaces = user.getPlacesReported();
            reportedPlaces.add(suspiciousPlace.getId());
            user.setPlacesReported(reportedPlaces);
            userRepository.save(user);

        } catch (Exception e) {
            throw new SuspiciousPlaceOperationException("Error saving/updating Suspicious Place", e);
        }
        return suspiciousPlace;
    }

    @Override
    public Boolean upVoteSuspiciousPlace(String suspiciousPlaceId) {
        try {
            SuspiciousPlace suspiciousPlace = suspiciousPlaceRepository.findById(suspiciousPlaceId).get();
            suspiciousPlace.setUpVotes(suspiciousPlace.getUpVotes()+1);
            suspiciousPlaceRepository.save(suspiciousPlace);
            return true;
        } catch (Exception e) {
            throw new SuspiciousPlaceOperationException("Error while suspicious place upVote", e);
        }
    }

    @Override
    public Boolean downVoteSuspiciousPlace(String suspiciousPlaceId) {
        try {
            SuspiciousPlace suspiciousPlace = suspiciousPlaceRepository.findById(suspiciousPlaceId).get();
            suspiciousPlace.setDownVotes(suspiciousPlace.getDownVotes()+1);
            suspiciousPlaceRepository.save(suspiciousPlace);
            return true;
        } catch (Exception e) {
            throw new SuspiciousPlaceOperationException("Error while suspicious place downVote", e);
        }
    }

    private Integer calculateAverageSeverityIndex(SuspiciousPlace suspiciousPlace, Integer newSeverityIndex) {

        int totalReportsNumber = suspiciousPlace.getNumberOfIncidentsReported() + suspiciousPlace.getNumberOfReportsByUser();
        int avgSeverityIndex = (suspiciousPlace.getSeverityIndex() * totalReportsNumber +
                newSeverityIndex) / (totalReportsNumber+1);
        return  avgSeverityIndex;
    }

    private Map<String, Integer> updateVulnerabilitiesData(SuspiciousPlace suspiciousPlace, List<String> newVulnerabilities) {
        Map<String, Integer> vulnerabilities = new HashMap<>();
        for (String vulnerability : newVulnerabilities) {
            if(suspiciousPlace.getVulnerabilities().get(vulnerability) != null) {
                vulnerabilities.put(vulnerability, suspiciousPlace.getVulnerabilities().get(vulnerability) + 1);
            } else {
                vulnerabilities.put(vulnerability, 1);
            }
        }
        return  vulnerabilities;
    }
}
