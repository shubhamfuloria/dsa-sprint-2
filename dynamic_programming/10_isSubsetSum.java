class Program {

  public static void main(String[] args) {
    int[] A = { 4, 2, 7, 1, 3 };
    // boolean res = isSubsetSum(A, A.length, 100);
    // boolean res = isSubsetSumMem(A, A.length, 10, new Boolean[A.length + 1][10 +
    // 1]);
    boolean res = isSubsetSumTab(A, A.length, 10);
    System.out.println(res);
  }

  public static boolean isSubsetSum(int[] A, int n, int sum) {
    if (sum == 0) {
      return true;
    } else if (n == 0 || sum < 0) {
      return false;
    }

    // including n - 1th element
    boolean op1 = isSubsetSum(A, n - 1, sum - A[n - 1]);
    // excluding n - 1th element
    boolean op2 = isSubsetSum(A, n - 1, sum);

    return op1 || op2;
  }

  public static boolean isSubsetSumMem(int[] A, int n, int sum, Boolean[][] store) {
    if (sum == 0) {
      return true;
    } else if (n == 0 || sum < 0) {
      return false;
    } else if (store[n][sum] != null) {
      return store[n][sum];
    }

    // including n - 1th element
    boolean op1 = isSubsetSumMem(A, n - 1, sum - A[n - 1], store);
    // excluding n - 1th element
    boolean op2 = isSubsetSumMem(A, n - 1, sum, store);

    return store[n][sum] = op1 || op2;
  }

  public static boolean isSubsetSumTab(int[] A, int n, int sum) {

    boolean[][] dp = new boolean[n + 1][sum + 1];

    for (int i = 0; i < n + 1; i++) {
      for (int j = 0; j < sum + 1; j++) {

        if (i == 0 && j == 0) {
          dp[i][j] = true;
        } else if (i == 0) {
          dp[i][j] = false;
        } else if (j == 0) {
          dp[i][j] = true;
        } else {
          if (A[i - 1] <= j) {
            dp[i][j] = dp[i - 1][j] || dp[i - 1][j - A[i - 1]];
          } else {
            dp[i][j] = dp[i - 1][j];
          }
        }
      }
    }

    return dp[n][sum];
  }
}