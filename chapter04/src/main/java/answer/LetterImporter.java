package answer;

import java.io.File;
import java.io.IOException;

import static answer.Attributes.*;

public class LetterImporter implements Importer{
    private static final String NAME_PREFIX = "Dear ";

    @Override
    public Document importFile(File file) throws IOException {
        final TextFile textFile = new TextFile(file);

        textFile.addLineSuffix(NAME_PREFIX, PATIENT.getAttribute());

        //predicate 조건: 공백
        final int lineNumber = textFile.addLines(2, String::isEmpty, ADDRESS.getAttribute());
        textFile.addLines(lineNumber + 1, (line) -> line.startsWith("regards,"), BODY.getAttribute());

        var attributes = textFile.getAttributes();
        attributes.put(TYPE.getAttribute(), "LETTER");

        return new Document(attributes);
    }
}
