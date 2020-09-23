package quiz.mathematical.sequence.permutations;

import java.util.ArrayList;
import java.util.List;

public class Picture_Permute {

    public static void main(String[] args) {
        Picture_Permute pa=new Picture_Permute();

        String[] condition = new String[] {"N~F=0", "R~T>2"};
        System.out.println(pa.solution(2, condition));

        String[] condition2 = new String[] {"M~C<2", "C~M>1"};
        System.out.println(pa.solution(2, condition2));
    }

    public int solution(int n, String[] data) {
        int answer = 0;
        char[] arr= {'A', 'C', 'F', 'J', 'M', 'N', 'R', 'T'};
        List<List<Character>> permute = permute(arr);
        for(List<Character> perm : permute) {
            if (checkCondition(data, perm)) {
                answer++;
            }
        }
        return answer;
    }

    public boolean checkCondition(String[] data, List<Character> perm) {
        char compare;
        int c1, c2, digit;
        for(int i = 0 ; i < data.length ; i++) {
            c1 = perm.indexOf(data[i].charAt(0));
            c2 =  perm.indexOf(data[i].charAt(2));
            compare = data[i].charAt(3);
            digit = data[i].charAt(4)-'0';
            if(compare == '>') {
                if(Math.abs(c1-c2) -1 <= digit)
                    return false;
            }else if(compare == '<') {
                if(Math.abs(c1-c2) -1  >= digit)
                    return false;
            }else {
                if(Math.abs(c1-c2) - 1 != digit)
                    return false;
            }
        }
        return true;
    }

    public List<List<Character>> permute(char[] arr) {
        List<List<Character>> list = new ArrayList<>();
//        Arrays.sort(arr);
        permuteHelper(list, new ArrayList<>(), arr,new boolean[arr.length]);
        return list;
    }

    private void permuteHelper(List<List<Character>> list, List<Character> resultList, char [] arr, boolean [] used){

        // Base case
        if(resultList.size() == arr.length){
            list.add(new ArrayList<>(resultList));
        } else{
            for(int i = 0; i < arr.length; i++){
                if(used[i] || i > 0 && arr[i] == arr[i-1] && !used[i - 1])
                {
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
