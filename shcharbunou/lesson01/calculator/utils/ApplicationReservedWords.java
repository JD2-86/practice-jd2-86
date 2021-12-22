package calculator.utils;

public enum ApplicationReservedWords {
    Y("y"),
    N("n");

    private final String applicationReservedWord;

    public String getApplicationReservedWord() {
        return applicationReservedWord;
    }

    ApplicationReservedWords(String applicationReservedWord) {
        this.applicationReservedWord = applicationReservedWord;
    }
}
