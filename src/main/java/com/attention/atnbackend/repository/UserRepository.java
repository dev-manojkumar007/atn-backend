package com.attention.atnbackend.repository;

import com.attention.atnbackend.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * @author : manojkumarpanchal
 * @created : 20/10/23, Friday
 **/
@Repository
public interface UserRepository extends MongoRepository<User, String> {

    User findUserByMobile(String mobile);
    User findUserByEmail(String email);
    User findUserByGovernmentId(String govtId);
}
