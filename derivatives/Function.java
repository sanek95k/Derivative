package derivatives;

/**
 * Created by Александр on 28.03.14.
 */
public abstract class Function{

    protected String designation;
    protected Function parent = null;
    protected Function leftChild = null;
    protected Function rightChild = null;

    protected Function(String name){
        designation = new String (name);
    }

    protected Function(String name, Function a, Function b, Function c){
        designation = new String (name);
        parent = a;
        leftChild = b;
        rightChild = c;
    }

    final public void setParent(Function arg){
        parent = arg;
    }

    final public void setLeftChild(Function arg){
        leftChild = arg;
    }

    final public void setRightChild(Function arg){
        rightChild = arg;
    }

    final public Function getParent(){
        return parent;
    }

    final public Function getLeftChild(){
        return leftChild;
    }

    final public Function getRightChild(){
        return rightChild;
    }

    @Override
    final public String toString() {
        return designation;
    }

    public abstract Function takeDerivative();
}
