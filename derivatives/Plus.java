package derivatives;

/**
 * Created by Александр on 28.03.14.
 */
public class Plus extends Function{

    public Plus(){
        super("Plus");
    }

    public Plus(Function a, Function b, Function c){
        super("Plus", a, b, c);
    }

    @Override
    public Function takeDerivative(){

        Function left, right;

            left = leftChild.takeDerivative();

            right = rightChild.takeDerivative();

        return new Plus(parent, left, right);
    }

}
