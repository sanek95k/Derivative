package derivatives;

/**
 * Created by Александр on 28.03.14.
 */
public class Constant extends FunctionNode {

    public Constant(Integer value){
        super(value.toString());
    }

    public Constant(Integer value, FunctionNode parent, FunctionNode leftChild, FunctionNode rightChild){
        super(value.toString(), parent, leftChild, rightChild);
    }

    @Override
    public FunctionNode clone(){
        return new Constant(Integer.valueOf(designation));
    }

    @Override
    public FunctionNode takeDerivative(){
        FunctionNode result = new Constant(0, parent, leftChild, rightChild);
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
