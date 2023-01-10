public class AvlTree<T extends Comparable<T>> extends BinarySearchTree<T> {
    private final int ADDER = 1;
    @Override
    protected BinaryNode<T> add(T value, BinaryNode<T> curNode) {
        ctr.insertionCounter++;
        curNode = super.add(value, curNode);
        return balance(curNode);
    }
    @Override
    public void remove(T value) {
        this.root = remove(value, this.root);
    }

    private int height( BinaryNode<T> curNode ) {
        return curNode == null ? -1 : curNode.height;
    }
    private BinaryNode<T> rotateWithLeftChild( BinaryNode<T> k2 ) {
        ctr.insertionCounter++;
        BinaryNode<T> k1 = k2.left;
        k2.left = k1.right;
        k1.right = k2;
        k2.height = Math.max(height(k2.left), height(k2.right)) + ADDER;
        k1.height = Math.max(height(k1.left), k2.height) + ADDER;
        return k1;
    }
    private BinaryNode<T> rotateWithRightChild( BinaryNode<T> k1 ) {
        ctr.insertionCounter++;
        BinaryNode<T> k2 = k1.right;
        k1.right = k2.left;
        k2.left = k1;
        k1.height = Math.max( height( k1.left ), height( k1.right ) ) + ADDER;
        k2.height = Math.max( height( k2.right ), k1.height ) + ADDER;
        return k2;
    }
    private BinaryNode<T> doubleWithRightChild( BinaryNode<T> k1) {
        k1.right = rotateWithLeftChild( k1.right );
        return rotateWithRightChild( k1 );
    }
    private BinaryNode<T> doubleWithLeftChild( BinaryNode<T> k3 ){
        k3.left = rotateWithRightChild( k3.left );
        return rotateWithLeftChild( k3 );
    }
    private BinaryNode<T> balance( BinaryNode<T> curNode ) {
        if( curNode == null )
            return null;
        if( height( curNode.left ) - height( curNode.right ) > 1 ) {
            if( height( curNode.left.left ) >= height( curNode.left.right ) ) {
                curNode = rotateWithLeftChild(curNode);
            }
            else {
                curNode = doubleWithLeftChild( curNode );
            }
        }
        else if( height( curNode.right ) - height( curNode.left ) > 1 ) {
            if( height( curNode.right.right ) >= height( curNode.right.left ) ) {
                curNode = rotateWithRightChild( curNode );
            }
            else {
                curNode = doubleWithRightChild( curNode );
            }
        }
        curNode.height = Math.max( height( curNode.left ), height( curNode.right ) ) + ADDER;
        return curNode;
    }
    protected BinaryNode<T> remove(T value, BinaryNode<T> curNode) {
        if( curNode == null )
            return null;
        int compareResult = value.compareTo( curNode.value );
        if( compareResult < 0 )
            curNode.left = remove( value, curNode.left );
        else if( compareResult > 0 )
            curNode.right = remove( value, curNode.right );
        else if( curNode.left != null && curNode.right != null ) { // Two children
            curNode.value = findMin( curNode.right ).value;
            curNode.right = remove( curNode.value, curNode.right );
        }
        else curNode = ( curNode.left != null ) ? curNode.left : curNode.right;
        return balance( curNode );
    }
}
