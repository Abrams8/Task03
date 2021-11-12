package by.htp.etc.task3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        String str = "25+17-2*(8+7*2)";
        int result;
        Calculator calculator = new Calculate();
        result = calculator.calculateFromStr(str);
        System.out.println(result);
    }
}