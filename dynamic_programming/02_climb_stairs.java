class Program {
  public static int climbStairsMem(int n, int[] cache) {
    if (n == 1 || n == 2) {
      return n;
    } else if (cache[n] != 0) {
      return cache[n];
    }

    return cache[n] = climbStairsMem(n - 1, cache) + climbStairsMem(n - 2, cache);
  }

  public static int climbStairsTab(int n) {

    int[] dp = new int[n + 1];
    /*
     * 1. create storage
     * 2. Meaning to storage: each cell of array contains no of ways to rech to top
     * from that stair
     */
    dp[n] = 1; // base case
    dp[n - 1] = 1;
    for (int i = n - 2; i >= 0; i--) {
      dp[i] = dp[i + 1] + dp[i + 2];
    }

    return dp[0];
  }

  public static void main(String[] args) {
    int res = climbStairsTab(6);
    System.out.println(res);
  }

}
