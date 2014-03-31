package derivatives;

/**
 * Created by Александр on 31.03.14.
 */
public class Ln extends FunctionNode {
    public Ln(){
        super("Ln");
    }

    public Ln(FunctionNode parent, FunctionNode leftChild, FunctionNode rightChild){
        super("Ln", parent, leftChild, rightChild);
    }

    @Override
    public FunctionNode clone(){
        return new Ln();
    }

    @Override
    public FunctionNode takeDerivative(){
        FunctionNode result = null;
        result = new Asterisk(parent, new Power(-1.0, null, leftChild, null), FunctionNodeOperations.copyBranch(leftChild).takeDerivative());
        result.leftChild.parent = result;
        result.rightChild.parent = result;

        result.leftChild.leftChild.parent = result.leftChild;

        return result;
    }
}
