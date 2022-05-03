class Program {

  public static int climbStairs(int n, int pos, int[] A) {

    if (pos == n) {
      return 1;
    } else if (n < pos) {
      return 0;
    }

    int total_paths = 0;

    for (int i = 0; i < A[pos]; i++) {
      total_paths += climbStairs(n, pos + A[pos], A);
    }
    return total_paths;
  }

  public static int climbStairsTab(int n, int[] A) {
    int[] dp = new int[n + 1];
    // Each cell will contain no of ways to reach to top from that cell

    dp[n] = 1;


    for(int i = n - 1; i >= 0; i--) {
      for(int j = 1; j <= A[i] && i + j < n + 1; j++) {
        dp[i] += dp[i + j];
      }
    }

    return dp[0];
  }

  public static void main(String[] args) {
    int[] A = { 2, 3, 0, 2 };
    int res = climbStairsTab(4, A);
    System.out.println(res);
  }
}