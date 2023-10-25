package com.attention.atnbackend.impl;

import com.attention.atnbackend.model.Incident;
import com.attention.atnbackend.model.SuspiciousPlace;
import com.attention.atnbackend.model.User;
import com.attention.atnbackend.repository.UserRepository;
import com.attention.atnbackend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.UUID;

/**
 * @author : manojkumarpanchal
 * @created : 25/10/23, Wednesday
 **/
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User createUser(User user) {
        user.setId(UUID.randomUUID().toString());
        return userRepository.save(user);
    }

    @Override
    public User getUserById(String id) {
        return userRepository.findById(id).get();
    }

    @Override
    public User getUserByMobile(String mobile) {
        return null;
    }

    @Override
    public User getUserByEmail(String email) {
        return null;
    }

    @Override
    public User getUserByGovtId(String governmentId) {
        return null;
    }

    @Override
    public List<Incident> getIncidentsReportedByUser(String userId) {
        return null;
    }

    @Override
    public List<SuspiciousPlace> getSusPlacesReportedByUser(String userId) {
        return null;
    }
}
