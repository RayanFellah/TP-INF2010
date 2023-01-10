public class LinearHashTable<AnyType> extends HashTable<AnyType> {

    LinearHashTable(){
        super();
    }

    LinearHashTable(int size){
        super(size);
    }

    protected final int findPos(AnyType el) {
        int currentPos = hash(el);
        while(array[currentPos] != null &&
                !array[currentPos].element_.equals(el)) {
            numberOfConflicts++;
            currentPos++;
            if(currentPos >= array.length) {
                currentPos -= array.length;
            }
        }
        return currentPos;
    }
}