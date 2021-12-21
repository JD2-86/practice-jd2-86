package by.it.shcharbunou.jd1.jd1_1.homework.jd1_1_2.calculator.utils;

public enum Operators {

    OPERATORS_REGEX("[-+*/]{1}");

    private final String operators;

    public String getOperators() {
        return operators;
    }

    Operators(String operators) {
        this.operators = operators;
    }
}
