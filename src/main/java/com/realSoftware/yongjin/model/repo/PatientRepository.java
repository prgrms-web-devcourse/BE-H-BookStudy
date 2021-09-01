package com.realSoftware.yongjin.model.repo;

import com.realSoftware.yongjin.model.model.PatientInformation;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PatientRepository {
    Optional<List<PatientInformation>> findById(UUID patientId);
    void save(PatientInformation patientInformation);
}
