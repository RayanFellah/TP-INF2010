public interface Hash<AnyType> {
    public void insert(AnyType el);
    public void remove(AnyType el);

    public boolean contains(AnyType el);
    public void clear();

    public HashEntry<AnyType>[] getArray();
    public int getNumberOfConflicts();
}

