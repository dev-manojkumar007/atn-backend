package com.attention.atnbackend.repository;

import com.attention.atnbackend.model.Address;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * @author : manojkumarpanchal
 * @created : 20/10/23, Friday
 **/
@Repository
public interface AddressRepository extends MongoRepository<Address, String> {
}
