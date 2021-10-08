package gfa.inquiry.ArthimeticEvaluator;

import java.util.Stack;

public class Evaluator implements EvaluatorInterface {

    private Stack<Double> numStack;
    private Stack<String> opStack;


    public Evaluator() {
        numStack = new Stack<Double>();
        opStack = new Stack<String>();
    }

    @Override
    public Double calc(String str) {
        for (int i = 0; i < str.length(); i++) {
            String temp = str.substring(i, i+1);

            if (temp.equals(" ")) {
                continue;
            }

            try {
                Double d = Double.parseDouble(temp);
                numStack.push(d);
            } catch (NumberFormatException e) {

                if (opStack.isEmpty()) {
                    opStack.push(temp);
                    continue;
                }

                String peekOp = opStack.peek();
                if (precedence(temp) > 0 && precedence(temp) > precedence(peekOp)) {
                    opStack.push(temp);
                } else if (precedence(temp) > 0 && precedence(temp) < precedence(peekOp)) {
                    // pop off the top of opStack, perform op on top 2 nums in numStack
                    Double dub1 = numStack.pop();
                    Double dub2 = numStack.pop();
                    Double res = opMath(dub1, dub2, peekOp);
                    numStack.push(res);
                } else {
                    opStack.push(temp);
                }
            }
        }
        return numStack.pop();
    }

    private byte precedence(String str) {
        if (str.equals("^"))
            return 3;
        if (str.equals("*") || str.equals("/"))
            return 2;
        if (str.equals("+") || str.equals("-"))
            return 1;
        else
            return -1;
    }

    private Double opMath(Double dub1, Double dub2, String op) {
        switch (precedence(op)) {
            case 1:
                if (op.equals("+")) {
                    return dub1 + dub2;
                } else if (op.equals("-"))
                    return dub1 - dub2;
            case 2:
                if (op.equals("*")) {
                    return dub1 * dub2;
                } else if (op.equals("/")) {
                    return dub1 / dub2;
                }
            case 3:
                Double tempDub = dub2;
                for (int i = 1; i < dub1; i++) {
                    tempDub = tempDub * dub2;
                }
                return tempDub;
        }
        return null;
    }

    // Returns numeric validity of str
    private static boolean isNumeric(String str) {
        return str != null && str.matches("[-+]?\\d*\\.?\\d+");
    }
}
