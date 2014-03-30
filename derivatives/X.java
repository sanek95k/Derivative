package derivatives;

/**
 * Created by Александр on 28.03.14.
 */
public class X extends FunctionNode {
    public X(){
        super("X");
    }

    public X(FunctionNode parent, FunctionNode leftChild, FunctionNode rightChild){
        super("X", parent, leftChild, rightChild);
    }

    @Override
    public FunctionNode clone(){
        return new X();
    }

    @Override
    public FunctionNode takeDerivative(){
        return new Constant(1.0, parent, leftChild, rightChild);
    }
}