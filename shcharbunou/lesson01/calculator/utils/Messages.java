package calculator.utils;

public enum Messages {
    INPUT_OPERAND_ERROR_MESSAGE("Error: Value is not double type."),
    INPUT_OPERATOR_ERROR_MESSAGE("Error: Value is not operator."),
    INPUT_CLIENT_ANSWER_ERROR_MESSAGE("Error: Unknown command"),
    UNKNOWN_ERROR_MESSAGE("UNKNOWN ERROR!"),
    START_MESSAGE("Calculator started!"),
    INPUT_OPERAND_MESSAGE("Input operand number "),
    INPUT_OPERATOR_MESSAGE("Input operator:"),
    EXIT_MESSAGE("Would you like to exit? (Y/N)");

    private final String message;

    public String getMessage() {
        return message;
    }

    Messages(String message) {
        this.message = message;
    }
}
