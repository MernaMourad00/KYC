package com.example.kycapp2.repository;

import com.example.kycapp2.entity.IdStatus;
import com.example.kycapp2.entity.NationalID;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface NationalIDRepository extends MongoRepository<NationalID,String> {

    List<NationalID> findByIdStatus(IdStatus status);
    Optional<NationalID> findByNationalId(String nationalId);

}
