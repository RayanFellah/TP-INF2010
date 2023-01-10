public class HashTable<AnyType> implements Hash<AnyType>{
    private static final int defaultCapacaity = 11;
    private int Size = 0;
    protected HashEntry<AnyType>[] array;
    int numberOfConflicts = 0;


    public HashTable(int size) {
        allocateArray(size);
        clear();
    }
    public HashTable() {

        this(defaultCapacaity);
    }

    public void allocateArray(int size) {

        array =  new HashEntry[ Prime.nextPrime(size)];
    }

    public void insert(AnyType el) {
        int position = findPos(el);

        if(isActive(position))
            return;
        array[position] = new HashEntry<AnyType>(el, true);

        if(++Size > array.length / 2)
            rehash();
    }

    private void rehash() {
        HashEntry<AnyType>[] ref = array;

        allocateArray(Prime.nextPrime(2 * ref.length));
        Size = 0;

        for(int i =  0 ; i < ref.length; i++)
            if(ref[i] != null && ref[i].isActive_)
                insert(ref[i].element_);
    }

    protected int findPos(AnyType el) {
        return -1;
    }

    public void remove(AnyType el) {
        int position = findPos(el);
        if (isActive(position))
            array[position].isActive_ = false;
    }

    public boolean contains(AnyType el) {
        int position = findPos(el);
        return isActive(position);
    }
    private boolean isActive(int pos) {

        return array[pos] != null && array[pos].isActive_;
    }

    public void clear() {
        Size = 0;
        for(int i = 0 ; i < array.length; i++)
            array[i] = null;

    }

    protected final int hash(AnyType el) {
        int hashed = el.hashCode();

        hashed %= array.length;

        if(hashed < 0)
            hashed += array.length;
        return hashed;
    }
    public HashEntry<AnyType>[] getArray(){
        return array;
    }

    @Override
    public int getNumberOfConflicts() {
        return numberOfConflicts;
    }

    public int getSize(){
        return Size;
    }

}
