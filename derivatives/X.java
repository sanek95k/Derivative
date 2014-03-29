package derivatives;

/**
 * Created by Александр on 28.03.14.
 */
public class X extends Function {
    public X(){
        super("X");
    }

    public X(Function a, Function b, Function c){
        super("X", a, b, c);
    }

    @Override
    public Function takeDerivative(){
        Function result = new Constant(1, parent, leftChild, rightChild);
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
