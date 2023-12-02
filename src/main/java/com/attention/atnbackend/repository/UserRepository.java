package com.attention.atnbackend.repository;

import com.attention.atnbackend.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * @author : manojkumarpanchal
 * @created : 20/10/23, Friday
 **/
@Repository
public interface UserRepository extends MongoRepository<User, String> {

    @Query("{\"mobile\" : ?0}")
    User findUserByMobile(String mobile);

    @Query("{\"email\" : ?0}")
    User findUserByEmail(String email);

    @Query("{\"governmentId\" : ?0}")
    User findUserByGovernmentId(String govtId);
}
