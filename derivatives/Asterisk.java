package derivatives;
/**
 * Created by Александр on 28.03.14.
 */

public class Asterisk extends FunctionNode {
    public Asterisk(){
        super("Asterisk");
    }

    public Asterisk(FunctionNode parent, FunctionNode leftChild, FunctionNode rightChild){
        super("Asterisk", parent, leftChild, rightChild);
    }

    @Override
    public FunctionNode clone(){
        return new Asterisk();
    }

    @Override
    public FunctionNode takeDerivative(){

        FunctionNode result = null;
        result = new Plus(parent, FunctionNodeOperations.copyBranch(this), FunctionNodeOperations.copyBranch(this));
        result.leftChild.parent = result;
        result.rightChild.parent = result;

        result.leftChild.leftChild = result.leftChild.leftChild.takeDerivative();
        result.leftChild.leftChild.parent = result.leftChild;

        result.rightChild.rightChild = result.rightChild.rightChild.takeDerivative();
        result.rightChild.rightChild.parent = result.rightChild;
        return result;
    }
}