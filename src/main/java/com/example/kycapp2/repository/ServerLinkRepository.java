package com.example.kycapp2.repository;

import com.example.kycapp2.entity.ServerLink;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServerLinkRepository extends MongoRepository<ServerLink,String> {

}
