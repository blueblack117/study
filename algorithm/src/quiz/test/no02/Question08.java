package quiz.test.no02;

/**
 * 자연수 k와 m이 매개변수로 주어집니다. 1부터 k까지의 자연수들을 하나씩 사용해서 만들 수 있는 수 중에서,
 * m의 배수의 개수를 return 하도록 solution 함수를 완성해주세요.
 *
 * 제한 사항
 * k는 1 이상 9 이하입니다.
 * m은 1 이상 1,000,000,000 이하입니다.
 *
 * 입출력 예
 * k	m	result
 * 3	2	2
 * 4	77	1
 * 5	1	120
 *
 * 입출력 예 설명
 *
 * 입출력 예 #1
 *
 * 1부터 3까지의 자연수를 하나씩 사용해서 만들 수 있는 수는 123, 132, 213, 231, 312, 321로 총 6개가 있습니다.
 * 이 중에서 2의 배수는 132와 312로 2개입니다.
 *
 * 입출력 예 #2
 *
 * 1부터 4까지의 자연수를 하나씩 사용해서 만들 수 있는 수는 1234, 1243, 1324, 1342, 1423, 1432, 2134, 2143, 2314, 2341,
 * 2413, 2431, 3124, 3142, 3214, 3241, 3412, 3421, 4123, 4132, 4213, 4231, 4312, 4321로 총 24개가 있습니다.
 * 이 중에서 77의 배수는 4312로 단 1개입니다.
 *
 * 입출력 예 #3
 *
 * 1부터 5까지의 자연수를 하나씩 사용해서 만들 수 있는 수는 총 120개가 있습니다.
 * 모든 자연수는 1의 배수이므로, 답은 120개입니다.
 */
public class Question08 {

    public static void main(String[] args) {
        Question08 alg = new Question08();
        System.out.println(alg.solution(3,2));
        System.out.println(alg.solution(4,77));
        System.out.println(alg.solution(5,1));
    }

    static int count = 0;

    public int solution(int k, int m) {
        count = 0;
        int[] numbers = new int[k];
        for (int inx=1; inx<=k; inx++) {
            numbers[inx-1] = inx;
        }
        doPermutation(numbers, 0, m);

        int answer = count;
        return answer;
    }

    public void doPermutation(int[] arr, int startIdx, int m){
        int length = arr.length;
        if (startIdx == length-1) {
            StringBuffer sb = new StringBuffer();
            for(int n: arr) {
                sb.append(n);
            }
            int permuteNumber = Integer.parseInt(sb.toString());
            if (permuteNumber % m == 0) {
                count++;
                System.out.println(permuteNumber);
            }
            return;
        }

        for(int i=startIdx; i<length; i++){
            swap(arr, startIdx, i);
            doPermutation(arr, startIdx+1, m);
            swap(arr, startIdx, i);
        }
    }

    public void swap(int[] arr, int n1, int n2){
        int temp = arr[n1];
        arr[n1] = arr[n2];
        arr[n2] = temp;
    }
}
