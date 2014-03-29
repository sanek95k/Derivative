import derivatives.*;

import java.util.TreeMap;

/**
 * Created by Александр on 28.03.14.
 */
public class Test {
    public static void main(String[] args){

        Function fun = new Sin();
        fun.setLeftChild(new Plus());
        fun.getLeftChild().setRightChild(new X());
        fun.getLeftChild().setLeftChild(new Constant(2));

       fun = fun.takeDerivative();

        System.out.println(fun.getParent().getRightChild().getRightChild());

    }

}