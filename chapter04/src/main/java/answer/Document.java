package answer;

import java.util.Map;

//Document 는 속성을 관리한다.
public class Document {
    private final Map<String, String> attributes;

    public Document(Map<String, String> attributes) {
        this.attributes = attributes;
    }

    public String getAttributes(final String attributeName) {
        return attributes.get(attributeName);
    }
}
