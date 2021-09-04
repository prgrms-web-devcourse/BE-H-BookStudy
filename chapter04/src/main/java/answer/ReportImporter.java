package answer;

import java.io.File;
import java.io.IOException;

import static answer.Attributes.*;

public class ReportImporter implements Importer{
    private static final String NAME_PREFIX = "Patient: ";

    @Override
    public Document importFile(File file) throws IOException {
        final TextFile textFile = new TextFile(file);
        textFile.addLineSuffix(NAME_PREFIX, PATIENT.getAttribute());
        textFile.addLines(2, line -> false, BODY.getAttribute());

        var attributes = textFile.getAttributes();
        attributes.put(TYPE.getAttribute(), "REPORT");
        return new Document(attributes);
    }
}
