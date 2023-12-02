package com.attention.atnbackend.service;

import com.attention.atnbackend.dto.UserDto;
import com.attention.atnbackend.model.Incident;
import com.attention.atnbackend.model.SuspiciousPlace;
import com.attention.atnbackend.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author : manojkumarpanchal
 * @created : 24/10/23, Tuesday
 **/
@Service
public interface UserService {

    User createUser(UserDto userDto);
    User getUserById(String id);
    User getUserByMobile(String mobile);
    User getUserByEmail(String email);
    User getUserByGovtId(String governmentId);
    List<Incident> getIncidentsReportedByUser(String userId);
    List<SuspiciousPlace> getSusPlacesReportedByUser(String userId);
}
