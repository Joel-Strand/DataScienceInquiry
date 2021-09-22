package gfa.inquiry_ArthimeticEvaluator;

import java.util.Stack;

public class Evaluator {

    private Stack<Double> numStack; // Parse Numbers
    private Stack<String> opStack; // Parse Operator Presence Later

    public Evaluator() {
        numStack = new Stack<Double>();
        opStack = new Stack<String>();
    }

    public double calculate(String expression) {
        return -1.0d;
    }

    private byte precedence(String str) {
        if (str.equals("(") || str.equals(")"))
            return 4;
        if (str.equals("^"))
            return 3;
        if (str.equals("*") || str.equals("/"))
            return 2;
        if (str.equals("+") || str.equals("-"))
            return 1;
        else
            return -1;
    }
}
