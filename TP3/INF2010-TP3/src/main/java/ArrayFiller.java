import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class ArrayFiller {
    public static Integer[] getArray(String filename, int size) {
        Integer[] array = new Integer[size];
        File file = new File( "INF2010-TP3/src/" + filename);
        try {
            Scanner scan = new Scanner(file);
            int i = 0;
            while(scan.hasNext()){
                array[i] = Integer.parseInt(scan.next());
                ++i;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return array;
    }
}
