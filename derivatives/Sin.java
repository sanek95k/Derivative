package derivatives;

/**
 * Created by Александр on 28.03.14.
 */
public class Sin extends FunctionNode {

    public Sin(){
        super("Sin");
    }

    public Sin(FunctionNode parent, FunctionNode leftChild, FunctionNode rightChild){
        super("Sin", parent, leftChild, rightChild);
    }

    @Override
    public FunctionNode clone(){
        return new Sin();
    }

    @Override
    public FunctionNode takeDerivative() {
        FunctionNode result = null;
        result = new Asterisk(parent, new Cos(null, leftChild, null), FunctionNodeOperations.copyBranch(leftChild).takeDerivative());
        result.leftChild.parent = result;
        result.rightChild.parent = result;

        result.leftChild.leftChild.parent = result.leftChild;

        return result;
    }
}