package com.attention.atnbackend.controller;

import com.attention.atnbackend.dto.SuspiciousPlaceVoteDto;
import com.attention.atnbackend.model.Incident;
import com.attention.atnbackend.model.SuspiciousPlace;
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
                                         @RequestBody Incident incident) {
        return new ResponseEntity<>(reportService.reportIncident(userId, incident), HttpStatus.CREATED);
    }

    @PostMapping("/suspicious-place")
    public ResponseEntity<?> reportSuspiciousPlace(@RequestParam String userId,
                                            @RequestBody SuspiciousPlace suspiciousPlace) {
        return new ResponseEntity<>(reportService.reportSuspiciousPlace(userId, suspiciousPlace), HttpStatus.OK);
    }

    @PutMapping("/suspicious-place/upVote")
    public ResponseEntity<?> upVoteSuspiciousPlace(@RequestBody SuspiciousPlaceVoteDto suspiciousPlaceVoteDto) {
        return new ResponseEntity<>(reportService.upVoteSuspiciousPlace(suspiciousPlaceVoteDto), HttpStatus.OK);
    }

    @PutMapping("/suspicious-place/downVote")
    public ResponseEntity<?> downVoteSuspiciousPlace(@RequestBody SuspiciousPlaceVoteDto suspiciousPlaceVoteDto) {
        return new ResponseEntity<>(reportService.downVoteSuspiciousPlace(suspiciousPlaceVoteDto), HttpStatus.OK);
    }
}
