package com.realSoftware.yongjin.model.model;

import com.realSoftware.yongjin.model.importer.ImageImporter;
import com.realSoftware.yongjin.model.importer.Importer;
import com.realSoftware.yongjin.model.importer.TxtImporter;
import com.realSoftware.yongjin.model.repo.PatientRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class DocumentManagementSystem {

    private final PatientRepository patientRepository;

    public DocumentManagementSystem(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    public Optional<List<PatientInformation>> findById(UUID patientId){
        return patientRepository.findById(patientId);
    }

    public void save(PatientInformation patientInformation){
        patientRepository.save(patientInformation);
    }

    public String showPatientInformationImage(UUID patientId) {
        ImageImporter imageImporter = new ImageImporter();
        PatientInformation patientInformation = patientRepository.findById(patientId).get().get(0);
        return imageImporter.importResource(patientInformation.getImagePath());
    }

    public String showPatientInformationTxt(UUID patientId) {
        TxtImporter txtImporter = new TxtImporter();
        PatientInformation patientInformation = patientRepository.findById(patientId).get().get(0);
        return txtImporter.importResource(patientInformation.getPath());
    }
}
