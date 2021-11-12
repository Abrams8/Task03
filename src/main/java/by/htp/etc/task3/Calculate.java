package by.htp.etc.task3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Calculate implements Calculator {


    public int calculateFromStr(String str) {

        Stack<Integer> stackNumber = new Stack();
        Stack<String> stackOperation = new Stack();

        String[] character = str.strip().split("\\.*");

        List<String> list = new ArrayList<>(Arrays.asList(character));

        for (int i = 0; i < list.size(); i++) {
            while (isNumber(list.get(i)) && isNumber(list.get(i + 1))) {
                list.set(i, list.get(i) + list.get(i + 1));
                list.remove(i + 1);
            }
        }

        for (int i = 0; i < list.size(); i++) {
            if (isNumber(list.get(i))) {
                stackNumber.push(Integer.parseInt(list.get(i)));
            } else {
                if (stackOperation.isEmpty()) {
                    stackOperation.push(list.get(i));
                } else if (list.get(i).equals(")")) {

                    String currentOperator = "";
                    while (!currentOperator.equals("(")) {
                        currentOperator = stackOperation.pop();
                        int numOne = stackNumber.pop();
                        int numTwo = stackNumber.pop();
                        stackNumber.push(calc(numTwo, numOne, currentOperator));
                    }

                } else if (!list.get(i).equals(")")) {
                    int priorityLastOperator = priority(stackOperation.peek());
                    int priorityCurrentOperator = priority(list.get(i));
                    if (priorityCurrentOperator >= priorityLastOperator) {
                        stackOperation.push(list.get(i));
                    } else {
                        int numOne = stackNumber.pop();
                        int numTwo = stackNumber.pop();
                        stackNumber.push(calc(numTwo, numOne, list.get(i)));
                    }
                }
            }
        }
        return stackNumber.pop();
    }


    public static boolean isNumber(String string) {
        try {
            Integer.parseInt(string);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private static int priority(String operator) {
        if (operator.equals("(")) return 1;
        if (operator.equals("+") || operator.equals("-")) return 2;
        if (operator.equals("*") || operator.equals("/")) return 3;
        return 4;
    }

    private static int calc(int numOne, int numTwo, String operator) {
        int result = 0;
        switch (operator) {
            case "+":
                result = numOne + numTwo;
            case "-":
                result = numOne - numTwo;
            case "*":
                result = numOne * numTwo;
            case "/":
                result = numOne / numTwo;
        }
        return result;
    }
}
