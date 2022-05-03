class Program {

  public static int minCostClimbingStairs(int[] cost, int n, int pos) {

    if (pos == n) {
      return 0;
    } else if (n < pos) {
      return Integer.MAX_VALUE;
    }

    // we jumped one stair from the bottom
    int op1 = minCostClimbingStairs(cost, n, pos + 1);
    // we jumped two stairs from the bottom
    int op2 = minCostClimbingStairs(cost, n, pos + 2);

    return Math.min(op1, op2) + cost[pos];
  }

  public static int minCostClimbingStairsMem(int[] cost, int n, int pos, Integer[] dp) {

    if (pos == n) {
      return 0;
    } else if (n < pos) {
      return Integer.MAX_VALUE;
    }

    if (dp[n] != null) {
      return dp[n];
    }
    // we jumped one stair from the bottom
    int op1 = minCostClimbingStairs(cost, n, pos + 1);
    // we jumped two stairs from the bottom
    int op2 = minCostClimbingStairs(cost, n, pos + 2);

    return dp[n] = Math.min(op1, op2) + cost[pos];
  }

  public static int minCostClimbingStairsTab(int[] cost, int n) {

    int[] dp = new int[n + 1];

    dp[n] = 0;

    for (int i = n - 1; i >= 0; i--) {
      if (i == n - 1) {
        dp[i] = cost[i] + dp[i + 1];
      } else {
        dp[i] = Math.min(dp[i + 1], dp[i + 2]) + cost[i];
      }
    }

    return Math.min(dp[0], dp[1]);
  }

  public static void main(String[] args) {

    int[] cost = { 10, 5, 7, 15, 20 };
    int res1 = minCostClimbingStairs(cost, 5, 0);
    int res2 = minCostClimbingStairs(cost, 5, 1);
    // System.out.println(Math.min(res1, res2));
    int res = minCostClimbingStairsTab(cost, 5);
    System.out.println(res);
  }
}