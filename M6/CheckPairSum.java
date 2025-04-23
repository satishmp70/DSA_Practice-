import java.util.Arrays;

public class CheckPairSum {
    public int solve(int A, int[] B) {
        Arrays.sort(B);
       int i = 0, j = B.length - 1;

        while (i < j) {
            int sum = B[i] + B[j];
            if (sum == A) return 1;
            else if (sum < A) i++;
            else j--;
        }
        return 0;
    }

    public static void main(String[] args) {
        CheckPairSum sol = new CheckPairSum();
        int[] B = {8,5,6,2,4, 9, 11,20};
        int result = sol.solve(9,B);
        System.out.println(result);
    }
}


