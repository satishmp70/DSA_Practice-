/*Problem Description

Given an array of integers A, find and return the count of divisors of each element of the array.

NOTE: The order of the resultant array should be the same as the input array.


Problem Constraints

1 <= length of the array <= 100000
1 <= A[i] <= 106



Input Format

The only argument given is the integer array A.

Output Format

Return the count of divisors of each element of the array in the form of an array.

Example Input

Input 1:

 A = [2, 3, 4, 5]
Input 2:

 A = [8, 9, 10]


Example Output

Output 1:

 [2, 2, 3, 2]
Output 1:

 [4, 3, 4]

Example Explanation

Explanation 1:

 The number of divisors of 2 : [1, 2], 3 : [1, 3], 4 : [1, 2, 4], 5 : [1, 5]
 So the count will be [2, 2, 3, 2].
Explanation 2:

 The number of divisors of 8 : [1, 2, 4, 8], 9 : [1, 3, 9], 10 : [1, 2, 5, 10]
 So the count will be [4, 3, 4].
*/

public class DivisorSolution {

    public int[] solve(int[] A) {

        int largest = Integer.MIN_VALUE;

        for (int i = 0; i < A.length; i++) {
            largest = Math.max(largest, A[i]);
        }

        int res[] = new int[A.length];
        int smallestPrime[] = getSmallestPrimeFactor(largest);

        for (int i = 0; i < A.length; i++) {
            int ele = A[i];
            int ans = 1;

            while (ele > 1) {
                int count = 0;
                int s = smallestPrime[ele];

                while (ele % s == 0) {
                    ele = ele / s;
                    count++;
                }

                ans = ans * (count + 1);
            }

            res[i] = ans;
        }

        return res;
    }

    public int[] getSmallestPrimeFactor(int n) {
        int spf[] = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            spf[i] = i;
        }

        for (int i = 2; i * i <= n; i++) {
            if (spf[i] == i) {
                for (int j = i * i; j <= n; j += i) {
                    if (spf[j] == j) {
                        spf[j] = i;
                    }
                }
            }
        }

        return spf;
    }

    public static void main(String[] args) {
        DivisorSolution sol = new DivisorSolution();
        int[] A = {8, 9, 20};
        int[] result = sol.solve(A);

        for (int val : result) {
            System.out.print(val + " ");
        }
    }
}
