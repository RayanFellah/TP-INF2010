public class DoubleHashedHashTable<AnyType>
        extends HashTable<AnyType>{
    public DoubleHashedHashTable(){
        super();
    }
    public DoubleHashedHashTable(int size){
        super(size);
    }



    private int secondHash(AnyType x ){
        return Prime.findMaxPrimeBefore(array.length) - (x.hashCode() %
                Prime.findMaxPrimeBefore(array.length));
    }


    @Override
    protected final int findPos(AnyType el) {

        int position = hash(el);
        int offset = 1;


        while(array[position] != null && !array[position].element_.equals(el) )
        {
            numberOfConflicts++;
            position += offset++ * secondHash(el) % array.length;
            if(position >= array.length)
                position -= array.length;
        }
        return position;
    }
}
