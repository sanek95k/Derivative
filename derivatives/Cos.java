package derivatives;

/**
 * Created by Александр on 28.03.14.
 */
public class Cos extends FunctionNode {

    public Cos(){
        super("Cos");
    }

    public Cos(FunctionNode parent, FunctionNode leftChild, FunctionNode rightChild){
        super("Cos", parent, leftChild, rightChild);
    }

    @Override
    public FunctionNode clone(){
        return new Cos();
    }

    @Override
    public FunctionNode takeDerivative(){
        FunctionNode result = new Sin();

        if (parent != null){
            FunctionNode temp;
            if (this == parent.leftChild){
                parent.leftChild = new Asterisk(parent, result, this.leftChild);
                temp = parent.leftChild;
            }
            else{
                parent.rightChild = new Asterisk(parent, result, this.leftChild);
                temp = parent.rightChild;
            }
            result.parent = temp.leftChild;

        }
        else{
            result.parent = new Asterisk(null, result, new Constant(-1, result.parent, null, null));
            result.parent.parent = new Asterisk(null, result.parent, null);

        }

        result.leftChild = this.leftChild;
        result.parent.parent.rightChild = this.leftChild.takeDerivative();

        return result;
    }
}