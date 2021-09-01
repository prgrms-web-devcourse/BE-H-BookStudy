package com.realSoftware.yongjin.model.repo;

import com.realSoftware.yongjin.model.model.PatientInformation;

import java.util.*;

public class MemoryPatientRepository implements PatientRepository{

    Map<UUID, List<PatientInformation>> patientInformationList = new HashMap<>();

    @Override
    public Optional<List<PatientInformation>> findById(UUID patientId) {
        return Optional.ofNullable(patientInformationList.get(patientId));
    }

    @Override
    public void save(PatientInformation patientInformation) {
        var patientId = patientInformation.getPatientId();

        if(patientInformationList.containsKey(patientId)) {
            patientInformationList.get(patientId).add(patientInformation);
        } else {
            patientInformationList.put(patientId, List.of(patientInformation));
        }
    }
}
