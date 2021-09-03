package model;

import exception.InvalidFileExtensionException;

import java.util.stream.Stream;

public enum DocumentType {
    REPORT("report"),
    POSTAL("postal"),
    IMAGE("png");

    private String fileExtension;

    DocumentType(String fileExtension) {
        this.fileExtension = fileExtension;
    }

    public static DocumentType findByFileExtension(String fileExtension) throws InvalidFileExtensionException {
        return Stream.of(DocumentType.values())
                .filter(curFileExtension -> curFileExtension.equals(fileExtension))
                .findAny()
                .orElseThrow(() -> new InvalidFileExtensionException("Invalid File Extension"));
    }

}
