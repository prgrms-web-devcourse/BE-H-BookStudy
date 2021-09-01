import java.util.Arrays;

public enum FileType {
    TEXT("text"),
    IMAGE("image"),
    STRING("string");

    private final String type;

    FileType(String type){
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public static FileType find(String type){
        return Arrays.stream(values())
                .filter(fileType -> fileType.type.equals(type))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("적절하지 않은 값이 들어왔다."));
    }
}
