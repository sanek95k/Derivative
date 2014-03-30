package derivatives;

/**
 * Created by Александр on 29.03.14.
 */
public class FunctionNodeOperations {

    public static FunctionNode copyBranch (FunctionNode arg){
        FunctionNode result = arg.clone();
        if (arg.getLeftChild() != null){
            result.setLeftChild(copyBranch(arg.getLeftChild()));
            result.getLeftChild().setParent(result);
        }
        if (arg.getRightChild() != null){
            result.setRightChild(copyBranch(arg.getRightChild()));
            result.getRightChild().setParent(result);
        }
        return result;
    }

    public static FunctionNode Derivative(FunctionNode arg){
        FunctionNode result = copyBranch(arg);
        return result.takeDerivative();
    }
}
