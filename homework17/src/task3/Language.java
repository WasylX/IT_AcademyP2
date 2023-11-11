package task3;

public enum Language {
    ENGLISH("en"),
    RUSSIAN("ru");

    private final String code;

    Language(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}

