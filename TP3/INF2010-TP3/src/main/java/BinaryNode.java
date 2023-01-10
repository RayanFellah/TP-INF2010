public class BinaryNode<T> {

    public BinaryNode<T> left = null;
    public BinaryNode<T> right = null;
    public int height = 0;

    public T value;

    public BinaryNode(T value) {
        this.value = value;
    }
    public BinaryNode(T value, int height) {
        this(value);
        this.height = height;
    }
    public Integer getValue(){
        return (Integer) this.value;
    }

    public BinaryNode<T> getNode(){
        return this;
    }
}
