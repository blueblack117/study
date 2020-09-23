package practice.image;

import java.util.Arrays;

public class CosineSimilarityTest {
    public static double similarity(int vec1[], int vec2[]) {
        int dop = vec1[0] * vec2[0] + vec1[1] * vec2[1];
        double mag1 = Math.sqrt(Math.pow(vec1[0], 2) + Math.pow(vec1[1], 2));
        double mag2 = Math.sqrt(Math.pow(vec2[0], 2) + Math.pow(vec2[1], 2));
        double csim = dop / (mag1 * mag2);

        return csim;
    }


    public static double similarity(double vec1[], double vec2[]) {
        double dop = vec1[0] * vec2[0] + vec1[1] * vec2[1];
        double mag1 = Math.sqrt(Math.pow(vec1[0], 2) + Math.pow(vec1[1], 2));
        double mag2 = Math.sqrt(Math.pow(vec2[0], 2) + Math.pow(vec2[1], 2));
        double csim = dop / (mag1 * mag2);

        return csim;
    }


    public static void main(String[] args) {
        int vector1[] = {1, 2};
        int vector2[] = {4, 5};
        double csim1 = CosineSimilarityTest.similarity(vector1, vector2);

        System.out.println("\n Cosine  similarity between two 2D vectors");
        System.out.println("integer 2D vectors");
        System.out.println("Vector 1 :" + Arrays.toString(vector1));
        System.out.println("Vector 2 :" + Arrays.toString(vector2));
        System.out.println("similarity value :" + csim1);


        double vector3[] = {5.2, 2.6};
        double vector4[] = {9.8, 7.6};
        System.out.println("double 2D vectors");
        double csim2 = CosineSimilarityTest.similarity(vector3, vector4);
        System.out.println("Vector 1 :" + Arrays.toString(vector3));
        System.out.println("Vector 2 :" + Arrays.toString(vector4));
        System.out.println("similarity value :" + csim2);
    }
}
