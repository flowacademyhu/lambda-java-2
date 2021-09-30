package hu.flowacademy.lambda._02_lambdas;

public class LambdaExpression {

    interface FuncInterface {
        int abstractFun(int x, int y);
    }

    public static void main(String args[]) {
        // by default implements abstractFun()
        FuncInterface add = (x, y) -> {
            return x + y;
        };
        FuncInterface multiply = (x, y) -> x * y;

        System.out.println("2 + 3 = " + add.abstractFun(2,3));
        System.out.println("2 * 3 = " + multiply.abstractFun(2,3));
    }
}
