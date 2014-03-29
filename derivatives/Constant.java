package derivatives;

/**
 * Created by Александр on 28.03.14.
 */
public class Constant extends Function {

    public Constant(Integer value){
        super(value.toString());
    }

    public Constant(Integer value, Function a, Function b, Function c){
        super(value.toString(), a, b, c);
    }

    @Override
    public Function takeDerivative(){
        Function result = new Constant(0, parent, leftChild, rightChild);
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
