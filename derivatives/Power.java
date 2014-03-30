package derivatives;

/**
 * Created by Александр on 28.03.14.
 */
public class Power extends FunctionNode {
    public Power(Double value){
        super(value.toString());
    }

    public Power(Double value, FunctionNode parent, FunctionNode leftChild, FunctionNode rightChild){
        super(value.toString(), parent, leftChild, rightChild);
    }

    @Override
    final public String toString() {
        return "Power(" + designation + ")";
    }

    @Override
    public FunctionNode clone(){
        return new Power(Double.valueOf(designation));
    }

    @Override
    public FunctionNode takeDerivative(){
        FunctionNode result = new Asterisk(parent,
                new Power(Double.valueOf(designation) - 1.0, null, leftChild, null),
                new Constant(Double.valueOf(designation)));

        result.leftChild.parent = result;
        result.rightChild.parent = result;

        return result;
    }
}