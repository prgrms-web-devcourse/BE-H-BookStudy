package answer;

//책에서는 static final~~~ 이렇게 썼는데 enum 으로 함; (어떤걸 선택하는게 맞는거지 일단 수업에 맞는걸로 ;;)
public enum Attributes {
    PATH("path"),
    PATIENT("patient"),
    ADDRESS("address"),
    BODY("body"),
    WIDTH("width"),
    HEIGHT("height"),
    TYPE("type"),
    AMOUNT("amount");

    final private String attribute;

    Attributes(String attribute) {
        this.attribute =  attribute;
    }

    public String getAttribute() {
        return attribute;
    }
}
