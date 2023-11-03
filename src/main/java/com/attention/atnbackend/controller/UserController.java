package com.attention.atnbackend.controller;

import com.attention.atnbackend.model.User;
import com.attention.atnbackend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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
@RequestMapping("/atn-user")
public class UserController {

    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/user")
    public ResponseEntity<?> createUser(@RequestBody User user) {
        return new ResponseEntity<>(userService.createUser(user), HttpStatus.OK);
    }

    @GetMapping("/user/email/{email}")
    public ResponseEntity<?> getUserByEmail(@PathVariable String email) {
        User user = userService.getUserByEmail(email);
        if(user == null)
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);

        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @GetMapping("/user/mobile/{mobile}")
    public ResponseEntity<?> getUserByMobile(@PathVariable String mobile) {
        User user = userService.getUserByMobile(mobile);
        if(user == null)
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);

        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @GetMapping("/user/government")
    public ResponseEntity<?> getUserByGovtId(@RequestParam String govtId) {
        User user = userService.getUserByGovtId(govtId);
        if(user == null)
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);

        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @GetMapping("/user/incident/{userId}")
    public ResponseEntity<?> getAllIncidents(@PathVariable String userId) {
        return new ResponseEntity<>(userService.getIncidentsReportedByUser(userId), HttpStatus.OK);
    }

    @GetMapping("/user/suspicious-place/{userId}")
    public ResponseEntity<?> getAllSuspiciousPlaces(@PathVariable String userId) {
        return new ResponseEntity<>(userService.getSusPlacesReportedByUser(userId), HttpStatus.OK);
    }
}
