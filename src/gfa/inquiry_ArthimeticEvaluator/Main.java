package gfa.inquiry_ArthimeticEvaluator;

public class Main {
    public static void main(String[] args) {
        Evaluator e = new Evaluator();
        // This condition returns 4, meaning first op math works.
        System.out.println(e.calc("2 ^ 2 + 2"));
    }
}
