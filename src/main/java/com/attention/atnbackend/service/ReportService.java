package com.attention.atnbackend.service;

import com.attention.atnbackend.dto.SuspiciousPlaceVoteDto;
import com.attention.atnbackend.model.Incident;
import com.attention.atnbackend.model.SuspiciousPlace;
import org.springframework.stereotype.Service;

/**
 * @author : manojkumarpanchal
 * @created : 24/10/23, Tuesday
 **/
@Service
public interface ReportService {

    Incident reportIncident(String userId, Incident incident);
    SuspiciousPlace reportSuspiciousPlace(String userId, SuspiciousPlace suspiciousPlace);
    Boolean upVoteSuspiciousPlace(SuspiciousPlaceVoteDto suspiciousPlaceVoteDto);
    Boolean downVoteSuspiciousPlace(SuspiciousPlaceVoteDto suspiciousPlaceVoteDto);
}
