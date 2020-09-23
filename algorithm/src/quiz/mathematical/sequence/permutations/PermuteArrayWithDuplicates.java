package quiz.mathematical.sequence.permutations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * array : [10, 20, 30]
 *
 * Permuations are :
 *
 * [10, 10, 20]
 * [10, 20, 10]
 * [20, 10, 10]
 *
 */
public class PermuteArrayWithDuplicates {

    public static void main(String[] args) {
        PermuteArrayWithDuplicates pa=new PermuteArrayWithDuplicates();

        int[] arr= {10, 20, 10};

        List<List<Integer>> permute = pa.permute(arr);

        System.out.println("Permuations of array : [10, 20, 10] are:");
        System.out.println("=========================================");
        for(List<Integer> perm:permute)
        {
            System.out.println(perm);
        }

    }
    public List<List<Integer>> permute(int[] arr) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(arr);
        permuteHelper(list, new ArrayList<>(), arr,new boolean[arr.length]);
        return list;
    }

    private void permuteHelper(List<List<Integer>> list, List<Integer> resultList, int[] arr, boolean[] used){
        // Base case
        if(resultList.size() == arr.length){
            list.add(new ArrayList<>(resultList));
        } else {
            for(int i = 0; i < arr.length; i++) {
                if(used[i] || i > 0 && arr[i] == arr[i-1] && !used[i - 1]) {
                    // If element is already used
                    continue;
                }
                // choose element
                used[i] = true;
                resultList.add(arr[i]);

                // Explore
                permuteHelper(list, resultList, arr, used);

                // Unchoose element
                used[i] = false;
                resultList.remove(resultList.size() - 1);
            }
        }
    }
}
