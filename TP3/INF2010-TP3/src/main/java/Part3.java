public class Part3 {
    public static void addValues(BinarySearchTree<Integer> bst, AvlTree<Integer> avl,int size) {
        for(int i = 1; i < size + 1; i++) {
            bst.add(i);
            avl.add(i);
        }
    }
    public static void main(String[] args) {
        BinarySearchTree<Integer> BST = new BinarySearchTree<>();
        AvlTree<Integer> AVL = new AvlTree<>();

        addValues(BST,AVL,10);
        Part2.searchValue(BST,AVL,5);                //Valeur de recherche déterminée aléatoirement
        Part2.DisplayStats(BST,AVL,10);
        Part2.clearTrees(BST,AVL);

        addValues(BST,AVL,100);
        Part2.searchValue(BST,AVL,50);              //Valeur de recherche déterminée aléatoirement
        Part2.DisplayStats(BST,AVL,100);
        Part2.clearTrees(BST,AVL);

        addValues(BST,AVL,1000);
        Part2.searchValue(BST,AVL,500);            //Valeur de recherche déterminée aléatoirement
        Part2.DisplayStats(BST,AVL,1000);
        Part2.clearTrees(BST,AVL);
    }
}
