public class Part2 {
    public static String horizontalLine = "--------------------------------------";
    public static String sectionSeparationLine = "======================================================================";
    public static void addValues(BinarySearchTree<Integer> bst, AvlTree<Integer> avl, String filename, int size) {
        for(Integer value : ArrayFiller.getArray(filename,size)) {
            bst.add(value);
            avl.add(value);
        }
    }
    public static void searchValue(BinarySearchTree<Integer> bst, AvlTree<Integer>  avl, int value) {
        bst.contains(value);
        avl.contains(value);
    }
    public static void DisplayStats(BinarySearchTree<Integer> bst,AvlTree<Integer> avl, int size) {
        System.out.println("RESULTS FOR THE ARRAY OF " + size + " VALUES");
        System.out.println("Number of insertion operations for BST: " + bst.getCounter().insertionCounter);
        System.out.println("Number of insertions operations for AVL: " + avl.getCounter().insertionCounter);
        System.out.println(horizontalLine);
        System.out.println("Number of search operations for BST: " + bst.getCounter().searchCounter);
        System.out.println("Number of search operations for AVL: " + avl.getCounter().searchCounter);
        System.out.println(sectionSeparationLine);
    }

    public static void clearTrees(BinarySearchTree<Integer> bst,AvlTree<Integer> avl) {
        bst.getCounter().reset();
        avl.getCounter().reset();
        bst.deleteTree();
        avl.deleteTree();
    }

    public static void main(String[] args) {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        AvlTree<Integer> avl = new AvlTree<>();

        addValues(bst,avl, "array1.csv",10);
        searchValue(bst, avl,25);                             //Valeur de recherche déterminée aléatoirement
        DisplayStats(bst,avl,10);
        clearTrees(bst,avl);

        addValues(bst,avl, "array2.csv",100);
        searchValue(bst, avl,112);                            //Valeur de recherche déterminée aléatoirement
        DisplayStats(bst,avl,100);
        clearTrees(bst,avl);


        addValues(bst,avl, "array3.csv",1000);
        searchValue(bst, avl,1001);                          //Valeur de recherche déterminée aléatoirement
        DisplayStats(bst,avl,1000);
        clearTrees(bst,avl);
    }
}

