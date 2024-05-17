package com.example.kycapp2.service;

import com.example.kycapp2.entity.IdStatus;
import com.example.kycapp2.entity.NationalID;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface NationalIDService {

    NationalID addNationalID(NationalID nationalID);

    NationalID getNationalIDById(String id);
    NationalID getNationalIDByNationalId(String nationalId);

    NationalID updateNationalID(NationalID nationalID);

    void updateNationalIdStatus(String id, IdStatus newStatus, String comment);
    List<NationalID> getNationalIDsByStatus(IdStatus status);

    void deleteNationalIDById(String id);

    List<NationalID> getAllNationalIDs();
}
