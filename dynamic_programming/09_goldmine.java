class Program {

  /*
   * Definition of function: it will return max gold than can be achieved by
   * starting from i, j
   */
  public static int maxGold(int[][] mine, int i, int j) {

    if (i < 0 || j < 0 || i == mine.length || j == mine[i].length) {
      return 0;
    }

    // digging top right diagonal
    int op1 = maxGold(mine, i - 1, j + 1);
    // digging straight right
    int op2 = maxGold(mine, i, j + 1);
    // digging down right diagonal
    int op3 = maxGold(mine, i + 1, j + 1);

    return Math.max(op1, Math.max(op2, op3)) + mine[i][j];
  }

  public static void main(String[] args) {
    // int[][] mine = {
    // { 1, 3, 1, 5 },
    // { 2, 2, 4, 1 },
    // { 5, 0, 2, 3 },
    // { 0, 6, 1, 2 }
    // };
    int[][] mine = { { 22, 69, 96, 81, 30 } };
    // int max_gold = 0;
    // for (int i = 0; i < mine.length; i++) {
    // int curr = maxGold(mine, i, 0);
    // max_gold = Math.max(max_gold, curr);
    // }

    // System.out.println(max_gold);
    int res = maxGoldTab(mine);
    System.out.println(res);
  }

  /*---------------------------------------___*/
  public static int dig(int[][] mine, int i, int j, int[][] dp) {

    if (i < 0 || j < 0 || i == mine.length || j == mine[i].length) {
      return 0;
    } else if (dp[i][j] != 0) {
      return dp[i][j];
    }

    // digging top right diagonal
    int op1 = dig(mine, i - 1, j + 1, dp);
    // digging straight right
    int op2 = dig(mine, i, j + 1, dp);
    // digging down right diagonal
    int op3 = dig(mine, i + 1, j + 1, dp);

    return dp[i][j] = Math.max(op1, Math.max(op2, op3)) + mine[i][j];
  }

  static int maxGold(int n, int m, int M[][]) {
    // code her
    int max_gold = 0;
    int[][] dp = new int[n][m];
    for (int i = 0; i < M.length; i++) {
      int curr = dig(M, i, 0, dp);
      max_gold = Math.max(max_gold, curr);
    }

    return max_gold;
  }
  // -----------------------------------------------------------------------//

  public static int maxGoldTab(int[][] mine) {
    int n = mine.length;
    int m = mine[0].length;

    int[][] dp = new int[n][m];

    // each cell of dp will contain max gold that can be achieved, if we start
    // digging from that cell
    // if we start digging from the last column , them the problem is smaller

    for (int j = m - 1; j >= 0; j--) {
      for (int i = 0; i < n; i++) {

        if (j == m - 1) {
          dp[i][j] = mine[i][j];
        } else if (i == 0 && n == 1) {
          dp[i][j] = dp[i][j + 1] + mine[i][j];
        } else if (i == 0 && n > 1) {
          dp[i][j] = Math.max(dp[i][j + 1], dp[i + 1][j + 1]) + mine[i][j];
        } else if (i == n - 1) {
          dp[i][j] = Math.max(dp[i][j + 1], dp[i - 1][j + 1]) + mine[i][j];
        } else {
          dp[i][j] = Math.max(dp[i - 1][j + 1], Math.max(dp[i][j + 1], dp[i + 1][j + 1])) + mine[i][j];
        }
      }
    }
    // we can start from any row of first column
    int max_gold = 0;

    for (int i = 0; i < dp.length; i++) {
      max_gold = Math.max(max_gold, dp[i][0]);
    }

    return max_gold;
  }
}
