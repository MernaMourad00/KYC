package com.example.kycapp2.controller;

import com.example.kycapp2.entity.IdStatus;
import com.example.kycapp2.entity.NationalID;
import com.example.kycapp2.payload.UpdateNationalIdDTO;
import com.example.kycapp2.service.NationalIDService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*",maxAge = 3600)
@RestController
@RequestMapping("/api/nationalId")
@Tag(
        name = "CRUD REST APIs for National ID Resource"
)
public class NationalIDController {
    private final NationalIDService nationalIDService;

    @Autowired
    public NationalIDController(NationalIDService nationalIDService) {
        this.nationalIDService = nationalIDService;
    }

    // Add a new NationalID
    @SecurityRequirement(
            name = "Bear Authentication"
    )
    @PostMapping("/add")
    public ResponseEntity<NationalID> addNationalID(@RequestBody NationalID nationalID) {
        nationalID.setIdStatus(IdStatus.PENDING);
        NationalID addedNationalID = nationalIDService.addNationalID(nationalID);
        return new ResponseEntity<>(addedNationalID, HttpStatus.CREATED);
    }

    // Get a NationalID by ID
    @GetMapping("/{id}")
    @SecurityRequirement(
            name = "Bear Authentication"
    )
    public ResponseEntity<NationalID> getNationalIDById(@PathVariable String id) {
        NationalID nationalID = nationalIDService.getNationalIDById(id);

            return ResponseEntity.ok(nationalID);
    }

    @PutMapping("/{id}")
    @SecurityRequirement(
            name = "Bear Authentication"
    )    public ResponseEntity<NationalID> updateNationalID(@PathVariable String id, @RequestBody NationalID updatedNationalID) {
        NationalID existingNationalID = nationalIDService.getNationalIDById(id);
        updatedNationalID.setId(id);
        NationalID nationalID = nationalIDService.updateNationalID(updatedNationalID);
        return ResponseEntity.ok(nationalID);
    }

    // Delete a NationalID by ID
    @DeleteMapping("/{id}")
    @SecurityRequirement(
            name = "Bear Authentication"
    )
    public ResponseEntity<Void> deleteNationalIDById(@PathVariable String id) {
            return ResponseEntity.noContent().build();
    }

    // Get all NationalIDs
    @GetMapping
    @PreAuthorize("hasRole('ADMIN')")
    @SecurityRequirement(
            name = "Bear Authentication"
    )
    public ResponseEntity<List<NationalID>> getAllNationalIDs() {
        List<NationalID> nationalIDs = nationalIDService.getAllNationalIDs();
        return ResponseEntity.ok(nationalIDs);
    }


    @PutMapping("/{id}/status")
    @PreAuthorize("hasRole('ADMIN')")
    @SecurityRequirement(
            name = "Bear Authentication"
    )
    public ResponseEntity<Void> updateNationalIdStatus(
            @PathVariable String id,
            @RequestBody UpdateNationalIdDTO updateNationalIdDTO) {

        nationalIDService.updateNationalIdStatus(
                id,updateNationalIdDTO.getIdStatus(), updateNationalIdDTO.getComment());

        return ResponseEntity.noContent().build();

    }


    @GetMapping("/status")
    @PreAuthorize("hasRole('ADMIN')")
    @SecurityRequirement(
            name = "Bear Authentication"
    )
    public ResponseEntity<List<NationalID>> getNationalIDsByStatus(@RequestParam IdStatus status) {
        List<NationalID> nationalIDs = nationalIDService.getNationalIDsByStatus(status);
        return ResponseEntity.ok(nationalIDs);
    }

    @GetMapping("/by-national-id/{nationalId}")
    @SecurityRequirement(
            name = "Bear Authentication"
    )
    public ResponseEntity<NationalID> getNationalIDByNationalId(@PathVariable String nationalId) {
        NationalID nationalID= nationalIDService.getNationalIDByNationalId(nationalId);

            return ResponseEntity.ok(nationalID);
    }
}
