package com.example.kycapp2.repository;

import com.example.kycapp2.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends MongoRepository<User,String> {
    Optional<User> findByUsername(String username);
    Optional<User> findByUsernameOrEmail(String username,String email);

    Boolean existsByUsername(String username);

    Boolean existsByEmail(String email);
}
