package derivatives;

/**
 * Created by Александр on 28.03.14.
 */
public class Plus extends FunctionNode{

    public Plus(){
        super("Plus");
    }

    public Plus(FunctionNode a, FunctionNode b, FunctionNode c){
        super("Plus", a, b, c);
    }

    @Override
    public FunctionNode clone(){
       return new Plus();
    }

    @Override
    public FunctionNode takeDerivative(){

        FunctionNode left = null, right = null;
        if (leftChild != null)
            left = leftChild.takeDerivative();
        if (rightChild != null)
            right = rightChild.takeDerivative();

        return new Plus(parent, left, right);
    }

}