package derivatives;

/**
 * Created by Александр on 28.03.14.
 */
public class Constant extends FunctionNode {

    public Constant(Double value){
        super(value.toString());
    }

    public Constant(Double value, FunctionNode parent, FunctionNode leftChild, FunctionNode rightChild){
        super(value.toString(), parent, leftChild, rightChild);
    }

    @Override
    public FunctionNode clone(){
        return new Constant(Double.valueOf(designation));
    }

    @Override
    public FunctionNode takeDerivative(){
        return new Constant(0.0, parent, leftChild, rightChild);
    }
}
