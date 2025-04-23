/*
Given a sorted array of integers (not necessarily distinct) A and an integer B, find and return how many pair of integers ( A[i], A[j] ) such that i != j have sum equal to B.

Since the number of such pairs can be very large, return number of such pairs modulo (109 + 7).



Problem Constraints

1 <= |A| <= 100000

1 <= A[i] <= 10^9

1 <= B <= 10^9



Input Format

The first argument given is the integer array A.

The second argument given is integer B.



Output Format

Return the number of pairs for which sum is equal to B modulo (10^9+7).



Example Input

Input 1:

A = [1, 1, 1]
B = 2
Input 2:

A = [1, 5, 7, 10]
B = 8


Example Output

Output 1:

 3
Output 2:

 1


Example Explanation

Explanation 1:

 The pairs of A[i] and A[j] which sum up to 2 are (0, 1), (0, 2) and (1, 2).
 There are 3 pairs.
Explanation 2:

 There is only one pair, such that i = 0, and j = 2 sums up to 8.
 */

public class PairsWithSum {
    public int solve(int[] A, int B) {
        int n = A.length;
        int i = 0, j = A.length - 1;
        long ans=0;
        int mod=1000000007;
        while (i < j) {
            int sum = A[i] + A[j];
            if (sum == B) {
                if(A[i]==A[j]){
                    int count = j-i+1;
                    ans= (ans+ ((long)count*(count-1))/2)%mod;
                    break;
                }
                int counti=0;
                for(int x=i;x<j;x++){
                    if(A[x]==A[i]){
                        counti++;
                    }else{
                        break;
                    }
                }
                int countj=0;
                for(int x=j;x>i;x--){
                    if(A[x]==A[j]){
                        countj++;
                    }else{
                        break;
                    }
                }
                ans= (ans+ (long)counti*countj)%mod;
                i=i+counti;
                j=j-countj;
            }
            else if(sum<B) i++;
            else{
              j--;
            }
        }
        return (int)ans;
    }
    public static void main(String[] args) {
        PairsWithSum sol = new PairsWithSum();
        int[] B = {1,1,1};
        int result = sol.solve(B,2);
        System.out.println(result);
    }
}
