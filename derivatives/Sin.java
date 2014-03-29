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
        FunctionNode result = new Cos();

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
            result.parent = temp;

        }
        else{
            result.parent = new Asterisk(null, result, null);
        }

        result.leftChild = this.leftChild;
        result.parent.rightChild = this.leftChild.takeDerivative();

        return result;
    }
}
