package derivatives;

/**
 * Created by Александр on 28.03.14.
 */
public class Asterisk extends Function {
    public Asterisk(){
        super("Asterisk");
    }

    public Asterisk(Function a, Function b, Function c){
        super("Asterisk", a, b, c);
    }

    @Override
    public Function takeDerivative(){
        return new Asterisk(parent, leftChild, rightChild);
    }
}
