import javax.sound.sampled.Line;
import java.util.Map;

/**
 * Partie 2 : Questions
 */
public class Main {

    public static String first = "first array";
    public static String second = "second array";
    public static String third = "third array";
    public static String horizontalLine = "----------------------------------------";
    /**
     * This void method is used to display the statistics about the clusters
     * within the different instances of HashTables
     * @param table is the HashTable to analyse
     * @param map has a string as key and an array to input in the table as value
     * @param arrayName is the name of the array to input, it is used to find it
     * within the HashMap parameter
     */
    public static void DisplayStats(Hash<Double> table, Map<String, Double[]> map, String arrayName)
    {
        for(var el : map.get(arrayName))
            table.insert(el);
        Stats<Double> S = new Stats<Double>(table);
        var value1 = S.getAverageClusterSize();
        var value2 = S.getMaxClusterSize();
        var value3 = S.getMinClusterSize();
        System.out.println("RESULTS FOR THE : " + arrayName + " of size " + map.get(arrayName).length);
        System.out.println("Average cluster size: " + value1);
        System.out.println("The max cluster size: " + value2);
        System.out.println("The min cluster size: " + value3);
        System.out.println(horizontalLine);

        table.clear();
    }

    public static void main(String[] args) {


        // Instance des hash tables
        Hash<Double> Linear = new LinearHashTable<>();
        Hash<Double> Quadratic = new QuadraticHashTable<>();
        Hash<Double> DoubleHash = new DoubleHashedHashTable<>();

        MyArrays data = new MyArrays();

        System.out.println("Linear table analysis : ");
        DisplayStats(Linear, MyArrays.map, first);
        DisplayStats(Linear, MyArrays.map, second);
        DisplayStats(Linear, MyArrays.map, third);
        System.out.println("Number of conflicts: " + Linear.getNumberOfConflicts());

        System.out.println("========================================");

        System.out.println("Quadratic table analysis : ");

        DisplayStats(Quadratic, MyArrays.map, first);
        DisplayStats(Quadratic, MyArrays.map, second);
        DisplayStats(Quadratic, MyArrays.map, third);
        System.out.println("Number of conflicts: " + Quadratic.getNumberOfConflicts());

        System.out.println("========================================");

        System.out.println("Double hash table analysis : ");

        DisplayStats(DoubleHash, MyArrays.map, first);
        DisplayStats(DoubleHash, MyArrays.map, second);
        DisplayStats(DoubleHash, MyArrays.map, third);
        System.out.println("Number of conflicts: " + DoubleHash.getNumberOfConflicts());

        System.out.println("========================================");


        long startTime = System.nanoTime();
        System.out.println(startTime);
        int a = 0;
        for(int  i =0; i < 10; i++) {
            a++;
        }
        long esti = System.nanoTime() - startTime;
        System.out.println(System.nanoTime());
        System.out.println(esti);
    }
}