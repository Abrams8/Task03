package by.htp.etc.task3;

public enum Operator {
    ADDITION('+', 1),
    SUBTRACTION('-', 1),
    MULTIPLICATION('*', 2),
    DIVISION('/', 2),
    L_BRACKET('(', 3),
    R_BRACKET(')', 3);

    private final char operator;
    private final int priority;

    Operator(char operator, int priority){
        this.operator = operator;
        this.priority = priority;
    }

    public char getOperator() {
        return operator;
    }

    public int getPriority() {
        return priority;
    }
}
