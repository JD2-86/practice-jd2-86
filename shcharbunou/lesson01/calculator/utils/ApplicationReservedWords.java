package by.it.shcharbunou.jd1.jd1_1.homework.jd1_1_2.calculator.utils;

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
