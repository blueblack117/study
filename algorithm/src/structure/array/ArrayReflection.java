package structure.array;

import java.lang.reflect.Array;

public class ArrayReflection {

    public static void main (String args[]) {
        int size[] = {3, 3};
        int arr[][] = (int[][]) Array.newInstance(int.class, size);
        System.out.println("The two-dimensional array is:");
        for(int[] i: arr) {
            for(int j: i ) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }
}
