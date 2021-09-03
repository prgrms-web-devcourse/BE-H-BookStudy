package model;

import java.time.LocalDateTime;
import java.util.UUID;

public class Document {
    private UUID documentId;
    private UUID patientId;
    private String fileName;
    private String filePath;
    private LocalDateTime createdAt;
    private DocumentType documentType;
    private byte[] image;
    private String address;
    private String surgeryCounsel;

    private Document(DocumentBuilder documentBuilder) {
        this.documentId = UUID.randomUUID();
        this.patientId = documentBuilder.patientId;
        this.fileName = documentBuilder.fileName;
        this.filePath = documentBuilder.filePath;
        this.createdAt = documentBuilder.createdAt;
        this.documentType = documentBuilder.documentType;
        this.image = documentBuilder.image;
        this.address = documentBuilder.address;
        this.surgeryCounsel = documentBuilder.surgeryCounsel;
    }

    public UUID getDocumentId() {
        return documentId;
    }

    public static class DocumentBuilder {
        private String fileName;
        private String filePath;

        private UUID patientId;
        private LocalDateTime createdAt;
        private DocumentType documentType;
        private byte[] image;
        private String address;
        private String surgeryCounsel;

        public DocumentBuilder (String fileName, String filePath) {
            this.fileName = fileName;
            this.filePath = filePath;
        }

        public DocumentBuilder setPatientId(UUID patientId) {
            this.patientId = patientId;
            return this;
        }

        public DocumentBuilder setDocumentType(DocumentType documentType) {
            this.documentType = documentType;
            return this;
        }

        public DocumentBuilder setImage(byte[] image) {
            this.image = image;
            return this;
        }

        public DocumentBuilder setAddress(String address) {
            this.address = address;
            return this;
        }

        public DocumentBuilder setSurgeryCounsel(String surgeryCounsel) {
            this.surgeryCounsel = surgeryCounsel;
            return this;
        }

        public DocumentBuilder setCreatedAt(LocalDateTime createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        public Document build() {
            return new Document(this);
        }
    }
}
