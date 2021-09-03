package util;

import exception.InvalidFileExtensionException;

import java.io.FileNotFoundException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class FileParser {

    public String getFileName(String filePath) throws FileNotFoundException {
        int fileNameStartIndex = filePath.lastIndexOf('_');

        if (fileNameStartIndex > 0) {
            return filePath.substring(fileNameStartIndex + 1);
        }

        throw new FileNotFoundException("File Not Found");
    }

    public String getFileExtension(String filePath) throws InvalidFileExtensionException {
        int fileSeparationDotIndex = filePath.lastIndexOf('.');

        if (fileSeparationDotIndex > 0) {
            return filePath.substring(fileSeparationDotIndex + 1);
        }

        throw new InvalidFileExtensionException("Invalid File Extension");
    }

    public LocalDateTime getFileDate(String filePath) throws FileNotFoundException {
        int fileDateIndex = filePath.lastIndexOf('/');
        int fileNameStartIndex = filePath.lastIndexOf('_');

        if (fileNameStartIndex > 0 && fileDateIndex > 0 && fileDateIndex > fileNameStartIndex) {
            return LocalDateTime.parse(filePath.substring(fileDateIndex + 1, fileNameStartIndex + 1),
                    DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        }

        throw new FileNotFoundException("File Not Found");
    }
}
