public class Counter {
    //TODO
    public Counter() {
        insertionCounter = 0;
        searchCounter = 0;
    }
    public int insertionCounter;
    public int searchCounter;
    public void resetInsertionCounter() {
        insertionCounter = 0;
    }
    public void resetSearchCounter(){
        searchCounter = 0;
    }
    public void reset() {
        resetInsertionCounter();
        resetSearchCounter();
    }
}
