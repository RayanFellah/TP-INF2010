import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Collectors;

public class Stats<AnyType> {

    private final ArrayList<Double> clusters;
    private final Hash<AnyType> hashTableToAnalyse;
    private final int sizeOfTable;
    private final HashEntry<AnyType>[] array;

    public Stats(Hash<AnyType> HashTable){

        clusters = new ArrayList<>();
        hashTableToAnalyse = HashTable;
        array = hashTableToAnalyse.getArray();
        sizeOfTable = hashTableToAnalyse.getArray().length;
    }
    private void countClusters(){
        Double ctr = 0.0;
        for(int i = 0; i < sizeOfTable; i++){
            while(array[i] != null && array[i++].isActive_ && i < sizeOfTable) ctr++;

            if(ctr > 1) {
                clusters.add(ctr);
                ctr = 0.0;
            }
        }
    }

    public Double getAverageClusterSize(){
        countClusters();
        return clusters.stream().mapToDouble(el -> el).sum() / clusters.size();
    }

    public Double getMaxClusterSize(){
        return Collections.max(clusters);
    }

    public Double getMinClusterSize(){
        return  Collections.min(clusters);
    }

}
