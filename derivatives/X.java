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
        FunctionNode result = new Constant(1, parent, leftChild, rightChild);
        if (parent != null){
            if (this == parent.leftChild){
                parent.leftChild = result;
            }
            else{
                parent.rightChild = result;
            }
        }
        return result;
    }
}