package practice.image;

import java.util.ArrayList;

public class CosineSimilarity {

    public static double computeCosSim(ArrayList<Item> itemsA, ArrayList<Item> itemsB) {
        double up = 0d;
        double down = 0d;

        int lenOfA = itemsA.size();
        int lenOfB = itemsB.size();

        int bottomA = 0;
        int bottomB = 0;

        int currentA = 0, currentB = 0;
        while (currentA < lenOfA && currentB < lenOfB) {
            if (itemsA.get(currentA).item == itemsB.get(currentB).item) {
                up += itemsA.get(currentA).rate * itemsB.get(currentB).rate;
                bottomA += Math.pow(itemsA.get(currentA++).rate, 2);
                bottomB += Math.pow(itemsB.get(currentB++).rate, 2);

            } else if (itemsA.get(currentA).item > itemsB.get(currentB).item) {
                bottomB += Math.pow(itemsB.get(currentB++).rate, 2);
            } else {
                bottomA += Math.pow(itemsA.get(currentA++).rate, 2);
            }
        }

        while (currentA < lenOfA)
            bottomA += Math.pow(itemsA.get(currentA++).rate, 2);

        while (currentB < lenOfB)
            bottomB += Math.pow(itemsB.get(currentB++).rate, 2);

        return up / (Math.sqrt(bottomA) * Math.sqrt(bottomB));
    }

    static class Item {
        int item;
        int rate;

        public Item(int item, int rate) {
            this.item = item;
            this.rate = rate;
        }
    }

    public static double computeCosSim(int len, double[] v_a, double[] v_b) {
        double up = 0d;
        double bottom = 0d;
        double bottom_a = 0d;
        double bottom_b = 0d;
        for (int i=0; i<len; i++) {
            double aValue = v_a[i];
            double bValue = v_b[i];

            if (aValue != 0 && bValue != 0) {
                up += (aValue * bValue);
            }
            if (aValue != 0) {
                bottom_a += Math.pow(aValue, 2);
            }
            if (bValue != 0) {
                bottom_b += Math.pow(bValue, 2);
            }
        }
        bottom = Math.sqrt(bottom_a) * Math.sqrt(bottom_b);
        return up / bottom;
    }

    /**
     * Method to calculate cosine similarity between two documents.
     * @param docVector1 : document vector 1 (a)
     * @param docVector2 : document vector 2 (b)
     * @return
     */
    public double cosineSimilarity(double[] docVector1, double[] docVector2)
    {
        double dotProduct = 0.0;
        double magnitude1 = 0.0;
        double magnitude2 = 0.0;
        double cosineSimilarity = 0.0;

        for (int i = 0; i < docVector1.length; i++) //docVector1 and docVector2 must be of same length
        {
            dotProduct += docVector1[i] * docVector2[i];  //a.b
            magnitude1 += Math.pow(docVector1[i], 2);  //(a^2)
            magnitude2 += Math.pow(docVector2[i], 2); //(b^2)
        }

        magnitude1 = Math.sqrt(magnitude1);//sqrt(a^2)
        magnitude2 = Math.sqrt(magnitude2);//sqrt(b^2)

        if (magnitude1 != 0.0 | magnitude2 != 0.0)
        {
            cosineSimilarity = dotProduct / (magnitude1 * magnitude2);
        }
        else
        {
            return 0.0;
        }
        return cosineSimilarity;
    }
}
