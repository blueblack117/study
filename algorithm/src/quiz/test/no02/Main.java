package quiz.test.no02;

public class Main {
    static int count = 0;
    static int s;
    public static void main(String[] args) throws Exception {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st;
//
//        st = new StringTokenizer(br.readLine());
//        int n = Integer.parseInt(st.nextToken());
//        s = Integer.parseInt(st.nextToken());

        int[] arr = new int[] {1, 2, 3, 5};
//        st = new StringTokenizer(br.readLine());
//
//        for(int i=0; i<n; i++)
//            arr[i] = Integer.parseInt(st.nextToken());

        powerSet(arr, 4, 0, 0);
        // s가 0 일때는 부분집합 중에 공집합인 경우도 카운트 될 수 있음
        if(s == 0)
            count--;
        System.out.println(count);
    }

    static void powerSet(int[] arr, int n, int idx, int sum) {
        if(idx == n) {
            if(sum == s)
                count++;
            return;
        }

        powerSet(arr, n, idx + 1, sum);
        powerSet(arr, n, idx + 1, sum + arr[idx]);
    }
}
