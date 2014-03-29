package derivatives;

/**
 * Created by Александр on 28.03.14.
 */
public class Sin extends Function {

    public Sin(){
        super("Sin");
    }

    public Sin(Function a, Function b, Function c){
        super("Sin", a, b, c);
    }

    @Override
    public Function takeDerivative() {
        Function result = new Cos();

        if (parent != null){
            Function temp;
            if (this == parent.leftChild){
                parent.leftChild = new Asterisk(parent, result, this.leftChild);
                temp = parent.leftChild;
            }
            else{
                parent.rightChild = new Asterisk(parent, result, this.leftChild);
                temp = parent.rightChild;
            }
            result.parent = temp;

        }else{
            result.parent = new Asterisk(null, result, null);
        }

        result.leftChild = this.leftChild;
        //if (result.parent.rightChild != null)
            result.parent.rightChild = this.leftChild.takeDerivative();

        return result;
    }
}
