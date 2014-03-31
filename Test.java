import derivatives.*;

/**
 * Created by Александр on 28.03.14.
 */
public class Test {
    public static void main(String[] args){

        // Expression: Sin(X * 4.0) * X
        FunctionNode fun = null;
        fun = new Asterisk(null, new Sin(), new X());
        fun.getLeftChild().setParent(fun);
        fun.getRightChild().setParent(fun);
        fun.getLeftChild().setLeftChild(new Asterisk(fun.getLeftChild(), null, null));
        fun.getLeftChild().getLeftChild().setLeftChild(new X(fun.getLeftChild().getLeftChild(), null, null));
        fun.getLeftChild().getLeftChild().setRightChild(new Constant(4.0, fun.getLeftChild().getLeftChild(), null, null));

        FunctionNode gun = FunctionNodeOperations.Derivative(fun);

        // Result: Cos(X * 4.0) * (1.0 * 4.0 + X * 0.0) * X + Sin(X * 4.0) * 1.0
        System.out.println(gun.getLeftChild().getRightChild());


        // Expression: Cos (X + 5) + X
        FunctionNode hun = null;
        hun = new Plus(null, new Cos(), new X());
        hun.getLeftChild().setParent(hun);
        hun.getRightChild().setParent(hun);
        hun.getLeftChild().setLeftChild(new Plus(hun.getLeftChild(), null, null));
        hun.getLeftChild().getLeftChild().setLeftChild(new X(hun.getLeftChild().getLeftChild(), null, null));
        hun.getLeftChild().getLeftChild().setRightChild(new Constant(5.0, hun.getLeftChild().getLeftChild(), null, null));

        hun = FunctionNodeOperations.Derivative(hun);

        // Result: Sin (X + 5.0) * (1.0 + 0.0) * (-1.0) + 1.0
        System.out.println(hun.getLeftChild().getLeftChild().getRightChild().getRightChild());


        // Expression: 4 + X ^ 5
        FunctionNode jun = null;
        jun = new Plus(null, new Constant(4.0), new Power(5.0, null, new X(), null));
        jun.getLeftChild().setParent(jun);
        jun.getRightChild().setParent(jun);
        jun.getRightChild().getLeftChild().setParent(jun.getRightChild());

        jun = FunctionNodeOperations.Derivative(jun);

        // Result: 0 + 5 * X ^ 4
        System.out.println(jun.getRightChild().getLeftChild().getLeftChild());


        // Expression: Ln(X)
        FunctionNode kun = null;
        kun = new Ln(null, new X(), null);
        kun.getLeftChild().setParent(kun);

        kun = FunctionNodeOperations.Derivative(kun);

        // Result: X ^ (-1) * 1
        System.out.println(kun.getLeftChild());

    }
}