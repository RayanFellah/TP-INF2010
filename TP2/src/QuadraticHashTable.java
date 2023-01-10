public class QuadraticHashTable<AnyType>
        extends HashTable<AnyType> {
    public QuadraticHashTable(int size){
        super(size);
    }
    public QuadraticHashTable()
    {
        super();
    }

    @Override
    protected final int findPos(AnyType el) {
        int adder = 1;
        int position = hash(el);

        while(array[position] != null && !array[position].equals(el)){
            numberOfConflicts++;
            position += adder;
            adder += 2;
            if(position >= array.length)
                position -= array.length;
        }
        return position;
    }
}
