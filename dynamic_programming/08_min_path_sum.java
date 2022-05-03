class Program {

  public static int minPathSum(int[][] cost, int i, int j, Integer[][] dp) {
    if (i == cost.length - 1 && j == cost[0].length - 1) {
      return cost[i][j];
    } else if (i == cost.length || j == cost[0].length) {
      return Integer.MAX_VALUE;
    } else if (dp[i][j] != null) {
      return dp[i][j];
    }

    // moving right
    int op1 = minPathSum(cost, i, j + 1, dp);
    // moving down
    int op2 = minPathSum(cost, i + 1, j, dp);

    return dp[i][j] = Math.min(op1, op2) + cost[i][j];
  }

  public static int minPathSumTab(int[][] cost) {

    int m = cost.length;
    int n = cost[0].length;

    int[][] dp = new int[m][n];

    for (int i = m - 1; i >= 0; i--) {
      for (int j = n - 1; j >= 0; j--) {
        if (i == m - 1 && j == n - 1) {
          dp[i][j] = cost[i][j];
        } else if (i == m - 1) {
          // we cannot move to down
          dp[i][j] = dp[i][j + 1] + cost[i][j];
        } else if (j == n - 1) {
          // we cannot move to right
          dp[i][j] = dp[i + 1][j] + cost[i][j];
        } else {
          // we can move either side (right or bottom)
          dp[i][j] = Math.min(dp[i][j + 1], dp[i + 1][j]) + cost[i][j];
        }
      }
    }
    return dp[0][0];

  }

  public static void main(String[] args) {
    int[][] cost = {
        { 1, 3, 1 },
        { 1, 5, 1 },
        { 4, 2, 1 } };

    int res = minPathSumTab(cost);
    System.out.println(res);
  }
}