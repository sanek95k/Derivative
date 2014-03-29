package derivatives;

/**
 * Created by Александр on 28.03.14.
 */
public class Cos extends Function {

    public Cos(){
        super("Cos");
    }

    public Cos(Function a, Function b, Function c){
        super("Cos", a, b, c);
    }

    @Override
    public Function takeDerivative(){
        return new Sin(parent, leftChild, rightChild);
    }
}