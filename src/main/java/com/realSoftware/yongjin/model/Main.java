package com.realSoftware.yongjin.model;

import com.realSoftware.yongjin.model.model.DocumentManagementSystem;
import com.realSoftware.yongjin.model.model.PatientInformation;
import com.realSoftware.yongjin.model.repo.MemoryPatientRepository;
import com.realSoftware.yongjin.model.repo.PatientRepository;

import java.util.ArrayList;
import java.util.UUID;

public class Main {
    private static String CLASS_PATH = "src/main/resources/";

    public static void main(String[] args) {
        PatientInformation patientInformation = new PatientInformation(
            UUID.randomUUID(), "yongjin", "This is test", CLASS_PATH + "test.txt", CLASS_PATH + "test.png");
        UUID patientId = patientInformation.getPatientId();

        PatientRepository patientRepository = new MemoryPatientRepository();
        patientRepository.save(patientInformation);

        DocumentManagementSystem documentManagementSystem = new DocumentManagementSystem(patientRepository);
        documentManagementSystem.showPatientInformationImage(patientId);
        documentManagementSystem.showPatientInformationTxt(patientId);
    }

}
