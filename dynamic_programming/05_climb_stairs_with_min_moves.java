class Program {

  public static int climbStairsWithMinMoves(int n, int[] A) {

    int[] dp = new int[n + 1];

    // each cell of dp will contain min moves required to reach to top from that
    // cell

    // 0 moves are required to reach to top, as we are already on top
    dp[n] = 0;

    for (int i = n - 1; i >= 0; i--) {

      int min_moves = Integer.MAX_VALUE - 1;

      for (int j = 1; j <= A[i] && i + j < n + 1; j++) {
        min_moves = Math.min(dp[i + j] + 1, min_moves);
      }

      dp[i] = min_moves;
    }
    return dp[0];
  }

  public static int climb(int n, int[] A, int pos) {

    if (pos == n) {
      return 0;
    } else if (n < pos) {
      return Integer.MAX_VALUE - 1;
    }

    int min_moves = Integer.MAX_VALUE - 1;
    for (int i = 1; i <= A[pos]; i++) {
      int moves = climb(n, A, pos + i);
      min_moves = Math.min(min_moves, moves + 1);
    }
    return min_moves;
  }

  public static void main(String[] args) {
    int[] A = { 2, 3, 0, 2 };
    int res = climbStairsWithMinMoves(4, A);
    // int res = climb(4, A, 0);
    System.out.println(res);
  }
}