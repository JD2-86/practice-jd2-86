package by.it.shcharbunou.calculator.utils;

public enum ApplicationReservedWords {

    Y("Y"),
    N("N");

    private final String applicationReservedWord;

    public String getApplicationReservedWord() {
        return applicationReservedWord;
    }

    ApplicationReservedWords(String applicationReservedWord) {
        this.applicationReservedWord = applicationReservedWord;
    }
}
