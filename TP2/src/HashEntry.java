public class HashEntry<AnyType> {
    public AnyType element_;
    public boolean isActive_;
    public HashEntry(AnyType element) {
        this(element,true);
    }
    public HashEntry (AnyType element, boolean set) {
        element_ = element;
        isActive_ = set;
    }
}