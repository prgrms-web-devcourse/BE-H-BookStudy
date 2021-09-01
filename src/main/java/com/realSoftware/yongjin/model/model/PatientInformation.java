package com.realSoftware.yongjin.model.model;

import java.util.UUID;

public class PatientInformation {

    private final UUID patientId;
    private final String name;
    private String report;
    private String path;
    private String imagePath;

    public PatientInformation(UUID patientId, String name) {
        this.patientId = patientId;
        this.name = name;
    }

    public PatientInformation(UUID patientId, String name, String report) {
        this.patientId = patientId;
        this.name = name;
        this.report = report;
    }

    public PatientInformation(UUID patientId, String name, String report, String path) {
        this.patientId = patientId;
        this.name = name;
        this.report = report;
        this.path = path;
    }

    public PatientInformation(UUID patientId, String name, String report, String path, String imagePath) {
        this.patientId = patientId;
        this.name = name;
        this.report = report;
        this.path = path;
        this.imagePath = imagePath;
    }

    public UUID getPatientId() {
        return patientId;
    }

    public String getName() {
        return name;
    }

    public String getPath() {
        return path;
    }

    public String getReport() {
        return report;
    }

    public String getImagePath() {
        return imagePath;
    }
}
