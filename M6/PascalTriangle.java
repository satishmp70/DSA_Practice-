public class PascalTriangle {
    public int[][] solve(int A) {
        int ans[][] = new int[A][A];
        for (int i = 0; i < A; i++) {
            for (int j = 0; j <= i; j++) {
                if (j == 0 || i == j) {
                    ans[i][j] = 1;
                } else {
                    ans[i][j] = ans[i - 1][j] + ans[i - 1][j - 1];
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        PascalTriangle sol = new PascalTriangle();
        int[][] result = sol.solve(5);

        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
    }
}
