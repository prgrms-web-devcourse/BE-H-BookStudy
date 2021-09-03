package importer;

import exception.InvalidFileExtensionException;
import model.Document;
import model.DocumentType;
import model.PatientInfo;
import util.FileParser;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.UUID;
import java.util.stream.Stream;

import static model.DocumentType.*;

public class DocumentImporter {
    private final HashMap<UUID, PatientInfo> patientInfoStore = new HashMap<>();
    private final HashMap<UUID, Document> documentStore = new HashMap<>();
    private FileParser fileParser;

    public DocumentImporter(FileParser fileParser) {
        this.fileParser = fileParser;
    }

    public void importDocuments(String directoryPath) {
        try {
            Stream<Path> list = Files.list(Paths.get(directoryPath));
            list.forEach(filePath -> {
                try {
                    LocalDateTime fileDate = fileParser.getFileDate(filePath.toString());
                    String fileName = fileParser.getFileName(filePath.toString());
                    String fileExtension = fileParser.getFileExtension(fileName);
                    Document.DocumentBuilder documentBuilder = new Document.DocumentBuilder(fileName, filePath.toString())
                            .setCreatedAt(fileDate);
                    switch (DocumentType.findByFileExtension(fileExtension)) {
                        case REPORT -> {
                            documentBuilder.setDocumentType(REPORT);
                            documentBuilder.setSurgeryCounsel(Files.readAllLines(filePath).toString());
                        }
                        case IMAGE -> documentBuilder.setDocumentType(IMAGE);
                        case POSTAL -> {
                            documentBuilder.setDocumentType(POSTAL);
                            documentBuilder.setAddress(Files.readAllLines(filePath).toString());
                        }
                    }
                    Document newDocument = documentBuilder.build();
                    documentStore.put(newDocument.getDocumentId(), newDocument);

                } catch (FileNotFoundException | InvalidFileExtensionException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
