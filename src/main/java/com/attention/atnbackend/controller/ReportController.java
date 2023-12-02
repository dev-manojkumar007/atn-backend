package com.attention.atnbackend.controller;

import com.attention.atnbackend.dto.IncidentDto;
import com.attention.atnbackend.dto.SuspiciousPlaceDto;
import com.attention.atnbackend.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : manojkumarpanchal
 * @created : 24/10/23, Tuesday
 **/
@CrossOrigin(origins= {"*"}, maxAge = 4800, allowCredentials = "false" )
@RestController
@RequestMapping("/atn-report")
public class ReportController {

    private ReportService reportService;

    @Autowired
    public void setReportService(ReportService reportService) {
        this.reportService = reportService;
    }

    @PostMapping("/incident")
    public ResponseEntity<?> reportIncident(@RequestParam String userId,
                                         @RequestBody IncidentDto incidentDto) {
        return new ResponseEntity<>(reportService.reportIncident(userId, incidentDto), HttpStatus.OK);
    }

    @PostMapping("/suspicious-place")
    public ResponseEntity<?> reportSuspiciousPlace(@RequestParam String userId,
                                            @RequestBody SuspiciousPlaceDto suspiciousPlaceDto) {
        return new ResponseEntity<>(reportService.reportSuspiciousPlace(userId, suspiciousPlaceDto), HttpStatus.OK);
    }

    @PutMapping("/suspicious-place/upVote")
    public ResponseEntity<?> upVoteSuspiciousPlace(@RequestParam String suspiciousPlaceId,
                                                   @RequestParam String userId) {
        return new ResponseEntity<>(reportService.upVoteSuspiciousPlace(suspiciousPlaceId, userId), HttpStatus.OK);
    }

    @PutMapping("/suspicious-place/downVote")
    public ResponseEntity<?> downVoteSuspiciousPlace(@RequestParam String suspiciousPlaceId,
                                                     @RequestParam String userId) {
        return new ResponseEntity<>(reportService.downVoteSuspiciousPlace(suspiciousPlaceId, userId), HttpStatus.OK);
    }
}
