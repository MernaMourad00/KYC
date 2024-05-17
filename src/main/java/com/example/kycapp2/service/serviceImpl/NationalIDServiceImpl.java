package com.example.kycapp2.service.serviceImpl;

import com.example.kycapp2.entity.IdStatus;
import com.example.kycapp2.entity.NationalID;
import com.example.kycapp2.exception.ResourceNotFoundException;
import com.example.kycapp2.repository.NationalIDRepository;
import com.example.kycapp2.service.NationalIDService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NationalIDServiceImpl implements NationalIDService {
    private final NationalIDRepository nationalIDRepository;

    @Autowired
    public NationalIDServiceImpl(NationalIDRepository nationalIDRepository) {
        this.nationalIDRepository = nationalIDRepository;
    }

    @Override
    public NationalID addNationalID(NationalID nationalID) {

        return nationalIDRepository.save(nationalID);
    }

    @Override
    public NationalID getNationalIDById(String id) {
        return nationalIDRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "National ID not found with id: " + id));
    }
    @Override
    public NationalID getNationalIDByNationalId(String nationalId) {
        return nationalIDRepository.findByNationalId(nationalId)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "National ID not found with national id: " + nationalId));
    }

    @Override
    public NationalID updateNationalID(NationalID nationalID) {

        return nationalIDRepository.save(nationalID);
    }


    @Override
    public void updateNationalIdStatus(String id, IdStatus newStatus, String comment) {
        Optional<NationalID> nationalID = nationalIDRepository.findById(id);
        if (nationalID.isPresent()) {
            NationalID nationalID1 = nationalID.get();
            nationalID1.setIdStatus(newStatus);

            // If the new status is REJECTED, set the rejection comment
            if (newStatus == IdStatus.REJECTED) {
                if (comment == null || comment.trim().isEmpty()) {
                    throw new IllegalArgumentException("A rejection comment is required when the status is REJECTED.");
                }
                nationalID1.setRejectionComment(comment);
            }

            nationalIDRepository.save(nationalID1);
        } else {
            throw new ResourceNotFoundException("OCR request not found with ID: " + id);
        }
    }

    @Override
    public List<NationalID> getNationalIDsByStatus(IdStatus status) {
        return nationalIDRepository.findByIdStatus(status);
    }

    @Override
    public void deleteNationalIDById(String id) {
        if (!nationalIDRepository.existsById(id)) {
            throw new ResourceNotFoundException("National ID not found with id: " + id);
        }
        nationalIDRepository.deleteById(id);
    }
    @Override
    public List<NationalID> getAllNationalIDs() {
        return nationalIDRepository.findAll();
    }
}

