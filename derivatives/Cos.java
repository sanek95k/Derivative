package derivatives;

/**
 * Created by Александр on 28.03.14.
 */
public class Cos extends FunctionNode {

    public Cos() {
        super("Cos");
    }

    public Cos(FunctionNode parent, FunctionNode leftChild, FunctionNode rightChild) {
        super("Cos", parent, leftChild, rightChild);
    }

    @Override
    public FunctionNode clone() {
        return new Cos();
    }

    @Override
    public FunctionNode takeDerivative() {
        FunctionNode result = null;
        result = new Asterisk(parent,
                new Asterisk(null, new Sin(null, leftChild, null), FunctionNodeOperations.copyBranch(leftChild).takeDerivative()),
                new Constant(-1.0));
        result.leftChild.parent = result;
        result.rightChild.parent = result;

        result.leftChild.leftChild.parent = result.leftChild;
        result.leftChild.rightChild.parent = result.leftChild;

        result.leftChild.leftChild.leftChild.parent = result.leftChild.leftChild;

        return result;
    }
}