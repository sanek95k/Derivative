package derivatives;

/**
 * Created by Александр on 28.03.14.
 */
public abstract class FunctionNode implements Cloneable{

    protected String designation;
    protected FunctionNode parent = null;
    protected FunctionNode leftChild = null;
    protected FunctionNode rightChild = null;

    protected FunctionNode(String name){
        designation = new String (name);
    }

    protected FunctionNode(String name, FunctionNode parent, FunctionNode leftChild, FunctionNode rightChild){
        designation = new String (name);
        this.parent = parent;
        this.leftChild = leftChild;
        this.rightChild = rightChild;
    }

    @Override
    abstract public FunctionNode clone();

    final public void setParent(FunctionNode arg){
        parent = arg;
    }

    final public void setLeftChild(FunctionNode arg){
        leftChild = arg;
    }

    final public void setRightChild(FunctionNode arg){
        rightChild = arg;
    }

    final public FunctionNode getParent(){
        return parent;
    }

    final public FunctionNode getLeftChild(){
        return leftChild;
    }

    final public FunctionNode getRightChild(){
        return rightChild;
    }

    @Override
    public String toString() {
        return designation;
    }

    public abstract FunctionNode takeDerivative();
}