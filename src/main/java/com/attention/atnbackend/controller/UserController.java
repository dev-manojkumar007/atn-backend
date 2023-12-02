package com.attention.atnbackend.controller;

import com.attention.atnbackend.dto.UserDto;
import com.attention.atnbackend.repository.UserRepository;
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
    private UserRepository userRepository;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping("/user")
    public ResponseEntity<?> createUser(@RequestBody UserDto userDto) {

        if(userRepository.findUserByEmail(userDto.getEmail()) != null)
            return new ResponseEntity<>("User already exist in system with given Email", HttpStatus.BAD_REQUEST);

        if(userRepository.findUserByMobile(userDto.getMobile()) != null)
            return new ResponseEntity<>("User already exist in system with given Mobile Number", HttpStatus.BAD_REQUEST);

        if(userRepository.findUserByGovernmentId(userDto.getGovernmentId()) != null)
            return new ResponseEntity<>("User already exist in system with given Government ID", HttpStatus.BAD_REQUEST);

        return new ResponseEntity<>(userService.createUser(userDto), HttpStatus.OK);
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<?> getUserById(@PathVariable String id) {
        if(userService.getUserById(id) == null) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(userService.getUserById(id), HttpStatus.OK);
    }

    @GetMapping("/user/email/{email}")
    public ResponseEntity<?> getUserByEmail(@PathVariable String email) {
        if(userService.getUserByEmail(email) == null) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(userService.getUserByEmail(email), HttpStatus.OK);
    }

    @GetMapping("/user/mobile/{mobile}")
    public ResponseEntity<?> getUserByMobile(@PathVariable String mobile) {
        if(userService.getUserByMobile(mobile) == null) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(userService.getUserByMobile(mobile), HttpStatus.OK);
    }

    @GetMapping("/user/government")
    public ResponseEntity<?> getUserByGovtId(@RequestParam String govtId) {
        if(userService.getUserByGovtId(govtId) == null) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(userService.getUserByGovtId(govtId), HttpStatus.OK);
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
