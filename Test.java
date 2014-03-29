import derivatives.*;

/**
 * Created by Александр on 28.03.14.
 */
public class Test {
    public static void main(String[] args){

        FunctionNode fun = null;

        // Sin(X * 4) * X
        fun = new Asterisk(null, new Sin(fun, null, null), new X(fun, null, null));
        fun.getLeftChild().setLeftChild(new Asterisk(fun.getLeftChild(), null, null));
        fun.getLeftChild().getLeftChild().setLeftChild(new X(fun.getLeftChild().getLeftChild(), null, null));
        fun.getLeftChild().getLeftChild().setRightChild(new Constant(4, fun.getLeftChild().getLeftChild(), null, null));

        FunctionNode gun = FunctionNodeOperations.Derivative(fun);

        // Cos(X * 2) * (1 * 4 + X * 0) * X + Sin(X * 2) * 1
        System.out.println(gun);

        // Cos is still being tested
    }

}