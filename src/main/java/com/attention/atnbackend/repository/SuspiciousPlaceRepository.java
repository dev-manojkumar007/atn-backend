package com.attention.atnbackend.repository;

import com.attention.atnbackend.model.SuspiciousPlace;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * @author : manojkumarpanchal
 * @created : 20/10/23, Friday
 **/
@Repository
public interface SuspiciousPlaceRepository extends MongoRepository<SuspiciousPlace, String> {

    @Query("{\"addressId\" : ?0}")
    SuspiciousPlace findSuspiciousPlaceByAddressId(String addressId);
}
