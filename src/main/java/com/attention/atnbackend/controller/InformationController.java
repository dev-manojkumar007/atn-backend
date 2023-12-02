package com.attention.atnbackend.controller;

import com.attention.atnbackend.service.InformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : manojkumarpanchal
 * @created : 24/10/23, Tuesday
 **/
@CrossOrigin(origins= {"*"}, maxAge = 4800, allowCredentials = "false" )
@RestController
@RequestMapping("/atn-information")
public class InformationController {

    private InformationService informationService;

    @Autowired
    public void setInformationService(InformationService informationService) {
        this.informationService = informationService;
    }

    @GetMapping("/incident/{incidentId}")
    public ResponseEntity<?> getIncidentById(@PathVariable String incidentId) {

        if(informationService.getIncidentById(incidentId) == null) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(informationService.getIncidentById(incidentId), HttpStatus.OK);
    }

    @GetMapping("/suspicious-place/{placeId}")
    public ResponseEntity<?> getSuspiciousPlaceById(@PathVariable String placeId) {
        if(informationService.getSuspiciousPlaceById(placeId) == null) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(informationService.getSuspiciousPlaceById(placeId), HttpStatus.OK);
    }

    @GetMapping("/address/{addressId}")
    public ResponseEntity<?> getAddressById(@PathVariable String addressId) {
        if(informationService.getAddressById(addressId) == null) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(informationService.getAddressById(addressId), HttpStatus.OK);
    }
}
