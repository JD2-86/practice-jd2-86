package calculator.utils;

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
