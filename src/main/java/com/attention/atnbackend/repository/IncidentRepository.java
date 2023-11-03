package com.attention.atnbackend.repository;

import com.attention.atnbackend.model.Incident;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author : manojkumarpanchal
 * @created : 20/10/23, Friday
 **/
@Repository
public interface IncidentRepository extends MongoRepository<Incident, String> {

    List<Incident> getAllIncidentsReportedByUser(String userId);
}
