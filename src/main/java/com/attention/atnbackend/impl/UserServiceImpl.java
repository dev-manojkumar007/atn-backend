package com.attention.atnbackend.impl;

import com.attention.atnbackend.dto.UserDto;
import com.attention.atnbackend.model.Incident;
import com.attention.atnbackend.model.SuspiciousPlace;
import com.attention.atnbackend.model.User;
import com.attention.atnbackend.repository.IncidentRepository;
import com.attention.atnbackend.repository.SuspiciousPlaceRepository;
import com.attention.atnbackend.repository.UserRepository;
import com.attention.atnbackend.service.UserService;
import com.attention.atnbackend.util.ApplicationUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

/**
 * @author : manojkumarpanchal
 * @created : 25/10/23, Wednesday
 **/
@Component
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    private IncidentRepository incidentRepository;
    private SuspiciousPlaceRepository suspiciousPlaceRepository;

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Autowired
    public void setIncidentRepository(IncidentRepository incidentRepository) {
        this.incidentRepository = incidentRepository;
    }

    @Autowired
    public void setSuspiciousPlaceRepository(SuspiciousPlaceRepository suspiciousPlaceRepository) {
        this.suspiciousPlaceRepository = suspiciousPlaceRepository;
    }

    @Override
    public User createUser(UserDto userDto) {
        User user = new User();
        user.setId(UUID.randomUUID().toString());
        user.setEmail(userDto.getEmail());
        user.setGender(userDto.getGender());
        user.setMobile(userDto.getMobile());
        user.setName(userDto.getName());
        user.setGovernmentId(userDto.getGovernmentId());
        user.setGovernmentIdType(userDto.getGovernmentIdType());
        user.setPassword(userDto.getPassword());
        user.setPlacesReported(Collections.emptyList());
        user.setUpVotePlaces(Collections.emptyList());
        user.setDownVotePlaces(Collections.emptyList());
        user.setDateOfBirth(ApplicationUtil.formatDate(userDto.getDateOfBirth()));
        return userRepository.save(user);
    }

    @Override
    public User getUserById(String id) {
        if(userRepository.findById(id).isPresent())
            return userRepository.findById(id).get();
        else
            return null;
    }

    @Override
    public User getUserByMobile(String mobile) {
        return userRepository.findUserByMobile(mobile);
    }

    @Override
    public User getUserByEmail(String email) {
        return userRepository.findUserByEmail(email);
    }

    @Override
    public User getUserByGovtId(String governmentId) {
        return userRepository.findUserByGovernmentId(governmentId);
    }

    @Override
    public List<Incident> getIncidentsReportedByUser(String userId) {
        return incidentRepository.getAllIncidentsReportedByUser(userId);
    }

    @Override
    public List<SuspiciousPlace> getSusPlacesReportedByUser(String userId) {
        if(userRepository.findById(userId) == null) {
            return null;
        }

        List<String> suspiciousPlaceIds = userRepository.findById(userId).get().getPlacesReported();
        List<SuspiciousPlace> suspiciousPlaces = new ArrayList<>();

        for(String suspiciousPlaceId : suspiciousPlaceIds)
            suspiciousPlaces.add(suspiciousPlaceRepository.findById(suspiciousPlaceId).get());

        return suspiciousPlaces;
    }
}
